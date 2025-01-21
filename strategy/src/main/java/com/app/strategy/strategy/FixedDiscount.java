package com.app.strategy.strategy;



import com.app.strategy.model.Product;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class FixedDiscount implements Discount {
    private static final String DISCOUNT_NAME = "FIXED_DISCOUNT";
    private static final BigDecimal FIXED_DISCOUNT = BigDecimal.valueOf(10);

    @Override
    public BigDecimal calculateDiscount(Product product) {
        return product.value().subtract(FIXED_DISCOUNT);
    }

    @Override
    public boolean getDiscount(Product product) {
        return product.discountType().equalsIgnoreCase(DISCOUNT_NAME);
    }
}
