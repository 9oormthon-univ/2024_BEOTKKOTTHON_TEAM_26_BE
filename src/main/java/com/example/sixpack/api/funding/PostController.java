package com.example.sixpack.api.funding;

import com.example.sixpack.config.exception.response.Response;
import com.example.sixpack.repository.MemberRepository;
import com.example.sixpack.service.PostService;
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

    @PostMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public Response findAllfunding(@RequestParam(defaultValue = "0") Integer page){
        return Response.success(postService.findAllfunding(page));
    }

//    @PostMapping("/all/{category_id}")
//    @ResponseStatus(HttpStatus.OK)
//    public Response findAllfundingWithCategory(@PathVariable Integer category_id,@RequestParam(defaultValue = "0") Integer page){
//        return Response.success(postService.findAllfundingWithCategory(page));
//    }
//
//    @PostMapping("/status")
//    @ResponseStatus(HttpStatus.OK)
//    public Response findmyfunding(@RequestParam(defaultValue = "0") Integer page){
//        return Response.success(postService.findmyfunding(page));
//    }

}
