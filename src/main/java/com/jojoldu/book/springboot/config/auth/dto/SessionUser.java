package com.jojoldu.book.springboot.config.auth.dto;

import com.jojoldu.book.springboot.domain.user.User;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class SessionUser implements Serializable {//직렬화를 하여 세션에 정보를 저장.
    private String name;
    private String email;
    private String picture;

    public SessionUser(User user){
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture= user.getPicture();
    }

    //sessionUser에는 인증된 사용자 정보만 필요합니다.
    //그 외에 필요한 정보들은 없으니 name, email, picture만 필드로 선언합니다.
}