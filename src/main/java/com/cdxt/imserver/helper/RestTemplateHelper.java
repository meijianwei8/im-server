package com.cdxt.imserver.helper;

public interface RestTemplateHelper<T,V> {

    <T> T get(V v,Class<T> t,String... url);

    <T> T post(V v,Class<T> t,String... url);

    <T> T put(V v,Class<T> t,String... url);

    <T> T delete(V v,Class<T> t,String... url);

}
