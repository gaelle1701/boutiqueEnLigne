package com.boutiqueEnLigne.fngcine.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.*;

@Entity
@Data
@NoArgsConstructor
@Table(name= "orders")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic()
    @Temporal(TemporalType.DATE)
    private Date orderDate;

    @NotBlank
    @Size(min = 2, max = 80)
    private String receiver;

    @NotBlank
    @Size(min = 2, max = 80)
    private String deliveryAddress;

    @NotNull
    private float totalPrice;

    //Prix total commande

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch=FetchType.LAZY)
    private Delivery delivery;

//    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
//    @ManyToOne(fetch=FetchType.LAZY)
//    private User user;



}
