package com.cdxt.imserver.helper;


import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

public abstract class CommonRestTemplateBuilder implements RestTemplateHelper{


    private RestTemplate restTemplate;

    private HttpHeaders httpHeaders;

    private HttpEntity httpEntity;

    private String url;


    public RestTemplate create(){
        this.restTemplate = new RestTemplate();
        return this.restTemplate;
    }

    public RestTemplate setHeader(HttpHeaders httpHeaders){
        this.httpHeaders = httpHeaders;
        return this.restTemplate;
    }


}
