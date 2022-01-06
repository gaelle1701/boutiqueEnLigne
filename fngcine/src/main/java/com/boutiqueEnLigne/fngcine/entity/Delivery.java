package com.boutiqueEnLigne.fngcine.entity;

import javax.persistence.*;

@Entity
@Table(name = "deliveries")
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private EnumDelivery delivery;

    public Delivery() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public EnumDelivery getDelivery() {
        return delivery;
    }

    public void setDelivery(EnumDelivery delivery) {
        this.delivery = delivery;
    }
}
