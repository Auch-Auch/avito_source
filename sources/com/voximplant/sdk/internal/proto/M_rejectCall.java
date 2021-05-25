package com.voximplant.sdk.internal.proto;

import java.util.Map;
public class M_rejectCall extends WSMessageCall {
    public M_rejectCall(String str, boolean z, Map map) {
        this.params.add(str);
        this.params.add(Boolean.valueOf(z));
        if (map != null) {
            this.params.add(map);
        }
    }
}
