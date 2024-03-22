package com.example.sixpack.dto.post;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PostFindAllWithPagingResponseDto {
    private List<PostFindAllResponseDto> posts;
    private PageInfoDto pageInfoDto;



    public static PostFindAllWithPagingResponseDto toDto(List<PostFindAllResponseDto> posts, PageInfoDto pageInfoDto) {
        return new PostFindAllWithPagingResponseDto(posts, pageInfoDto);
    }
}