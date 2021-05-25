package com.voximplant.sdk.internal.proto;

import com.voximplant.sdk.call.CallSettings;
import com.voximplant.sdk.call.VideoFlags;
import java.util.Map;
import org.webrtc.SessionDescription;
public class M_handleIncomingConnection extends WSMessageCall {
    public boolean a;

    public CallSettings getVideoCallSettings() {
        CallSettings callSettings = new CallSettings();
        String[] split = sdp().split("\r\n");
        int length = split.length;
        int i = 0;
        boolean z = false;
        while (true) {
            if (i >= length) {
                break;
            }
            String str = split[i];
            if (str.startsWith("m=video")) {
                z = true;
            }
            if (!z || (!str.contains("a=sendrecv") && !str.contains("a=sendonly"))) {
                VideoFlags videoFlags = callSettings.videoFlags;
                videoFlags.receiveVideo = false;
                videoFlags.sendVideo = false;
                i++;
            }
        }
        VideoFlags videoFlags2 = callSettings.videoFlags;
        videoFlags2.sendVideo = true;
        videoFlags2.receiveVideo = true;
        this.a = true;
        return callSettings;
    }

    public Map<String, String> headers() {
        return (Map) this.params.get(3);
    }

    public boolean isServerCall() {
        return sdp() == null || sdp().contains("VIMS");
    }

    public boolean isVideoCall() {
        return this.a;
    }

    public String sdp() {
        return (String) this.params.get(4);
    }

    public SessionDescription sdpOffer() {
        return new SessionDescription(SessionDescription.Type.OFFER, sdp());
    }

    public String sipUri() {
        return (String) this.params.get(1);
    }

    public String user() {
        if (this.params.size() <= 1) {
            return null;
        }
        String sipUri = sipUri();
        return sipUri.substring(4, sipUri.indexOf("@"));
    }

    public String userDisplayName() {
        return (String) this.params.get(2);
    }
}
