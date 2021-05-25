package com.voximplant.sdk.internal.proto;

import java.util.Map;
import org.webrtc.SessionDescription;
public class M_handleAcceptReinvite extends WSMessageCall {
    public Map<String, String> headers() {
        return (Map) this.params.get(1);
    }

    public String sdp() {
        return (String) this.params.get(2);
    }

    public SessionDescription sdpAnswer() {
        return new SessionDescription(SessionDescription.Type.ANSWER, sdp());
    }
}
