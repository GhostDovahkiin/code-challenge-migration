package com.example.dummyjson.service;

import com.example.dummyjson.dto.Product;
import com.example.dummyjson.dto.ProductList;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

/**
 * Classe que contém a lógica por trás dos requests, utiliza o Bean do Webclient por injeção de dependência e trás os resultados via /products ou products/id
 * 
 * @author Pedro
 * @version 1.0
 */
@Service
@RequiredArgsConstructor
public class ProductService {

    private final WebClient webClient;

    public List<Product> getAllProducts() {
        ProductList products = webClient.get()
            .retrieve()
            .bodyToMono(ProductList.class)
        .block();

        return products.getProducts();
    }

    public Product getProductById(Long id) {
        return webClient.get()
            .uri("/{id}", id)
            .retrieve()
            .bodyToMono(Product.class)
        .block();
    }
}
