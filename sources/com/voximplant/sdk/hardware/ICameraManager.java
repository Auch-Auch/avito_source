package com.voximplant.sdk.hardware;

import java.util.List;
public interface ICameraManager {
    void addCameraEventsListener(ICameraEventsListener iCameraEventsListener);

    void enableCameraFlash(boolean z);

    String[] getCameraDeviceNames();

    List<CameraResolution> getCameraSupportedResolutions(String str);

    void removeCameraEventsListener(ICameraEventsListener iCameraEventsListener);

    void setCamera(int i, int i2, int i3);

    void setCamera(int i, VideoQuality videoQuality);
}
