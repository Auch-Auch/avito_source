package com.voximplant.sdk.internal.callbacks;

import com.voximplant.sdk.client.AuthParams;
public class OnLoginSuccessful extends Callback {
    public final String a;
    public final AuthParams b;

    public OnLoginSuccessful(String str, AuthParams authParams) {
        this.a = str;
        this.b = authParams;
    }

    public String getDisplayName() {
        return this.a;
    }

    public AuthParams getLoginTokens() {
        return this.b;
    }
}
