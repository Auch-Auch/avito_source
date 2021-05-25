package com.voximplant.sdk.client;
public interface IClientSessionListener {
    void onConnectionClosed();

    void onConnectionEstablished();

    void onConnectionFailed(String str);
}
