package com.jojoldu.book.springboot.web.dto;

import com.jojoldu.book.springboot.web.web.dto.HelloResponseDto;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class HelloResponseDtoTest {

    @Test
    public void lombokUtilTest(){
        //Given
        String name="test";
        int amount=1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name,amount);

        //then
        Assertions.assertThat(dto.getName()).isEqualTo(name);
        Assertions.assertThat(dto.getAmount()).isEqualTo(amount);
        //assertThat() - 테스트 검증 메소드 | isEqualTo() - assertThat()에 있는 값과 같을 때만 성공
    }
}
