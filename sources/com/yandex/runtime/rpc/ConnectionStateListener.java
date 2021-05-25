package com.yandex.runtime.rpc;
public interface ConnectionStateListener {
    boolean isValid();

    void onConnectionStateChanged(boolean z);
}
