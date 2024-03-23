package com.example.sixpack.dto.post;

import com.example.sixpack.domain.Funded_post;
import com.example.sixpack.domain.HashTag;
import com.example.sixpack.domain.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostFindAllResponseDto {
    private Long id;
    private String title;
    private String img_url;
    private String explanation;
    private String fund_end_date;
    private int market_place;
    private List<String> HashTagnames;
    private int percent;

    public static PostFindAllResponseDto toDto(Post post) {
        List<String> hashTagNames = post.getHashTags().stream()
                .map(HashTag::getName)
                .collect(Collectors.toList());

        return new PostFindAllResponseDto(
                post.getId(),
                post.getTitle(),
                post.getImg_url(),
                post.getExplanation(),
                post.getFund_end_date(),
                post.getMarket_place(),
                hashTagNames,
                post.getPercent()
        );
    }
}