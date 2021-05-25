package com.voximplant.sdk.internal.proto;

import org.webrtc.SessionDescription;
public class M___createPC extends WSMessageAuth {
    public String sdp() {
        return (String) this.params.get(1);
    }

    public SessionDescription sdpOffer() {
        return new SessionDescription(SessionDescription.Type.OFFER, sdp());
    }
}
