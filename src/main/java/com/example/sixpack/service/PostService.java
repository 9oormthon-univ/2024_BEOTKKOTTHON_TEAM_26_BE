package com.example.sixpack.service;

import com.example.sixpack.config.exception.exception.MemberNotFoundException;
import com.example.sixpack.config.exception.exception.PostNotFoundException;
import com.example.sixpack.domain.Funded_post;
import com.example.sixpack.domain.Linked_image;
import com.example.sixpack.domain.Member;
import com.example.sixpack.domain.Post;
import com.example.sixpack.dto.post.*;
import com.example.sixpack.repository.Funded_PostRepository;
import com.example.sixpack.repository.Linked_imageRepository;
import com.example.sixpack.repository.MemberRepository;
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
    private final MemberRepository memberRepository;
    private final Linked_imageRepository linkedImageRepository;



    //전체펀딩조회
    @Transactional(readOnly = true)
    public PostFindAllWithPagingResponseDto findAllfunding(Integer page){
        PageRequest pageRequest = PageRequest.of(page, 10, Sort.by("id").descending());
        Page<Post> posts = postRepository.findAll(pageRequest);
        List<PostFindAllResponseDto> postWithDto = posts.stream().map(PostFindAllResponseDto::toDto)
                .collect(toList());
        return PostFindAllWithPagingResponseDto.toDto(postWithDto, new PageInfoDto(posts));
    }



    //카테고리별 펀딩조회

    @Transactional(readOnly = true)
    public PostFindAllWithPagingResponseDto searchPost(Long category_id,Integer page){
        PageRequest pageRequest = PageRequest.of(page, 10, Sort.by("id").descending());
        Page<Post> boards = postRepository.findAllByCategoryId(category_id, pageRequest);
        List<PostFindAllResponseDto> boardsWithDto = boards.stream().map(PostFindAllResponseDto::toDto)
                .collect(toList());
        return PostFindAllWithPagingResponseDto.toDto(boardsWithDto, new PageInfoDto(boards));
    }

    //내가참여한 펀딩조회
    @Transactional(readOnly = true)
    public PostFindAllWithPagingResponseDto searchMyFundedPosts(Long memberId, Integer page) {
        Member member = memberRepository.findById(memberId).orElseThrow(MemberNotFoundException::new);
        PageRequest pageRequest = PageRequest.of(page, 10, Sort.by("id").descending());
        Page<Post> posts = postRepository.findAllByFundedPostMemberId(memberId, pageRequest);
        List<PostFindAllResponseDto> postDtos = posts.getContent().stream()
                .map(PostFindAllResponseDto::toDto)
                .collect(toList());
        return PostFindAllWithPagingResponseDto.toDto(postDtos, new PageInfoDto(posts));
    }

    //펀딩 참여하기 페이지

    @Transactional(readOnly = true)
    public PostFindResponseDto participationFunding(Long post_id){
        Post post = postRepository.findById(post_id).orElseThrow(PostNotFoundException::new);
        return PostFindResponseDto.toDto(post);
    }

    //실시간 펀딩 현황/완료-상세메뉴 정보- 결제
    @Transactional(readOnly = true)
    public PostfundingResponseDto BuyFundedPosts(Long post_id){

        List<Linked_image> linked_images = linkedImageRepository.findByPostId(post_id);
        Post post = postRepository.findById(post_id).orElseThrow(PostNotFoundException::new);
        System.out.println(linked_images);
        System.out.println("***********************************");
        return PostfundingResponseDto.toDto(post, linked_images);

    }

//    //게시글 등록
//    @Transactional
//    public void createBoard(PostCreateRequestDto req, Member member){
//        List<Image> images = req.getImages().stream()
//                .map(i -> new Image(i.getOriginalFilename()))
//                .collect(toList());
//        Board board = new Board(req.getTitle(), req.getContent(), member, images);
//        boardRepository.save(board);
//        uploadImages(board.getImages(), req.getImages());
//    }

//    public void participationPost(Long memberId, Long postId) {
//        Member member = memberRepository.findById(memberId).orElseThrow(() -> new MemberNotFoundException());
//        Post post = postRepository.findById(postId).orElseThrow(() -> new PostNotFoundException());
//        Funded_post funded_post = new Funded_post();
//
//        funded_post.setMember(member);
//        funded_post.setPost(post);
//
//        fundedPostRepository.save(funded_post);
    }

