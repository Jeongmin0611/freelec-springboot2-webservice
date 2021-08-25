package com.jojoldu.book.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(){
        return "index";
    }

    //머스테치 스타터 덕분에 컨트롤러에서 문자열을 받환할때 앞의 경로와 뒤의 파일 확장자는 자동으로 지정됩니다.
    //앞의 경로는 src/main/resources/templates로, 뒤에 파일 확장자는 .mustache가 붙는다.
    //즉, 여기선 "index" 를 반환하므로 src/main/resources/templates/index.mustache로 전환되어 viewResolver가 처리.
    //** viewResolver - URL 요청의 결과를 전달할 타입과 값을을 지정하는 관리자 역할.

    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save"; // /posts/save 를 호출하면 posts-save.mustache 파일을 호출하는 메소드
    }
}
