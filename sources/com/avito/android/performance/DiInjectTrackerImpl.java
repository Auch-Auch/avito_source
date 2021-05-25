package com.avito.android.performance;

import com.avito.android.analytics.screens.Timer;
import com.avito.android.analytics.screens.tracker.ScreenDiInjectTracker;
import com.avito.android.remote.auth.AuthSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/performance/DiInjectTrackerImpl;", "Lcom/avito/android/performance/DiInjectTracker;", "Lcom/avito/android/analytics/screens/Timer;", "tracker", "", "finished", "(Lcom/avito/android/analytics/screens/Timer;)V", "Lcom/avito/android/analytics/screens/tracker/ScreenDiInjectTracker;", AuthSource.SEND_ABUSE, "Lcom/avito/android/analytics/screens/tracker/ScreenDiInjectTracker;", "diInjectTracker", "<init>", "(Lcom/avito/android/analytics/screens/tracker/ScreenDiInjectTracker;)V", "tns-core_release"}, k = 1, mv = {1, 4, 2})
public final class DiInjectTrackerImpl implements DiInjectTracker {
    public final ScreenDiInjectTracker a;

    @Inject
    public DiInjectTrackerImpl(@NotNull ScreenDiInjectTracker screenDiInjectTracker) {
        Intrinsics.checkNotNullParameter(screenDiInjectTracker, "diInjectTracker");
        this.a = screenDiInjectTracker;
    }

    @Override // com.avito.android.performance.DiInjectTracker
    public void finished(@NotNull Timer timer) {
        Intrinsics.checkNotNullParameter(timer, "tracker");
        this.a.track(timer.elapsed());
    }
}
