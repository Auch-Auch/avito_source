package com.voximplant.sdk.internal.callbacks;

import com.voximplant.sdk.call.ICall;
import java.util.HashMap;
import java.util.Map;
public class OnCallFailed extends Callback {
    public final ICall a;
    public final int b;
    public final String c;
    public final Map<String, String> d;

    public OnCallFailed(ICall iCall, int i, String str, Map<String, String> map) {
        this.a = iCall;
        this.b = i;
        this.c = str;
        this.d = map == null ? new HashMap<>() : map;
    }

    public ICall getCall() {
        return this.a;
    }

    public int getErrorCode() {
        return this.b;
    }

    public String getErrorDescription() {
        return this.c;
    }

    public Map<String, String> getHeaders() {
        return this.d;
    }
}
