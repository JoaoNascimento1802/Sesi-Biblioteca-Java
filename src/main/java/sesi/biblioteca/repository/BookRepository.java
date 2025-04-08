package sesi.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sesi.biblioteca.entities.Books;

public interface BookRepository extends JpaRepository<Books, Long> {
}
