package com.example.sixpack.api.funding;

import com.example.sixpack.config.exception.response.Response;
import com.example.sixpack.repository.MemberRepository;
import com.example.sixpack.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/funding")
public class PostController {

    private final MemberRepository memberRepository;
    private final PostService postService;

//    @PostMapping("/boards")
//    @ResponseStatus(HttpStatus.CREATED)
//    public Response createPost(@Valid @ModelAttribute PostCreateRequestDto req) {
//        PostService.createPost(req, getPrincipal());
//        return Response.success();
//    }

//    @PostMapping("/participation")
//    @ResponseStatus(HttpStatus.CREATED)
//    public Response participationPost(@RequestBody Long member_Id, @RequestBody Long post_Id) {
//        PostService.participationPost(member_Id,post_Id);
//        return Response.success();
//    }


//    음식 펀딩 산세 페이지1(전체펀딩조회)
    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public Response findAllfunding(@RequestParam(defaultValue = "0") Integer page){
        return Response.success(postService.findAllfunding(page));
    }

    //음식 펀딩 상세 페이지1(카테고리별 조회)
    @GetMapping("/all/{category_id}")
    @ResponseStatus(HttpStatus.OK)
    public Response searchPost(@PathVariable Long category_id,@RequestParam(defaultValue = "0") Integer page){
        return Response.success(postService.searchPost(category_id, page));
    }

//    //음식 펀딩 상세 페이지1(카테고리별 조회)
//    @GetMapping("/all/distance/{market_place}")
//    @ResponseStatus(HttpStatus.OK)
//    public Response searchPost(@PathVariable int market_place,@RequestParam(defaultValue = "0") Integer page){
//        return Response.success(postService.searchDistance(market_place, page));
//    }

    //실시간 펀딩 현황/완료
    @GetMapping("/status/{member_id}")
    @ResponseStatus(HttpStatus.OK)
    public Response searchMyFundedPosts(@PathVariable Long member_id, @RequestParam(defaultValue = "0") Integer page){
        return Response.success(postService.searchMyFundedPosts(member_id, page));
    }


    @GetMapping("/status/details/{post_id}")
    @ResponseStatus(HttpStatus.OK)
    public Response BuyFundedPosts(@PathVariable Long post_id) {
        return Response.success(postService.BuyFundedPosts(post_id));
    }

    //펀딩참여하기페이지
    @GetMapping("/{post_id}")
    @ResponseStatus(HttpStatus.OK)
    public Response participationFunding(@PathVariable Long post_id){
        return Response.success(postService.participationFunding(post_id));
    }

}
