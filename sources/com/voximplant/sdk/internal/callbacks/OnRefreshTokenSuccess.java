package com.voximplant.sdk.internal.callbacks;

import com.voximplant.sdk.client.AuthParams;
public class OnRefreshTokenSuccess extends Callback {
    public final AuthParams a;

    public OnRefreshTokenSuccess(AuthParams authParams) {
        this.a = authParams;
    }

    public AuthParams getLoginTokens() {
        return this.a;
    }
}
