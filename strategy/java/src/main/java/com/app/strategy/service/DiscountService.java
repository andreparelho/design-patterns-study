package com.app.strategy.service;

import com.app.strategy.model.Product;
import com.app.strategy.strategy.Discount;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class DiscountService {

    private final List<Discount> discounts;

    public DiscountService(List<Discount> discounts) {
        this.discounts = discounts;
    }

    public Product getDiscount(Product product) {
        AtomicReference<Product> response = new AtomicReference<>(Product.createProduct(product.name(), product.discountType()));

        discounts.forEach(discount -> {
            var isDiscountAvailable = discount.getDiscount(product);

            if (isDiscountAvailable) {
                var productWithDiscount = discount.calculateDiscount(product);
                response.set(Product.updateProduct(product.name(), productWithDiscount, product.discountType()));
            }
        });

        return response.get();
    }
}
