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
    private int target_amount;

    @Column(nullable = false)
    private boolean target_complete;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fund_start_date;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fund_end_date;

    @Column(nullable = false)
    private String market_place;

    @Column(nullable = false)
    private String fund_company;

    @Column(nullable = false)
    private int current_amount;

    @Column(nullable = false)
    private int discount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(nullable = false)
    private int fund_people;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "post")
    private List<Funded_post> fundedPost = new ArrayList<>();

    public Post(Long id, String img_url, String title, String explanation,
                int target_amount, boolean target_complete, Date fund_start_date,
                Date fund_end_date, String market_place, String fund_company,
                int current_amount, int discount, int category_id, int fund_people, LocalDateTime createdAt) {
        this.id = id;
        this.img_url = img_url;
        this.title = title;
        this.explanation = explanation;
        this.target_amount = target_amount;
        this.target_complete = target_complete;
        this.fund_start_date = fund_start_date;
        this.fund_end_date = fund_end_date;
        this.market_place = market_place;
        this.fund_company = fund_company;
        this.current_amount = current_amount;
        this.discount = discount;
        this.fund_people = fund_people;
        this.createdAt = createdAt;
    }
}