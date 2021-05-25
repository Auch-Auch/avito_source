package com.voximplant.sdk.internal.callbacks;

import com.voximplant.sdk.call.ICall;
import java.util.Map;
public class OnCallConnected extends Callback {
    public final ICall a;
    public final Map<String, String> b;

    public OnCallConnected(ICall iCall, Map<String, String> map) {
        this.a = iCall;
        this.b = map;
    }

    public ICall getCall() {
        return this.a;
    }

    public Map<String, String> getHeaders() {
        return this.b;
    }
}
