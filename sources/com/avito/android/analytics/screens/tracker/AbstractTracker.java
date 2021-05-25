package com.avito.android.analytics.screens.tracker;

import com.avito.android.analytics.screens.Timer;
import com.avito.android.remote.auth.AuthSource;
import com.yandex.mobile.ads.video.tracking.Tracker;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/avito/android/analytics/screens/tracker/AbstractTracker;", "Lcom/avito/android/analytics/screens/tracker/Tracker;", "", Tracker.Events.CREATIVE_START, "()V", "", "elapsed", "()J", "Lcom/avito/android/analytics/screens/Timer;", AuthSource.SEND_ABUSE, "Lcom/avito/android/analytics/screens/Timer;", "timer", "<init>", "(Lcom/avito/android/analytics/screens/Timer;)V", "analytics-screens_release"}, k = 1, mv = {1, 4, 2})
public abstract class AbstractTracker implements Tracker {
    public final Timer a;

    public AbstractTracker(@NotNull Timer timer) {
        Intrinsics.checkNotNullParameter(timer, "timer");
        this.a = timer;
    }

    public final long elapsed() {
        return this.a.elapsed();
    }

    @Override // com.avito.android.analytics.screens.tracker.Tracker
    public final void start() {
        this.a.start();
    }
}
