package com.voximplant.sdk.messaging;
public interface IErrorEvent extends IMessengerEvent {
    int getErrorCode();

    String getErrorDescription();
}
