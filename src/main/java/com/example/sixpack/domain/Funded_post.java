package com.example.sixpack.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Funded_post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "funded_post_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="post_id")
    private Post post;




    public Funded_post(Long id, Member member, Post post) {
        this.id = id;
        this.member = member;
        this.post = post;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
