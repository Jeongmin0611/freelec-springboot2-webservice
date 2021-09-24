package com.jojoldu.book.springboot.config.auth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER)
//1. 이 어노테이션을 선언할 수 있는 범위를 설정한다.
//2.메소드의 파라미터로 선언된 객체에서만 사용 가능.
//3. etc) 클래스 선언문에 쓸 수 있는 TYPE도 있음.
@Retention(RetentionPolicy.RUNTIME)//4.런타임 때 생성
public @interface LoginUser {//이 파일을 어노테이션으로 지정
}
