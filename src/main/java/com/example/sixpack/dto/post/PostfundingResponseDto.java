package com.example.sixpack.dto.post;


import com.example.sixpack.domain.Member;
import com.example.sixpack.domain.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostfundingResponseDto {

    private Long id;
    private String title;
    private String img_url;

    public static PostfundingResponseDto toDto(Post post) {
        return new PostfundingResponseDto(
                post.getId(),
                post.getTitle(),
                post.getImg_url()
        );
    }
}