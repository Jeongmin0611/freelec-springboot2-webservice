package com.jojoldu.book.springboot;

import com.jojoldu.book.springboot.web.HelloController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.is;

@RunWith(SpringRunner.class)//1.테스트를 진행할 때 junit에 내장된 실행자 외에 다른 실해자를 실행시킴.
//여기서는 SpringRunner라는 스프링 실행자를 사용, 스프링부트테스트와 junit사이에 연결자 역할을 함.
@WebMvcTest(controllers = HelloController.class,secure = false)
//1.여러 스프링테스트 어노테이션 중 web(Spring mvc)에 집중할 수 있는 어노테이션
//2.선언할 경우, @Controller,@ControllerAdvice 사용가능 | 단, @service, @Repositor는 사용 불가
//3.여기서는 controller만 사용하기 때문에 선언.
public class HelloControllerTest {

    @Autowired private MockMvc mvc;
    //1. 스프링이 관리하는 bean 주입
    //2. 웹 API를 테스트 할 때 사용, 이 클래스를 통해 HTTP메소드(GET, POST..)를 테스트 해볼수 있음.

    @Test
    public void helloReturn() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(hello));

        //mvc perform(MockMvcRequestBuilders.get("/hello")) - mockMvc를 통해 /hello 주소로 http get 요청함.

        //.andExpect(status().isOk()) - 여기서는 isOk() 라 status가 200인지 검증
        // mvc.perform 의 결과를 검증한다. | HTTP Header의 status(200,400,500...)를 검증한다.

        //.andExpect(content().string(hello)); -응답 본문의 내용을 검증합니다.(hello가 맞는지 검증..)
    }

    @Test
    public void helloDtoReturn() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(get("/hello/dto")
                .param("name",name)
                .param("amount",String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name",is(name)))
                .andExpect(jsonPath("$.amount",is(amount)));

                //param - api 테스트 할 때 사용될 요청 파라미터로 설정합니다. 단, String 값만 허용됩니다.
                //그래서 숫짜/날짜는 데이터도 등록할때는 문자열로 변경해야 가능합니다.

                //jsonPath() - json 응닶값을 필드별로 검증할 수 있는 메소드입니다. | $를 기준으로 변수명을 명시합니다.
                //여기서는 name과 amount를 검증하니 $.name,$.amount 로 검증합니다.

    }
}
