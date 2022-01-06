package com.boutiqueEnLigne.fngcine.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.*;

@Entity
@Data
@NoArgsConstructor
@Table(name= "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date order_date;
    private String receiver;
    private String delivery_address;
    private float shipping_fee;

    @ManyToOne
    private Delivery delivery;

    @ManyToOne
    private User user;
}
