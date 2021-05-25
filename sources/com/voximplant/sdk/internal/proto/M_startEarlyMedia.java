package com.voximplant.sdk.internal.proto;

import org.webrtc.SessionDescription;
public class M_startEarlyMedia extends WSMessageCall {
    public SessionDescription sdpAnswer() {
        return new SessionDescription(SessionDescription.Type.ANSWER, (String) this.params.get(2));
    }
}
