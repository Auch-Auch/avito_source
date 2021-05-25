package com.voximplant.sdk.internal.proto;

import java.util.Map;
public class M_disconnectCall extends WSMessageCall {
    public M_disconnectCall(String str, Map map) {
        this.params.add(str);
        this.params.add(map);
    }
}
