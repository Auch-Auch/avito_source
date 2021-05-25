package com.voximplant.sdk.messaging;
public interface IMessageEvent extends IMessengerEvent {
    IMessage getMessage();

    long getSequence();

    long getTimestamp();
}
