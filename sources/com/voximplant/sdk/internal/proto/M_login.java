package com.voximplant.sdk.internal.proto;

import java.util.HashMap;
import java.util.Map;
public class M_login extends WSMessageAuth {
    public M_login(String str, String str2, Map<String, String> map) {
        map = map == null ? new HashMap<>() : map;
        this.params.add(str);
        this.params.add(str2);
        if (str2 == null || str2.isEmpty()) {
            map.put("credentialType", "basic");
        } else {
            map.put("credentialType", "md5");
        }
        this.params.add(map);
    }

    public String user() {
        return (String) this.params.get(0);
    }
}
