package com.example.sixpack.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Linked_image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Linked_image_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="post_id")
    private Post post;

    @Column(nullable = false)
    private String img_url;
}

