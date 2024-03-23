package com.example.sixpack.dto.post;


import com.example.sixpack.domain.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostFindResponseDto {

    private Long id;
    private String category_name;
    private String title;
    private String img_url;
    private String explanation;
    private String fund_start_date;
    private String fund_end_date;

    public static PostFindResponseDto toDto(Post post) {
        return new PostFindResponseDto(
                post.getId(),
                post.getCategory().getCategory_name(),
                post.getTitle(),
                post.getImg_url(),
                post.getExplanation(),
                post.getFund_start_date(),
                post.getFund_end_date()
        );
    }


}