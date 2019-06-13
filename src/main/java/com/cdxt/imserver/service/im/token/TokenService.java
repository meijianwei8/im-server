package com.cdxt.imserver.service.im.token;

public interface TokenService<T> {

    String getToken(T t);

}
