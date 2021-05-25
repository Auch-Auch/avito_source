package com.voximplant.sdk.internal.callbacks;

import com.voximplant.sdk.call.ICall;
public class OnIceCompleted extends Callback {
    public final ICall a;

    public OnIceCompleted(ICall iCall) {
        this.a = iCall;
    }

    public ICall getCall() {
        return this.a;
    }
}
