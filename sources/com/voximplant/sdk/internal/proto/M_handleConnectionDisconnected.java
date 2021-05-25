package com.voximplant.sdk.internal.proto;

import java.util.HashMap;
import java.util.Map;
public class M_handleConnectionDisconnected extends WSMessageCall {
    public boolean getAnsweredElsewhereStatus() {
        if (this.params.size() < 3) {
            return false;
        }
        Map map = (Map) this.params.get(2);
        if (map.containsKey("answeredElsewhere")) {
            return ((Boolean) map.get("answeredElsewhere")).booleanValue();
        }
        return false;
    }

    public Map<String, String> headers() {
        return this.params.size() >= 2 ? (Map) this.params.get(1) : new HashMap();
    }
}
