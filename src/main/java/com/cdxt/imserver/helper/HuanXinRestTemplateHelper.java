package com.cdxt.imserver.helper;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.*;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class HuanXinRestTemplateHelper {


    private RestTemplate restTemplate = new RestTemplate();

    private HttpHeaders httpHeaders;

    private HttpEntity httpEntity;

    private String url;



    private Object get(Object o, String extendUrl,Object... uriVariables){
        HttpEntity httpEntity = new HttpEntity<>(o, httpHeaders);
        extendUrl(extendUrl);
        return restTemplate.exchange(url, HttpMethod.GET,httpEntity,String.class,uriVariables);

    }

    private void extendUrl(String extendUrl) {
        if (StringUtils.isNotBlank(extendUrl)) {
            url = url + extendUrl;
        }
    }

    private void buildHttpHeader() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.add("Authorization","token");
        this.httpHeaders = httpHeaders;

    }

    private void buildBasicUrl(){
        url = "";
    }

}
