package com.app.strategy.strategy;

import com.app.strategy.model.Product;

import java.math.BigDecimal;

public interface Discount {
    BigDecimal calculateDiscount(Product product);

    boolean getDiscount(Product product);
}
