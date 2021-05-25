package com.voximplant.sdk.internal.proto;

import java.util.HashMap;
import java.util.Map;
public class M_handleRingOut extends WSMessageCall {
    public Map<String, String> headers() {
        if (this.params.size() > 1) {
            return (Map) this.params.get(1);
        }
        return new HashMap();
    }
}
