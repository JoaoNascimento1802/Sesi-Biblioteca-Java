package sesi.biblioteca.dto;

import java.time.Instant;

public record BookDTO(Long id, String titulo, String autor, Instant dataEmprestimo) {
}
