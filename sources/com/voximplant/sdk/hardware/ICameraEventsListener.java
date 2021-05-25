package com.voximplant.sdk.hardware;
public interface ICameraEventsListener {
    void onCameraDisconnected();

    void onCameraError(String str);

    void onCameraSwitchDone(boolean z);

    void onCameraSwitchError(String str);
}
