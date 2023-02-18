package com.letsprogramming.shop.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
@Entity
@Table(name = "review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_index")
    private long reviewIndex;

    @Positive
    @Column(name = "product_index")
    private long productIndex;

    @NotEmpty
    @Column(name = "content")
    private String content;

    @Column(name = "star")
    private int star;

    @Column(name = "image_path")
    private String imagePath;

    @Column(name = "create_datetime")
    @Convert(converter = DateTimeConverter.class)
    private OffsetDateTime createDateTime;

    @Column(name = "update_datetime")
    @Convert(converter = DateTimeConverter.class)
    private OffsetDateTime updateDateTime;

    public void setContent(String content) {
        this.content = content.trim();
    }
}
