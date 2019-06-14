package com.cdxt.imserver.service.im.token;

import com.cdxt.imserver.config.HuanXinProperties;
import com.cdxt.imserver.util.JsonRestUtil;
import com.google.gson.JsonObject;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service("huanXinTokenService")
public class HuanXinTokenService implements TokenService<String> {

    private final JsonRestUtil jsonRestUtil;

    private final HuanXinProperties huanXinProperties;

    public HuanXinTokenService(JsonRestUtil jsonRestUtil, HuanXinProperties huanXinProperties) {
        this.jsonRestUtil = jsonRestUtil;
        this.huanXinProperties = huanXinProperties;
    }

    @Override
    public String getToken(String url) {
        url = String.join("/",url,"token");
        Map<String,String> body = new HashMap<>();
        body.put("grant_type","client_credentials");
        body.put("client_id",huanXinProperties.getClientId());
        body.put("client_secret",huanXinProperties.getClientSecret());
        JsonObject token = jsonRestUtil.postForJsonObject(url, body);
        return token.get("access_token").getAsString();
    }

}
