package com.voximplant.sdk.internal.callbacks;

import com.voximplant.sdk.call.ICall;
public class OnIceTimeout extends Callback {
    public final ICall a;

    public OnIceTimeout(ICall iCall) {
        this.a = iCall;
    }

    public ICall getCall() {
        return this.a;
    }
}
