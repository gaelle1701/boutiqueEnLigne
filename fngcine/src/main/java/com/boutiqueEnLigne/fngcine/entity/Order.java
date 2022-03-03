package com.boutiqueEnLigne.fngcine.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.*;

@Entity
@Getter
@Setter
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

    @NotNull
    private float totalPrice;

    @NotBlank
    @Size(min = 2, max = 80)
    private String address;

    @NotBlank
    @Size(min = 2, max = 10)
    private String zipCode;

    @NotBlank
    @Size(min = 2, max = 80)
    private String city;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch=FetchType.LAZY)
    private Delivery delivery;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch= FetchType.LAZY)
    private User user;


    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToMany(fetch= FetchType.LAZY)
    private List<OrderDetail> orderDetailList = new ArrayList<OrderDetail>();

}
