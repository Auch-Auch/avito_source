package com.voximplant.sdk.internal.callbacks;

import com.voximplant.sdk.call.ICall;
public class OnMessageReceived extends Callback {
    public final ICall a;
    public final String b;

    public OnMessageReceived(ICall iCall, String str) {
        this.a = iCall;
        this.b = str;
    }

    public ICall getCall() {
        return this.a;
    }

    public String getMessage() {
        return this.b;
    }
}
