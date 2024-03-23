package com.example.sixpack.dto.post;

import com.example.sixpack.domain.Funded_post;
import com.example.sixpack.domain.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostFindAllResponseDto {
    private Long id;
    private String title;
    private String img_url;
    private String explanation;
    private Date fund_start_date;
    private int market_place;

    public static PostFindAllResponseDto toDto(Post post){
        return new PostFindAllResponseDto(post.getId(),
                post.getTitle(),
                post.getImg_url(),
                post.getExplanation(),
                post.getFund_start_date(),
                post.getMarket_place());
    }
}