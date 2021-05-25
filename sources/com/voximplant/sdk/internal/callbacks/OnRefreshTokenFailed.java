package com.voximplant.sdk.internal.callbacks;
public class OnRefreshTokenFailed extends Callback {
    public final int a;

    public OnRefreshTokenFailed(int i) {
        this.a = i;
    }

    public int getErrorCode() {
        return this.a;
    }
}
