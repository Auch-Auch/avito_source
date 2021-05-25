package com.voximplant.sdk.internal.callbacks;

import com.voximplant.sdk.call.ICall;
import java.util.HashMap;
import java.util.Map;
public class OnIncomingCall extends Callback {
    public final ICall a;
    public final boolean b;
    public final Map<String, String> c;

    public OnIncomingCall(ICall iCall, boolean z, Map<String, String> map) {
        this.a = iCall;
        this.b = z;
        this.c = map == null ? new HashMap<>() : map;
    }

    public ICall getCall() {
        return this.a;
    }

    public Map<String, String> getHeaders() {
        return this.c;
    }

    public boolean isVideoCall() {
        return this.b;
    }
}
