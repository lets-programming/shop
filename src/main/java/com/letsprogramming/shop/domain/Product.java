package com.letsprogramming.shop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.List;

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

    @Column(name = "create_datetime")
    @Convert(converter = DateTimeConverter.class)
    private OffsetDateTime createDateTime;

    @Column(name = "update_datetime")
    @Convert(converter = DateTimeConverter.class)
    private OffsetDateTime updateDateTime;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_index", referencedColumnName = "product_index", insertable = false, updatable = false)
    private List<Review> reviews;
}
