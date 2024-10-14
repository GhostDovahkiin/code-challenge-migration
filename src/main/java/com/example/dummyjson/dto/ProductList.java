package com.example.dummyjson.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * Classe wrapper do conteúdo vindo do JsonDummy.
 * Esta classe contém a lista de Produtos.
 * 
 * @author Pedro
 * @version 1.0
 */
@Getter
@Setter
public class ProductList {
    private List<Product> products;
}
