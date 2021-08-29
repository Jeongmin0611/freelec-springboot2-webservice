package com.jojoldu.book.springboot.config.auth;

import com.jojoldu.book.springboot.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity//spring security 설정들을 활성화 시킴.
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .headers().frameOptions().disable()
                .and()
                .authorizeRequests()
                .antMatchers("/","/css/**","/images/**",
                        "/js/**", "/h2-console/**").permitAll()
                .antMatchers("/api/v1/**").hasRole(Role.USER.name())
                .anyRequest().authenticated()
                .and()
                    .logout()
                    .logoutSuccessUrl("/")
                .and()
                    .oauth2Login()
                        .userInfoEndpoint()
                            .userService(customOAuth2UserService);


        //.csrf().disable().headers().frameOptions().disable()
        // h2 console 화면을 사용하기 위해 해당 옵션들을 disable

        //authorizeRequests() ==> url 별 권한 관리를 설정하는 옵션의 시작점
        //authorizeRequests 가 선언되어 있어야 antMatchers 사용가능

        //antMatchers() ==> 관리대상을 지정하는 옵션 (URL형태)

        //anyRequest() ==> 설정된 값들 이외 나머지 URL을 나타냅니다.
        //여기서는 authenticated()를 추가하여 나머지 url들은 모두 인증된 사용자들에게만 허용(로그인 한 사람)

        //logout().logoutSuccessUrl("/") ==> 로그아웃 기능에 대한 여러 설정의 진입점.

        //oauth2Login() - Oauth2 로그인 기능에 대한 설정 진입점.
        //userInfoEndpoint() - Oauth2 로그인 성공 이후 사용자 정보를 가져올 때 설정 담당.

        //userService() ==> 소셜 로그인 성공 시 후속 조치를 진행할 userServce 구현체를 등록
        //리소스서버(구글, 카카오 등..)에서 사용자 정보를 가져온 상태에서 추가로 진행하고자 하는 기능을 명시 가능.
    }
}
