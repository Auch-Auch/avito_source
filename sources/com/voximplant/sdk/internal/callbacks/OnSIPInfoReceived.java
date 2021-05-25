package com.voximplant.sdk.internal.callbacks;

import com.voximplant.sdk.call.ICall;
import java.util.HashMap;
import java.util.Map;
public class OnSIPInfoReceived extends Callback {
    public final ICall a;
    public final String b;
    public final String c;
    public final Map<String, String> d;

    public OnSIPInfoReceived(ICall iCall, String str, String str2, Map<String, String> map) {
        this.a = iCall;
        this.b = str;
        this.c = str2;
        this.d = map == null ? new HashMap<>() : map;
    }

    public ICall getCall() {
        return this.a;
    }

    public String getContent() {
        return this.c;
    }

    public Map<String, String> getHeaders() {
        return this.d;
    }

    public String getMimeType() {
        return this.b;
    }
}
