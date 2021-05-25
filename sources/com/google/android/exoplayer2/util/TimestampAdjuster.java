package com.google.android.exoplayer2.util;

import com.google.android.exoplayer2.C;
public final class TimestampAdjuster {
    public static final long DO_NOT_OFFSET = Long.MAX_VALUE;
    public long a;
    public long b;
    public volatile long c = C.TIME_UNSET;

    public TimestampAdjuster(long j) {
        setFirstSampleTimestampUs(j);
    }

    public static long ptsToUs(long j) {
        return (j * 1000000) / 90000;
    }

    public static long usToNonWrappedPts(long j) {
        return (j * 90000) / 1000000;
    }

    public static long usToWrappedPts(long j) {
        return usToNonWrappedPts(j) % 8589934592L;
    }

    public long adjustSampleTimestamp(long j) {
        if (j == C.TIME_UNSET) {
            return C.TIME_UNSET;
        }
        if (this.c != C.TIME_UNSET) {
            this.c = j;
        } else {
            long j2 = this.a;
            if (j2 != Long.MAX_VALUE) {
                this.b = j2 - j;
            }
            synchronized (this) {
                this.c = j;
                notifyAll();
            }
        }
        return j + this.b;
    }

    public long adjustTsTimestamp(long j) {
        if (j == C.TIME_UNSET) {
            return C.TIME_UNSET;
        }
        if (this.c != C.TIME_UNSET) {
            long usToNonWrappedPts = usToNonWrappedPts(this.c);
            long j2 = (4294967296L + usToNonWrappedPts) / 8589934592L;
            long j3 = ((j2 - 1) * 8589934592L) + j;
            long j4 = (j2 * 8589934592L) + j;
            j = Math.abs(j3 - usToNonWrappedPts) < Math.abs(j4 - usToNonWrappedPts) ? j3 : j4;
        }
        return adjustSampleTimestamp(ptsToUs(j));
    }

    public long getFirstSampleTimestampUs() {
        return this.a;
    }

    public long getLastAdjustedTimestampUs() {
        if (this.c != C.TIME_UNSET) {
            return this.b + this.c;
        }
        long j = this.a;
        if (j != Long.MAX_VALUE) {
            return j;
        }
        return C.TIME_UNSET;
    }

    public long getTimestampOffsetUs() {
        if (this.a == Long.MAX_VALUE) {
            return 0;
        }
        if (this.c == C.TIME_UNSET) {
            return C.TIME_UNSET;
        }
        return this.b;
    }

    public void reset() {
        this.c = C.TIME_UNSET;
    }

    public synchronized void setFirstSampleTimestampUs(long j) {
        Assertions.checkState(this.c == C.TIME_UNSET);
        this.a = j;
    }

    public synchronized void waitUntilInitialized() throws InterruptedException {
        while (this.c == C.TIME_UNSET) {
            wait();
        }
    }
}
