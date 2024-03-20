package com.example.sixpack.service;

import com.example.sixpack.config.exception.exception.PostNotFoundException;
import com.example.sixpack.domain.Member;
import com.example.sixpack.domain.Post;
import com.example.sixpack.dto.post.PageInfoDto;
import com.example.sixpack.dto.post.PostFindAllResponseDto;
import com.example.sixpack.dto.post.PostFindAllWithPagingResponseDto;
import com.example.sixpack.dto.post.PostFindResponseDto;
import com.example.sixpack.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    //전체펀딩조회
    @Transactional(readOnly = true)
    public PostFindAllWithPagingResponseDto findAllfunding(Integer page){
        PageRequest pageRequest = PageRequest.of(page, 10, Sort.by("id").descending());
        Page<Post> posts = postRepository.findAll(pageRequest);
        List<PostFindAllResponseDto> postWithDto = posts.stream().map(PostFindAllResponseDto::toDto)
                .collect(toList());
        return PostFindAllWithPagingResponseDto.toDto(postWithDto, new PageInfoDto(posts));
    }

}
