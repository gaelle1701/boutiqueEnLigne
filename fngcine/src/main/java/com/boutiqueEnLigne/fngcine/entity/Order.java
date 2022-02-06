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

    @NotBlank
    @Size(min = 2, max = 80)
    private String deliveryAddress;

    @NotNull
    private float totalPrice;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch=FetchType.LAZY)
    private Delivery delivery;

    @NotNull
    private Long userId;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToMany(fetch= FetchType.LAZY)
    private List<OrderDetail> orderDetailList = new ArrayList<OrderDetail>();

}
