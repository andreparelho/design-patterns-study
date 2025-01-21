package com.app.strategy.strategy;

import com.app.strategy.model.Product;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class NoDiscount implements Discount {
    private static final String DISCOUNT_NAME = "NO_DISCOUNT";

    @Override
    public BigDecimal calculateDiscount(Product product) {
        return product.value();
    }

    @Override
    public boolean getDiscount(Product product) {
        return product.discountType().equalsIgnoreCase(DISCOUNT_NAME);
    }
}
