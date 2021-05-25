package com.facebook.common.time;

import android.os.SystemClock;
import com.facebook.common.internal.DoNotStrip;
@DoNotStrip
public class RealtimeSinceBootClock implements MonotonicClock {
    public static final RealtimeSinceBootClock a = new RealtimeSinceBootClock();

    private RealtimeSinceBootClock() {
    }

    @DoNotStrip
    public static RealtimeSinceBootClock get() {
        return a;
    }

    @Override // com.facebook.common.time.MonotonicClock
    public long now() {
        return SystemClock.elapsedRealtime();
    }
}
