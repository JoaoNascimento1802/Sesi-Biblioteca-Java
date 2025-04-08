package sesi.biblioteca.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;
import sesi.biblioteca.dto.BookDTO;
import sesi.biblioteca.entities.Books;
import sesi.biblioteca.repository.BookRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    private static final String CACHE_ARRAY = "booksArray";

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CacheManager cacheManager;

    public List<BookDTO> getBooksFromCache() {
        Cache cache = cacheManager.getCache(CACHE_ARRAY);
        List<BookDTO> lista = cache != null ? cache.get("lista", List.class) : null;

        if (lista == null) {
            List<BookDTO> livros = bookRepository.findAll().stream()
                    .map(this::toDTO)
                    .collect(Collectors.toList());

            if (cache != null) cache.put("lista", livros);
            return livros;
        }

        return lista;
    }

    public void addBookToCacheAndDB(BookDTO dto) {
        Books book = new Books();
        book.setTitulo(dto.titulo());
        book.setAutor(dto.autor());
        book.setDataEmprestimo(dto.dataEmprestimo());

        Books saved = bookRepository.save(book);
        BookDTO novo = toDTO(saved);

        List<BookDTO> lista = getBooksFromCache();
        lista.add(novo);

        Cache cache = cacheManager.getCache(CACHE_ARRAY);
        if (cache != null) cache.put("lista", lista);
    }

    public void updateBookInCacheAndDB(BookDTO dto) {
        Books book = bookRepository.findById(dto.id())
                .orElseThrow(() -> new RuntimeException("Livro não encontrado"));

        book.setTitulo(dto.titulo());
        book.setAutor(dto.autor());
        book.setDataEmprestimo(dto.dataEmprestimo());

        Books atualizado = bookRepository.save(book);
        BookDTO atualizadoDTO = toDTO(atualizado);

        List<BookDTO> lista = getBooksFromCache();
        List<BookDTO> novaLista = lista.stream()
                .map(l -> l.id().equals(dto.id()) ? atualizadoDTO : l)
                .collect(Collectors.toList());

        Cache cache = cacheManager.getCache(CACHE_ARRAY);
        if (cache != null) cache.put("lista", novaLista);
    }

    private BookDTO toDTO(Books book) {
        return new BookDTO(book.getId(), book.getTitulo(), book.getAutor(), book.getDataEmprestimo());
    }



}
