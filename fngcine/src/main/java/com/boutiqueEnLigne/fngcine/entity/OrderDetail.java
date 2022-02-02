package com.boutiqueEnLigne.fngcine.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class OrderDetail{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private float unitPrice;

    @NotNull
    private float priceByQty;

    @ManyToOne(fetch=FetchType.LAZY)
    private Order order;

    @ManyToOne(fetch=FetchType.LAZY)
    private Product product;

    @NotNull
    private int quantity;

    public OrderDetail(Long id, float unitPrice, float priceByQty, int quantity) {
        this.id = id;
        this.unitPrice = unitPrice;
        this.priceByQty = priceByQty;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public float getPriceByQty() {
        return priceByQty;
    }

    public void setPriceByQty(float priceByQty) {
        this.priceByQty = this.unitPrice * this.quantity;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
