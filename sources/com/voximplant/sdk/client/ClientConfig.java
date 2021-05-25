package com.voximplant.sdk.client;

import androidx.annotation.Nullable;
import com.voximplant.sdk.call.VideoCodec;
import org.webrtc.EglBase;
public class ClientConfig {
    public EglBase eglBase = null;
    public boolean enableCameraMirroring = true;
    public boolean enableDebugLogging = false;
    public boolean enableLogcatLogging = true;
    public boolean enableVideo = true;
    @Nullable
    public String packageName = null;
    public VideoCodec preferredVideoCodec = VideoCodec.VP8;
    public RequestAudioFocusMode requestAudioFocusMode = RequestAudioFocusMode.REQUEST_ON_CALL_START;
    public int statsCollectionInterval = 5000;
}
