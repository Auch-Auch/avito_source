package com.voximplant.sdk.internal.proto;

import java.util.HashMap;
import java.util.Map;
public class M_handleConnectionFailed extends WSMessageCall {
    public int errorCode() {
        return ((Double) this.params.get(1)).intValue();
    }

    public String errorDescription() {
        return (String) this.params.get(2);
    }

    public Map<String, String> headers() {
        return this.params.size() >= 4 ? (Map) this.params.get(3) : new HashMap();
    }
}
