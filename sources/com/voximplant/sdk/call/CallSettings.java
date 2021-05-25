package com.voximplant.sdk.call;

import a2.b.a.a.a;
import androidx.annotation.Nullable;
import java.util.Map;
public class CallSettings {
    @Nullable
    public String customData = null;
    @Nullable
    public Map<String, String> extraHeaders = null;
    public VideoCodec preferredVideoCodec = VideoCodec.AUTO;
    public VideoFlags videoFlags = new VideoFlags();

    public String toString() {
        StringBuilder L = a.L("CallSettings: video send: ");
        VideoFlags videoFlags2 = this.videoFlags;
        boolean z = true;
        L.append(videoFlags2 != null && videoFlags2.sendVideo);
        L.append(", video receive: ");
        VideoFlags videoFlags3 = this.videoFlags;
        if (videoFlags3 == null || !videoFlags3.receiveVideo) {
            z = false;
        }
        L.append(z);
        L.append(", video codec: ");
        L.append(this.preferredVideoCodec);
        return L.toString();
    }
}
