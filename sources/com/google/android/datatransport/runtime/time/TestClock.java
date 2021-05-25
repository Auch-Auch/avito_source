package com.google.android.datatransport.runtime.time;

import java.util.concurrent.atomic.AtomicLong;
public class TestClock implements Clock {
    public final AtomicLong a;

    public TestClock(long j) {
        this.a = new AtomicLong(j);
    }

    public void advance(long j) {
        if (j >= 0) {
            this.a.addAndGet(j);
            return;
        }
        throw new IllegalArgumentException("cannot advance time backwards.");
    }

    @Override // com.google.android.datatransport.runtime.time.Clock
    public long getTime() {
        return this.a.get();
    }

    public void tick() {
        advance(1);
    }
}
