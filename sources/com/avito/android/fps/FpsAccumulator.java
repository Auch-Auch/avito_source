package com.avito.android.fps;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0019\u0010\fJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\r\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\tJ\r\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\fR$\u0010\u0012\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00028\u0006@BX\u000e¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R$\u0010\u0018\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u00138\u0006@BX\u000e¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/avito/android/fps/FpsAccumulator;", "", "", "frameTimeNanos", "", "addFrameLength", "(J)V", "", "meanFrameLength", "()D", "meanFps", "clear", "()V", "<set-?>", AuthSource.BOOKING_ORDER, "J", "getTotalDelayNs", "()J", "totalDelayNs", "", AuthSource.SEND_ABUSE, "I", "getFrameCount", "()I", "frameCount", "<init>", "analytics-screens_release"}, k = 1, mv = {1, 4, 2})
public final class FpsAccumulator {
    public int a;
    public long b;

    public final void addFrameLength(long j) {
        this.a++;
        this.b += j;
    }

    public final void clear() {
        this.a = 0;
        this.b = 0;
    }

    public final int getFrameCount() {
        return this.a;
    }

    public final long getTotalDelayNs() {
        return this.b;
    }

    public final double meanFps() {
        return ((double) 1000000000) / meanFrameLength();
    }

    public final double meanFrameLength() {
        return (((double) this.b) * 1.0d) / ((double) this.a);
    }
}
