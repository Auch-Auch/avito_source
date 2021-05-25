package com.voximplant.sdk.messaging;
public interface IMessengerEvent {
    long getIMUserId();

    MessengerAction getMessengerAction();

    MessengerEventType getMessengerEventType();
}
