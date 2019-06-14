package com.cdxt.imserver.service.im.users;

public interface UserManageService<T,R> {

    R registOne(T t);

    R findOne(T t);

    R deleteOne(T t);

    R updateOne(T t);

}
