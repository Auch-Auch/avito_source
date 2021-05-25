package com.adjust.sdk;

import ru.avito.messenger.internal.ConstantsKt;
public enum BackoffStrategy {
    LONG_WAIT(1, 120000, 86400000, 0.5d, 1.0d),
    SHORT_WAIT(1, 200, ConstantsKt.DEFAULT_TIME_TO_MODIFY_MESSAGE_MS, 0.5d, 1.0d),
    TEST_WAIT(1, 200, 1000, 0.5d, 1.0d),
    NO_WAIT(100, 1, 1000, 1.0d, 1.0d);
    
    public double maxRange;
    public long maxWait;
    public long milliSecondMultiplier;
    public double minRange;
    public int minRetries;

    private BackoffStrategy(int i, long j, long j2, double d, double d2) {
        this.minRetries = i;
        this.milliSecondMultiplier = j;
        this.maxWait = j2;
        this.minRange = d;
        this.maxRange = d2;
    }
}
