package com.boutiqueEnLigne.fngcine.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

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
    private String description;

    @Basic()
    @Temporal(TemporalType.DATE)
    private Date releaseDate;

    private String urlImg;

    @NotBlank
    @Size(max=20)
    private String genre;

    @NotNull
    private float unitPrice;

    @NotNull
    private int qtyStock;

    public Product(long id, String label, String description, Date releaseDate, String urlImg, String genre, float unitPrice, int qtyStock) {
        this.id = id;
        this.label = label;
        this.description = description;
        this.releaseDate = releaseDate;
        this.genre =genre;
        this.unitPrice = unitPrice;
        this.qtyStock = qtyStock;
    }

}
