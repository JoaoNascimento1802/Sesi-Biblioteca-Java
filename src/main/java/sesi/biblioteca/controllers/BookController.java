package sesi.biblioteca.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sesi.biblioteca.dto.BookDTO;
import sesi.biblioteca.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;


    @GetMapping("/cache")
    public ResponseEntity<List<BookDTO>> getArrayCache() {
        return ResponseEntity.ok(bookService.getBooksFromCache());
    }


    @PostMapping("/cache")
    public ResponseEntity<Void> adicionarLivro(@RequestBody BookDTO dto) {
        bookService.addBookToCacheAndDB(dto);
        return ResponseEntity.ok().build();
    }


    @PutMapping("/cache")
    public ResponseEntity<Void> atualizarLivro(@RequestBody BookDTO dto) {
        bookService.updateBookInCacheAndDB(dto);
        return ResponseEntity.ok().build();
    }
}
