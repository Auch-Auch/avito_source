package com.voximplant.sdk.call;
public class CallException extends Exception {
    public CallError a;

    public CallException(CallError callError, String str) {
        super(str);
        this.a = callError;
    }

    public CallError getErrorCode() {
        return this.a;
    }
}
