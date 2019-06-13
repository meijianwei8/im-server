package com.cdxt.imserver.service.im.token;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class HuanXinTokenService implements TokenService<String> {
    @Override
    public String getToken(String s) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.add("Authorization","token");
        Map<String,String> body = new HashMap<>();
        body.put("grant_type","client_credentials");
        body.put("client_id","YXA6iA114Iy6Eem_n8-VGCNdsg");
        body.put("client_secret","YXA6TMYdPk6fWb92ZGM_jn46L08xUE0");
        HttpEntity<Map<String,String>> httpEntity = new HttpEntity<>(body,httpHeaders);
        Map map = restTemplate.postForObject("http://a1.easemob.com/{org_name}/{app_name}/{type}", httpEntity, new HashMap<String,String>().getClass(),"1104190612019372","my-im","token");
        System.out.println(map);
        return map.get("access_token").toString();
    }

    public static void main(String[] args) {
        HuanXinTokenService tokenService = new HuanXinTokenService();
        String token = tokenService.getToken("123");
        System.out.println(token);
    }
}
