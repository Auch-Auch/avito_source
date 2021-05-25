package com.voximplant.sdk.internal.call;
public interface ISdpSetObserver {
    void onSetFailure(String str);

    void onSetSuccess();
}
