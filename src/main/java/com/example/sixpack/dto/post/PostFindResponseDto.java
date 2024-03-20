package com.example.sixpack.dto.post;


import com.example.sixpack.domain.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostFindResponseDto {

    private Long id;
    private String title;
    private String explanation;
    private LocalDateTime createAt;

    public static PostFindResponseDto toDto(Post post) {
        return new PostFindResponseDto(
                post.getId(),
                post.getTitle(),
                post.getExplanation(),
                post.getCreatedAt()
        );
    }


}