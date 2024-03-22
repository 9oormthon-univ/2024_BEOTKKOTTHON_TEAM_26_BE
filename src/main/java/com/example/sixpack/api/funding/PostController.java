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

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public Response findAllfunding(@RequestParam(defaultValue = "0") Integer page){
        return Response.success(postService.findAllfunding(page));
    }

    @GetMapping("/all/{category_id}")
    @ResponseStatus(HttpStatus.OK)
    public Response searchPost(@PathVariable Long category_id,@RequestParam(defaultValue = "0") Integer page){
        return Response.success(postService.searchPost(category_id, page));
    }

    @GetMapping("/status/{member_id}")
    @ResponseStatus(HttpStatus.OK)
    public Response searchMyFundedPosts(@PathVariable Long member_id, @RequestParam(defaultValue = "0") Integer page){
        return Response.success(postService.searchMyFundedPosts(member_id, page));
    }

}
