package com.voximplant.sdk.internal.proto;
public class M_loginGenerateOneTimeKey extends WSMessageAuth {
    public M_loginGenerateOneTimeKey(String str) {
        this.params.add(str);
        this.params.add(0);
    }
}
