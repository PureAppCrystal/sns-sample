package com.hoonyb.snssample.config;

import com.hoonyb.snssample.service.KakaoOAuth2UserService;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests().antMatchers("/kakao/*", "/oauth2/**", "/login/**", "/css/**", 
                                                     "/images/**", "/js/**", "/console/**", "/favicon.ico/**").permitAll();
        httpSecurity.cors().and();
        httpSecurity.csrf().disable();
                                             
                                             
                                             
    }


    // private final KakaoOAuth2UserService kakaoOAuth2UserService;

    // @Override
    // protected void configure(HttpSecurity http) throws  Exception {
    //     http.oauth2Login().userInfoEndpoint().userService(kakaoOAuth2UserService);
    // }

    
}
