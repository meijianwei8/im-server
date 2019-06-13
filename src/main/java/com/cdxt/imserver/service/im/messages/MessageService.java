package com.cdxt.imserver.service.im.messages;

public interface MessageService<T,R> {

    R sendTextMessage(T t);

    R sendPictureMessage(T t);

    R sendAudioMessage(T t);

    R sendVideoMessage(T t);
}
