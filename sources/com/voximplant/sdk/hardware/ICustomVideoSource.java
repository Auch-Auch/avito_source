package com.voximplant.sdk.hardware;

import org.webrtc.SurfaceTextureHelper;
public interface ICustomVideoSource {
    void release();

    void sendFrame(int i, int i2, int i3);

    void sendFrame(byte[] bArr, int i, int i2);

    void setCustomVideoSourceListener(ICustomVideoSourceListener iCustomVideoSourceListener);

    void setSurfaceTextureHelper(SurfaceTextureHelper surfaceTextureHelper);
}
