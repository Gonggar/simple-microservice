package edu.bjtu.microservice.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import edu.bjtu.microservice.product.entity.Product;
import edu.bjtu.microservice.product.service.ProductService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/product")
    public List<Product> index() {
        List<Product> res = productService.getProducts();
        return res;
    }

    @PostMapping("/product")
    public Product create(@RequestBody @Valid Product product){
        return productService.saveProduct(product);
    }

    @GetMapping("/product/{id}")
    public Product view(@PathVariable("id") long id){
        Product p = productService.getProduct(id).get();
        return p;
    }

    @PostMapping(value = "/product/{id}")
    public Product edit(@PathVariable("id") long id, @RequestBody @Valid Product product){

        //Optional<Product> updatedProduct 
        Product p= productService.getProduct(id).get();
        
        p.setName(product.getName());
        p.setPrice(product.getPrice());
        p.setDescription(product.getDescription());

        return productService.saveProduct(p);
    }

}
