package com.voximplant.sdk.internal.callbacks;

import com.voximplant.sdk.call.ICall;
public class OnCallAudioStarted extends Callback {
    public final ICall a;

    public OnCallAudioStarted(ICall iCall) {
        this.a = iCall;
    }

    public ICall getCall() {
        return this.a;
    }
}
