package com.example.sixpack.dto.post;

import com.example.sixpack.domain.Funded_post;
import com.example.sixpack.domain.Linked_image;
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
public class PostfundingResponseDto {

    private Long id;
    private String title;
    private String img_url;
    private String fund_end_date;
    private String fund_company;
    private String company_introduce;
    private int percent;
    private List<String> linkedImages; // Linked_image 값을 리스트로 반환하는 필드 추가

    public static PostfundingResponseDto toDto(Post post, List<Linked_image> linkedImages) {
        List<String> imageUrls = linkedImages.stream()
                .map(Linked_image::getImg_url)
                .collect(Collectors.toList());

        return new PostfundingResponseDto(
                post.getId(),
                post.getTitle(),
                post.getImg_url(),
                post.getFund_end_date(),
                post.getFund_company(),
                post.getCompany_introduce(),
                post.getPercent(),
                imageUrls
        );
    }

}