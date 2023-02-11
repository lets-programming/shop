package com.letsprogramming.shop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_index")
    private long productIndex;

    @Column(name = "title")
    private String title;

    @Column(name = "price")
    private int price;

    @Column(name = "image_path")
    private String imagePath;
}
