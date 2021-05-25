package com.avito.android.performance;

import com.avito.android.analytics.screens.tracker.ScreenInitTracker;
import com.avito.android.performance.SimpleTracker;
import com.avito.android.remote.auth.AuthSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/avito/android/performance/InitTracker;", "Lcom/avito/android/performance/SimpleTracker;", "", "started", "()V", "finished", "Lcom/avito/android/analytics/screens/tracker/ScreenInitTracker;", AuthSource.SEND_ABUSE, "Lcom/avito/android/analytics/screens/tracker/ScreenInitTracker;", "initTracker", "<init>", "(Lcom/avito/android/analytics/screens/tracker/ScreenInitTracker;)V", "tns-core_release"}, k = 1, mv = {1, 4, 2})
public final class InitTracker implements SimpleTracker {
    public final ScreenInitTracker a;

    @Inject
    public InitTracker(@NotNull ScreenInitTracker screenInitTracker) {
        Intrinsics.checkNotNullParameter(screenInitTracker, "initTracker");
        this.a = screenInitTracker;
    }

    @Override // com.avito.android.performance.SimpleTracker
    public void finished() {
        ScreenInitTracker.DefaultImpls.trackInit$default(this.a, 0, 1, null);
    }

    @Override // com.avito.android.performance.SimpleTracker
    public void started() {
        this.a.start();
    }

    @Override // com.avito.android.performance.SimpleTracker
    public void stop() {
        SimpleTracker.DefaultImpls.stop(this);
    }
}
