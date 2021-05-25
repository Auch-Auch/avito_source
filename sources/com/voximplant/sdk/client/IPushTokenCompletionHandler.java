package com.voximplant.sdk.client;
public interface IPushTokenCompletionHandler {
    void onFailure(PushTokenError pushTokenError);

    void onSuccess();
}
