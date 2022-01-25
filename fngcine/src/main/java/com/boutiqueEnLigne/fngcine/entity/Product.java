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
@Table(name ="products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 50)
    private String label;

    @NotBlank
    @Size(max = 255)
    private String description;

    private String urlImg;

    @NotBlank
    @Size(max=20)
    private String genre;

    @NotNull
    private float unitPrice;

    @NotNull
    private int qtyStock;
}
