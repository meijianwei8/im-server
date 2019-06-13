package com.cdxt.imserver.service.im.messages;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class HuanXinMessageService implements MessageService {

    @Override
    public Object sendTextMessage(Object o) {

        return null;
    }

    @Override
    public Object sendPictureMessage(Object o) {
        return null;
    }

    @Override
    public Object sendAudioMessage(Object o) {
        return null;
    }

    @Override
    public Object sendVideoMessage(Object o) {
        return null;
    }

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.add("Authorization","token");
        Map<String,String> body = new HashMap<>();
        body.put("topicId","123456");
        body.put("patientId","12346");
        body.put("doctorId","654321");
        body.put("userType","doctor");
        HttpEntity httpEntity = new HttpEntity(body,httpHeaders);
        String content = restTemplate.postForObject("http://localhost:9001//web-rtc/get-token", httpEntity, String.class);
        ObjectMapper objectMapper = new ObjectMapper();
    }
}
