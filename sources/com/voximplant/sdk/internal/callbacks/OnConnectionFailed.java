package com.voximplant.sdk.internal.callbacks;
public class OnConnectionFailed extends Callback {
    public final String a;

    public OnConnectionFailed(String str) {
        this.a = str;
    }

    public String getError() {
        return this.a;
    }
}
