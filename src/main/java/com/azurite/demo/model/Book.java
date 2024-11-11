package com.azurite.demo.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Book {
    private String tipoLivro;
    private String estante;
    private String idioma;
    private String titulo;
    private String autor;
    private String editora;
    private int ano;
    private int edicao;
    private BigDecimal preco;
    private int peso;
    private String descricao;
    private String capa;
}
