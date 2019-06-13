package com.cdxt.imserver.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "huanxin")
@PropertySource("classpath:third-party.properties")
@Getter
@Setter
public class HuanXinProperties {

    private String basicUrl;

    private String clientId;

    private String clientSecret;

    private String orgName;

    private String appName;
}
