package com.boutiqueEnLigne.fngcine.controller;

import com.boutiqueEnLigne.fngcine.entity.Product;
import com.boutiqueEnLigne.fngcine.repository.ProductRepository;
import com.boutiqueEnLigne.fngcine.repository.UserRepository;
import com.boutiqueEnLigne.fngcine.service.ProductService;
import com.boutiqueEnLigne.fngcine.service.UserService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Access;
import java.util.List;

@RestController
@Getter
@Setter
@RequestMapping("api/products")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("")
    public ResponseEntity<List<Product>> getProducts(@RequestParam(required = false) String genre) {
        List<Product> products;
        if (genre != null)  {
            products = productService.getProductsByGenre(genre);
        } else {
            products = productService.getProducts();
        }
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable("id") Long id) {
        return productService.getProduct(id);
    }


    @GetMapping("/new_movies")
    public ResponseEntity<Page<Product>> getProductsByDate() {
        Page<Product> productList = productRepository.findAll(PageRequest.of(0, 2, Sort.by(Sort.Direction.DESC, "releaseDate")));
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

}
