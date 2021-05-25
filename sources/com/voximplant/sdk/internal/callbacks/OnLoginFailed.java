package com.voximplant.sdk.internal.callbacks;
public class OnLoginFailed extends Callback {
    public final int a;

    public OnLoginFailed(int i) {
        this.a = i;
    }

    public int getErrorCode() {
        return this.a;
    }
}
