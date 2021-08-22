package com.jojoldu.book.springboot.web.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter//
@RequiredArgsConstructor
//선언된 모든 final 변수가 포함된 생성자를 생성해줍니다.
// final이 없는 변수는 생성자에 포함되지 않습니다.
public class HelloResponseDto {

    private final String name;
    private final int amount;
}
