package com.facebook.common.time;
public class SystemClock implements Clock {
    public static final SystemClock a = new SystemClock();

    public static SystemClock get() {
        return a;
    }

    @Override // com.facebook.common.time.Clock
    public long now() {
        return System.currentTimeMillis();
    }
}
