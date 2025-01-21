package com.app.strategy.strategy;

import com.app.strategy.model.Product;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class PercentDiscount implements Discount {
    private static final String DISCOUNT_NAME = "PERCENT_DISCOUNT";
    private static final BigDecimal DISCOUNT_PERCENT = BigDecimal.valueOf(10);

    @Override
    public BigDecimal calculateDiscount(Product product) {
        BigDecimal discount = product.value().multiply(DISCOUNT_PERCENT.divide(BigDecimal.valueOf(100)));

        return product.value().subtract(discount);
    }

    @Override
    public boolean getDiscount(Product product) {
        return product.discountType().equalsIgnoreCase(DISCOUNT_NAME);
    }
}
