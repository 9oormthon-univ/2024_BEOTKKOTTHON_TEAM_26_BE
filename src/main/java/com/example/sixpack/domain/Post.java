package com.example.sixpack.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;

    @Column(nullable = false)
    private String img_url;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String explanation;

    @Column(nullable = false)
    private String fund_start_date;

    @Column(nullable = false)
    private String fund_end_date;

    @Column(nullable = false)
    private int market_place; // 나와 가게사이의 거리

    @Column(nullable = false)
    private String fund_company;

    @Column(nullable = false)
    private String company_introduce;

    @Column(nullable = false)
    private int percent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;


    @OneToMany(mappedBy = "post", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<Funded_post> fundedPost = new ArrayList<>();


    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Linked_image> linkedImages = new ArrayList<>();

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HashTag> hashTags = new ArrayList<>();
    public Post(Long id, String img_url, String title, String explanation
                , String fund_start_date,
                String fund_end_date, int market_place, String fund_company,
                int percent, Category category,
                LocalDateTime createdAt, List<Funded_post> fundedPost, List<Linked_image> linked_images, String company_introduce ) {
        this.id = id;
        this.img_url = img_url;
        this.title = title;
        this.explanation = explanation;
        this.fund_start_date = fund_start_date;
        this.fund_end_date = fund_end_date;
        this.market_place = market_place;
        this.fund_company = fund_company;
        this.percent = percent;
        this.category = category;
        this.fundedPost = fundedPost;
        this.linkedImages = linked_images;
        this.company_introduce = company_introduce;
    }
}