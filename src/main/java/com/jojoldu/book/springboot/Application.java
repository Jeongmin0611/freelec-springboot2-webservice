package com.jojoldu.book.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
//@EnableJpaAuditing
//이 어노테이션을 쓰기위해선 ENTITY 클래스가 최소 1개 이상이어야함. test 환경에선 엔티티가 없으므로 삭제
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class,args);
    }
}
