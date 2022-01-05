package com.boutiqueEnLigne.fngcine.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String label;
    private String description;
    private String url_img;
    private String genre;
    private float unit_price;
    private int qty_stock;
}
