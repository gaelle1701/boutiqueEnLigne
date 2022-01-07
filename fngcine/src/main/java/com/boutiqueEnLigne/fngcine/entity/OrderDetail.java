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

}
