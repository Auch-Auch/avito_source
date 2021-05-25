package com.voximplant.sdk.internal.callbacks;

import com.voximplant.sdk.call.ICall;
import java.util.HashMap;
import java.util.Map;
public class OnCallRinging extends Callback {
    public final ICall a;
    public Map<String, String> b;

    public OnCallRinging(ICall iCall, Map<String, String> map) {
        this.a = iCall;
        this.b = map == null ? new HashMap<>() : map;
    }

    public ICall getCall() {
        return this.a;
    }

    public Map<String, String> getHeaders() {
        return this.b;
    }
}
