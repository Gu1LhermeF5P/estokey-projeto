package com.estokey.estokey_projeto.service;

import org.springframework.stereotype.Service;

import com.estokey.estokey_projeto.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StockService {

    private final List<Product> stock = new ArrayList<>();
    private long nextId = 1;

    // Retorna todos os produtos do estoque
    public List<Product> getAllProducts() {
        return stock;
    }

    // Adiciona um novo produto ao estoque
    public Product addProduct(Product product) {
        product.setId(nextId++);
        stock.add(product);
        return product;
    }

    // Busca um produto pelo ID
    public Optional<Product> getProductById(Long id) {
        return stock.stream().filter(p -> p.getId().equals(id)).findFirst();
    }
}
