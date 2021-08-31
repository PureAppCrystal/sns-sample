package com.hoonyb.snssample.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/kakao")
public class HomeController {
    

    KakaoAPI kakaoApi = new KakaoAPI();

    @RequestMapping(value = "/login")
    public ModelAndView login(@RequestParam("code") String code, HttpSession session) {
        ModelAndView mav = new ModelAndView();
        // 1. 앱 인증으로 요청 전달
        String access_token = kakaoApi.getAccessToken(code);

        // 2. 인증코드로 토큰 전달 
        HashMap<String, Object> userInfo = kakaoApi.getUserInfo(access_token);

        System.out.println("login info : " + userInfo.toString());

        if( userInfo.get("email") != null) {
            session.setAttribute("userId", userInfo.get("email"));
            session.setAttribute("access_token", access_token);
        }
        mav.addObject("userId", userInfo.get("email"));
        mav.setViewName("index");
        return mav;
    }
    

    @RequestMapping(value = "/logout")
    public ModelAndView logout(HttpSession session) {
        ModelAndView mav = new ModelAndView();

        kakaoApi.kakaoLogout((String)session.getAttribute("access_token"));
        session.removeAttribute("accessToken");
        session.removeAttribute("userId");
        mav.setViewName("index");

        return mav;
    }



    
}
