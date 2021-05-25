package com.avito.android.fps;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\t\n\u0002\b\u0006\u001a\u0013\u0010\u0001\u001a\u00020\u0000*\u00020\u0000H\u0000¢\u0006\u0004\b\u0001\u0010\u0002\u001a\u0013\u0010\u0003\u001a\u00020\u0000*\u00020\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\u0002\"\u0016\u0010\u0004\u001a\u00020\u00008\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"", "toMs", "(J)J", "toNs", "ONE_SECOND_IN_NANOS", "J", "analytics-screens_release"}, k = 2, mv = {1, 4, 2})
public final class FramesListenerKt {
    public static final long ONE_SECOND_IN_NANOS = 1000000000;

    public static final long toMs(long j) {
        return TimeUnit.MILLISECONDS.convert(j, TimeUnit.NANOSECONDS);
    }

    public static final long toNs(long j) {
        return TimeUnit.NANOSECONDS.convert(j, TimeUnit.MILLISECONDS);
    }
}
