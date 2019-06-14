package com.cdxt.imserver.helper;

import com.cdxt.imserver.config.HuanXinProperties;
import com.cdxt.imserver.service.im.token.TokenService;
import com.cdxt.imserver.util.JsonRestUtil;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


@Component
public class HuanXinRestTemplateHelper {

    private final JsonRestUtil jsonRestUtil;

    @Resource(name = "huanXinTokenService")
    private final TokenService<String> tokenService;

    private final HuanXinProperties huanXinProperties;

    public HuanXinRestTemplateHelper(JsonRestUtil jsonRestUtil, TokenService<String> tokenService, HuanXinProperties huanXinProperties) {
        this.jsonRestUtil = jsonRestUtil;
        this.tokenService = tokenService;
        this.huanXinProperties = huanXinProperties;
    }

    @PostConstruct
    private void init(){

        List<String> urlPart = new ArrayList<>();
        urlPart.add(huanXinProperties.getBasicUrl());
        urlPart.add(huanXinProperties.getOrgName());
        urlPart.add(huanXinProperties.getAppName());
        String basicUrl = String.join("/", urlPart);
        jsonRestUtil.setBasicUrl(basicUrl);

        String token = tokenService.getToken(basicUrl);
        jsonRestUtil.setToken("Bearer " + token);
    }

    public JsonRestUtil getJsonRestUtil() {
        return jsonRestUtil;
    }
}
