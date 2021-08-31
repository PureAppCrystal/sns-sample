// package com.hoonyb.snssample.controller;

// import java.io.IOException;
// import java.util.ArrayList;
// import java.util.HashMap;
// import java.util.List;
// import java.util.Map;

// import javax.servlet.http.HttpServletResponse;
// import javax.servlet.http.HttpSession;

// import org.apache.http.HttpResponse;
// import org.apache.http.NameValuePair;
// import org.apache.http.client.HttpClient;
// import org.apache.http.client.entity.UrlEncodedFormEntity;
// import org.apache.http.client.methods.HttpPost;
// import org.apache.http.impl.client.DefaultHttpClient;
// import org.apache.http.message.BasicHeader;
// import org.apache.http.message.BasicNameValuePair;

// import com.fasterxml.jackson.databind.JsonNode;
// import com.fasterxml.jackson.databind.ObjectMapper;

// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMethod;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.servlet.mvc.support.RedirectAttributes;

// @Controller
// @RequestMapping("/kakao")
// public class KakaoController {
    
//     // private KakaoLogin kakao_restapi = new KakaoLogin();
//     final String CLIENT_ID = "7f195a0dbcf6fbebab277c68c6909907";

//     @GetMapping(value="oauth")
//     public String kakaoConnect() {
//         StringBuffer url = new StringBuffer();
//         url.append("https://kauth.kakao.com/oauth/authorize?");
//         url.append("client_id="+CLIENT_ID);
//         url.append("&redirect_uri=http://localhost:8000/kakao/callback");
//         url.append("&response_type=code");

//         System.out.println("url : " + url.toString());
//         return "redirect:" + url.toString();
//     }

//     @RequestMapping(value="/callback",produces="application/json",method= {RequestMethod.GET, RequestMethod.POST})
//     public JsonNode kakaoLogin(@RequestParam("code")String code, RedirectAttributes ra, HttpSession session, HttpServletResponse response, Model model)throws IOException {

//         System.out.println("kakao code:"+code);

//         JsonNode accessToken = getKakaoAccessToken(code);
//         System.out.println("accessToken : " + accessToken);
//         return accessToken;
//     }




//     @RequestMapping(value="/logout")
//     // @PostMapping(value="/logout")
//     public String kakaoLogout(@RequestBody Map<String, Object> map) {
//     // public String kakaoLogout() {
//         System.out.println("====== logout ======");

//         final String RequestUrl = "https://kapi.kakao.com/v1/user/logout"; // Host
//         final List<NameValuePair> postParams = new ArrayList<NameValuePair>();
//         String authorization = "bearer " + map.get("accessToken").toString();
//         // String authorization = "test";

//         sendPostRequest(RequestUrl, postParams, authorization);
//         return "hi";
//     }






//     public JsonNode getKakaoAccessToken(String code) {
//         System.out.println("====== getKakaoAccessToken ======");
//         final String RequestUrl = "https://kauth.kakao.com/oauth/token"; // Host
//         final List<NameValuePair> postParams = new ArrayList<NameValuePair>();

//         postParams.add(new BasicNameValuePair("grant_type", "authorization_code"));
        
//         postParams.add(new BasicNameValuePair("client_id", CLIENT_ID)); // REST API KEY
//         postParams.add(new BasicNameValuePair("redirect_uri", "http://localhost:8080/kakao/callback")); // 리다이렉트 URI
//         postParams.add(new BasicNameValuePair("code", code)); // 로그인 과정중 얻은 code 값

//         // HttpClientBuilder
//         final HttpClient client = new DefaultHttpClient();
//         //final HttpClient client = HttpClientBuilder.create().build();
//         final HttpPost post = new HttpPost(RequestUrl);

//         JsonNode returnNode = null;

//         try {
//             post.setEntity(new UrlEncodedFormEntity(postParams));
            

//             final HttpResponse response = client.execute(post);
//             final int responseCode = response.getStatusLine().getStatusCode();

//             System.out.println("\nSending 'POST' request to URL : " + RequestUrl);
//             System.out.println("Post parameters : " + postParams);
//             System.out.println("Response Code : " + responseCode);

//             // JSON 형태 반환값 처리
//             ObjectMapper mapper = new ObjectMapper();

//             returnNode = mapper.readTree(response.getEntity().getContent());

//         } catch (IOException e) {
//             e.printStackTrace();
//         }

//         return returnNode;
//     }

//     public JsonNode sendPostRequest(String url, List<NameValuePair> params, String authorization) {
//         final HttpClient client = new DefaultHttpClient();
//         //final HttpClient client = HttpClientBuilder.create().build();
//         final HttpPost post = new HttpPost(url);

//         JsonNode returnNode = null;

//         try {
//             post.setEntity(new UrlEncodedFormEntity(params));
//             if ( authorization != null) {
//                 post.addHeader(new BasicHeader("Authorization", authorization));
//             }

//             final HttpResponse response = client.execute(post);
//             final int responseCode = response.getStatusLine().getStatusCode();

//             System.out.println("\nSending 'POST' request to URL : " + url);
//             System.out.println("Post Header : " + authorization);
//             System.out.println("Post parameters : " + params);
//             System.out.println("Response Code : " + responseCode);
//             System.out.println("response : " + response);

//             // JSON 형태 반환값 처리
//             ObjectMapper mapper = new ObjectMapper();

//             returnNode = mapper.readTree(response.getEntity().getContent());

//         } catch (IOException e) {
//             e.printStackTrace();
//         }

//         return returnNode;
//     }
// }
