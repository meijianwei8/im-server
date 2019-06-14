package com.cdxt.imserver.util;

import com.google.gson.JsonObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.http.*;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component()
@Scope("prototype")
public class JsonRestUtil {

    private final RestTemplate restTemplate;

    private final HttpHeaders httpHeaders;

    private String basicUrl;

    private String token;

    public JsonRestUtil(String basicUrl, String token) {
        this.basicUrl = basicUrl;
        this.token = token;
    }

    public JsonRestUtil() {
    }

    public void setBasicUrl(String basicUrl) {
        this.basicUrl = basicUrl;
    }

    public void setToken(String token) {
        this.token = token;
    }

    {
        restTemplate = new RestTemplate();
        List<HttpMessageConverter<?>> messageConverters = restTemplate.getMessageConverters();
        messageConverters.removeIf(httpMessageConverter -> httpMessageConverter instanceof MappingJackson2HttpMessageConverter);
        messageConverters.add(new GsonHttpMessageConverter());
        restTemplate.setMessageConverters(messageConverters);

        httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
    }

    private void tokenInit() {
        if (StringUtils.isNotBlank(token)) {
            httpHeaders.set("Authorization",token);
        }
    }

    private String urlInit(String url) {
        url = StringUtils.isNotBlank(url)?String.join("/", basicUrl,url) : url;
        return url;
    }

    public <T> ResponseEntity<T> getForEntity(String url, Class<T> responseType, Object... urlVariables){
        tokenInit();
        url = urlInit(url);
        HttpEntity httpEntity = new HttpEntity<>(httpHeaders);
        return restTemplate.exchange(url, HttpMethod.GET, httpEntity, responseType, urlVariables);
    }

    public <T> T getForObject(String url,Class<T> responseType,Object... urlVariables){
        return getForEntity(url, responseType, urlVariables).getBody();
    }

    public JsonObject getForJsonObject(String url,Object... urlVariables){
        return getForObject(url,JsonObject.class,urlVariables);
    }

    public <T> ResponseEntity<T> postForEntity(String url,Object body,Class<T> responseType,Object... urlVariables){
        tokenInit();
        url = urlInit(url);
        HttpEntity httpEntity = new HttpEntity<>(body,httpHeaders);
        return restTemplate.postForEntity(url,httpEntity,responseType,urlVariables);
    }

    public <T> T postForObject(String url,Object body,Class<T> responseType,Object... urlVariables){
        return postForEntity(url,body,responseType,urlVariables).getBody();
    }

    public JsonObject postForJsonObject(String url,Object body,Object... urlVariables){
        return postForObject(url,body,JsonObject.class,urlVariables);
    }
}
