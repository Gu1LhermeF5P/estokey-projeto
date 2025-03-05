package com.estokey.estokey_projeto.controller;

import com.estokey.estokey_projeto.model.Product;
import com.estokey.estokey_projeto.service.StockService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stock")
public class StockController {

    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    // Retorna todos os produtos no estoque
    @GetMapping
    public ResponseEntity<List<Product>> index() {
        return ResponseEntity.ok(stockService.getAllProducts());
    }

    // Adiciona um novo produto ao estoque
    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product product) {
        return ResponseEntity.ok(stockService.addProduct(product));
    }

    // Retorna um produto pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<Product> get(@PathVariable Long id) {
        return stockService.getProductById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
