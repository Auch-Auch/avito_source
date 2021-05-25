package com.voximplant.sdk.internal.proto;

import java.util.Map;
public class M_refreshOauthToken extends WSMessageAuth {
    public M_refreshOauthToken(String str, Map<String, String> map) {
        this.params.add(str);
        this.params.add(map);
    }

    @Deprecated
    public M_refreshOauthToken(String str, String str2) {
        this.params.add(str);
        this.params.add(str2);
    }
}
