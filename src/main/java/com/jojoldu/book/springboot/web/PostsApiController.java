package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.serivce.posts.PostsService;
import com.jojoldu.book.springboot.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;
    //@autowired보다 생성자 주입 방식을 권장
    //@RequiredArgsConstructor가 해결해줌. @RequiredArgsConstructor가 final이 선언된 모든 변수의 생성자를 대신 생성해줌.
    //생성자 코드(내용)를 계속 수정할 필요가 없어 번거롭지 않음.

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto){
        return postsService.save(requestDto);
    }
}
