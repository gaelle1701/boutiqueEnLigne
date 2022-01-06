package com.boutiqueEnLigne.fngcine.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 50)
    private String label;

    @NotBlank
    @Size(max = 150)
    private String description;

    private String url_img;

    @NotBlank
    @Size(max=20)
    private String genre;

    @NotNull
    private float unit_price;

    @NotNull
    private int qty_stock;
}
