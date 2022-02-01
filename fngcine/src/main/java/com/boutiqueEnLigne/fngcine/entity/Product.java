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
    private String description;

    private String urlImg;

    @NotBlank
    @Size(max=20)
    private String genre;

    @NotNull
    private float unitPrice;

    @NotNull
    private int qtyStock;

    public Product(long id, String label, String description, String urlImg, String genre, float unitPrice, int qtyStock) {
        this.id = id;
        this.label = label;
        this.description = description;
        this.genre =genre;
        this.unitPrice = unitPrice;
        this.qtyStock = qtyStock;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", label='" + label + '\'' +
                ", description='" + description + '\'' +
                ", urlImg='" + urlImg + '\'' +
                ", genre='" + genre + '\'' +
                ", unitPrice=" + unitPrice +
                ", qtyStock=" + qtyStock +
                '}';
    }
}
