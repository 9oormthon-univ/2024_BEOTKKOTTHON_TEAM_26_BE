package com.example.sixpack.dto.post;

import com.example.sixpack.domain.Funded_post;
import com.example.sixpack.domain.Linked_image;
import com.example.sixpack.domain.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostfundingResponseDto {

    private Long id;
    private String title;
    private String img_url;
    private Date fund_end_date;
    private String fund_company;
    private String company_introduce;
    private List<Linked_image> linkedImages; // Linked_image 값을 리스트로 반환하는 필드 추가

    public static PostfundingResponseDto toDto(Post post, List<Linked_image> linked_images) {
        return new PostfundingResponseDto(
                post.getId(),
                post.getTitle(),
                post.getImg_url(),
                post.getFund_end_date(),
                post.getFund_company(),
                post.getCompany_introduce(),
                Funded_post.getLinkedImages()
        );
    }
}