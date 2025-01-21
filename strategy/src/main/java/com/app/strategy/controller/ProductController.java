package com.app.strategy.controller;

import com.app.strategy.model.Product;
import com.app.strategy.service.DiscountService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/discount")
public class ProductController {

    public final DiscountService service;

    public ProductController(DiscountService service) {
        this.service = service;
    }

    @PostMapping()
    public Product getProduct(@RequestBody Product product) {
        return this.service.getDiscount(product);
    }

}
