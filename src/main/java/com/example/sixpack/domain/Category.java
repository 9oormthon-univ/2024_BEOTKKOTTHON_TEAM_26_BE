package com.example.sixpack.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long id;

    @Column(nullable = false, unique = true)
    private String category_name;

    @OneToMany(mappedBy = "category")
    private List<Post> post = new ArrayList<>();

    public Category(Long id, String category_name) {
        this.id = id;
        this.category_name = category_name;
    }
}
