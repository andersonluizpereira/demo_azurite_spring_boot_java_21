package com.azurite.demo.dto;

import java.math.BigDecimal;

public record BookDto(String isbn,
                      String tipo_livro,
                      String estante,
                      String idioma,
                      String titulo,
                      String autor,
                      String editora,
                      int ano,
                      int edicao,
                      BigDecimal preco,
                      int peso,
                      String descricao,
                      String capa
) {
}
