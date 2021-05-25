package com.voximplant.sdk.internal.proto;

import java.util.Map;
public class M_loginUsingOneTimeKey extends WSMessageAuth {
    public M_loginUsingOneTimeKey(String str, String str2, Map<String, String> map) {
        this.params.add(str);
        this.params.add(str2);
        this.params.add(map);
    }
}
