package com.jojoldu.book.springboot.web.web;

import com.jojoldu.book.springboot.web.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController//1.JSON을 반환하는 컨트롤러로 만들어줌.
// 2.예전에 @ResponseBody를 각메소드 마다 선언했던 것을 한번에 사용가능하게 해줌
public class HelloController {

    @GetMapping("/hello")//1.예전에는 RequestMapping(method = RequestMethod.GET) 으로 쓰임
    public String hello(){
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name,
                                     @RequestParam("amount") int amount){
                                    //외부에서 API로 넘긴 파라미터를 가져오는 어노테이션

        return new HelloResponseDto(name,amount);
    }

}
