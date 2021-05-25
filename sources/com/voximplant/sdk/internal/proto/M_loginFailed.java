package com.voximplant.sdk.internal.proto;
public class M_loginFailed extends WSMessageAuth {
    public int getErrorCode() {
        return ((Double) this.params.get(0)).intValue();
    }

    public String getOneTimeKey() {
        return (String) this.params.get(1);
    }
}
