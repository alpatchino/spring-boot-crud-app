package com.alpatchino.orders;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.io.Serializable;
import java.math.BigDecimal;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by patri on 22/09/2017.
 *
 * Think before using @Entity, does it have an identity?
 * or could it be replaced? If it can then it should a
 * value object instead.
 */
@Embeddable
public class OrderItem implements Serializable {

    private Integer amount;
    private String product;
    private BigDecimal price;

    // JPA recommends it but it is useless
    protected OrderItem() {

    }

    private OrderItem(Integer amount, String product, BigDecimal price) {
        this.amount = amount;
        this.product = product;
        this.price = price;
    }

    public static OrderItem of(Integer amount, String product, BigDecimal price) {
        checkNotNull(amount);
        checkNotNull(price);
        checkNotNull(product);
        return new OrderItem(amount, product, price);
    }

    // getters but not setters as its unlikely that we'll ever change
    // these values once they have been assigned
    public Integer getAmount() {
        return amount;
    }

    public String getProduct() {
        return product;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
