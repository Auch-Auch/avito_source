package com.voximplant.sdk.internal.proto;
public class M_refreshOauthTokenFailed extends WSMessageAuth {
    public int getErrorCode() {
        return ((Double) this.params.get(0)).intValue();
    }
}
