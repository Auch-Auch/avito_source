package com.voximplant.sdk.internal.callbacks;
public class OnOneTimeKeyGenerated extends Callback {
    public final String a;

    public OnOneTimeKeyGenerated(String str) {
        this.a = str;
    }

    public String getKey() {
        return this.a;
    }
}
