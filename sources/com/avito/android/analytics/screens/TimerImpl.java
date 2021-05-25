package com.avito.android.analytics.screens;

import android.os.SystemClock;
import com.avito.android.remote.auth.AuthSource;
import com.yandex.mobile.ads.video.tracking.Tracker;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\r\u001a\u00020\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0003\u001a\u00020\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/analytics/screens/TimerImpl;", "Lcom/avito/android/analytics/screens/Timer;", "", Tracker.Events.CREATIVE_START, "()V", Tracker.Events.CREATIVE_PAUSE, "stop", "restart", "", "elapsed", "()J", AuthSource.BOOKING_ORDER, "J", "alreadyElapsed", AuthSource.SEND_ABUSE, "<init>", "analytics_release"}, k = 1, mv = {1, 4, 2})
public final class TimerImpl implements Timer {
    public long a;
    public long b;

    @Override // com.avito.android.analytics.screens.Timer
    public long elapsed() {
        return (SystemClock.elapsedRealtime() - this.a) + this.b;
    }

    @Override // com.avito.android.analytics.screens.Timer
    public void pause() {
        this.b += SystemClock.elapsedRealtime() - this.a;
    }

    @Override // com.avito.android.analytics.screens.Timer
    public void restart() {
        this.b = 0;
        start();
    }

    @Override // com.avito.android.analytics.screens.Timer
    public void start() {
        this.a = SystemClock.elapsedRealtime();
    }

    @Override // com.avito.android.analytics.screens.Timer
    public void stop() {
        this.b = 0;
        this.a = 0;
    }
}
