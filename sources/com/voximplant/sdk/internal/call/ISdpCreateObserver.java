package com.voximplant.sdk.internal.call;

import org.webrtc.SessionDescription;
public interface ISdpCreateObserver {
    void onCreateFail(String str);

    void onCreateSuccess(SessionDescription sessionDescription);
}
