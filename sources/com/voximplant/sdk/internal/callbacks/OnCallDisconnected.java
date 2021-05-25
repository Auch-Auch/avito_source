package com.voximplant.sdk.internal.callbacks;

import com.voximplant.sdk.call.ICall;
import java.util.HashMap;
import java.util.Map;
public class OnCallDisconnected extends Callback {
    public final ICall a;
    public final Map<String, String> b;
    public final boolean c;

    public OnCallDisconnected(ICall iCall, Map<String, String> map, boolean z) {
        this.a = iCall;
        this.b = map == null ? new HashMap<>() : map;
        this.c = z;
    }

    public boolean getAnsweredStatus() {
        return this.c;
    }

    public ICall getCall() {
        return this.a;
    }

    public Map<String, String> getHeaders() {
        return this.b;
    }
}
