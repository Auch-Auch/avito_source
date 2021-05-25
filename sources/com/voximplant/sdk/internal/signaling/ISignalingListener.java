package com.voximplant.sdk.internal.signaling;
public interface ISignalingListener {
    void onWSClose(String str);

    void onWSOpen();
}
