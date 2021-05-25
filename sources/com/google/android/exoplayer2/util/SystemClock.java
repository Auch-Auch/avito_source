package com.google.android.exoplayer2.util;

import a2.j.b.b.e1.d;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
public class SystemClock implements Clock {
    @Override // com.google.android.exoplayer2.util.Clock
    public HandlerWrapper createHandler(Looper looper, @Nullable Handler.Callback callback) {
        return new d(new Handler(looper, callback));
    }

    @Override // com.google.android.exoplayer2.util.Clock
    public long currentTimeMillis() {
        return System.currentTimeMillis();
    }

    @Override // com.google.android.exoplayer2.util.Clock
    public long elapsedRealtime() {
        return android.os.SystemClock.elapsedRealtime();
    }

    @Override // com.google.android.exoplayer2.util.Clock
    public void sleep(long j) {
        android.os.SystemClock.sleep(j);
    }

    @Override // com.google.android.exoplayer2.util.Clock
    public long uptimeMillis() {
        return android.os.SystemClock.uptimeMillis();
    }
}
