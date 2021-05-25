package com.google.android.gms.internal.ads;

import java.util.concurrent.TimeoutException;
public final class zzdwi extends TimeoutException {
    private zzdwi(String str) {
        super(str);
    }

    @Override // java.lang.Throwable
    public final synchronized Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }
}
