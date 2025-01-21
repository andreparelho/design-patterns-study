package com.app.strategy.model;

import java.math.BigDecimal;

public record Product(String name, BigDecimal value, String discountType) {

    public static Product createProduct(String name, String discountType) {
        return new Product(name, BigDecimal.valueOf(0), discountType);
    }

    public static Product updateProduct(String name, BigDecimal value, String discountType) {
        return new Product(name, value, discountType);
    }
}
