package com.avito.android.analytics.screens.tracker;

import com.avito.android.analytics.screens.Timer;
import com.avito.android.analytics.screens.TimerFactory;
import com.avito.android.remote.auth.AuthSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u000eJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0004H&¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0004H&¢\u0006\u0004\b\n\u0010\tJ\u000f\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Lcom/avito/android/analytics/screens/tracker/UnknownScreenTracker;", "", "", "durationMs", "", "trackInit", "(J)V", "trackDiInject", "startLoading", "()V", "trackLoading", "Lcom/avito/android/analytics/screens/tracker/ScreenTransfer;", "toScreenTransfer", "()Lcom/avito/android/analytics/screens/tracker/ScreenTransfer;", "Impl", "analytics-screens_release"}, k = 1, mv = {1, 4, 2})
public interface UnknownScreenTracker {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0018\u001a\u00020\u0015¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\tJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0010\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u000fR\u0016\u0010\u001c\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u000f¨\u0006\u001f"}, d2 = {"Lcom/avito/android/analytics/screens/tracker/UnknownScreenTracker$Impl;", "Lcom/avito/android/analytics/screens/tracker/UnknownScreenTracker;", "", "durationMs", "", "trackInit", "(J)V", "trackDiInject", "startLoading", "()V", "trackLoading", "Lcom/avito/android/analytics/screens/tracker/ScreenTransfer;", "toScreenTransfer", "()Lcom/avito/android/analytics/screens/tracker/ScreenTransfer;", "d", "J", "diTime", "Lcom/avito/android/analytics/screens/Timer;", AuthSource.SEND_ABUSE, "Lcom/avito/android/analytics/screens/Timer;", "timer", "Lcom/avito/android/analytics/screens/TimerFactory;", "e", "Lcom/avito/android/analytics/screens/TimerFactory;", "timerFactory", "c", "loadingTime", AuthSource.BOOKING_ORDER, "initTime", "<init>", "(Lcom/avito/android/analytics/screens/TimerFactory;)V", "analytics-screens_release"}, k = 1, mv = {1, 4, 2})
    public static final class Impl implements UnknownScreenTracker {
        public final Timer a;
        public long b = -1;
        public long c = -1;
        public long d = -1;
        public final TimerFactory e;

        @Inject
        public Impl(@NotNull TimerFactory timerFactory) {
            Intrinsics.checkNotNullParameter(timerFactory, "timerFactory");
            this.e = timerFactory;
            this.a = timerFactory.timer();
        }

        @Override // com.avito.android.analytics.screens.tracker.UnknownScreenTracker
        public void startLoading() {
            this.a.start();
        }

        @Override // com.avito.android.analytics.screens.tracker.UnknownScreenTracker
        @NotNull
        public ScreenTransfer toScreenTransfer() {
            return new ScreenTransfer(this.b, this.c, this.d);
        }

        @Override // com.avito.android.analytics.screens.tracker.UnknownScreenTracker
        public void trackDiInject(long j) {
            this.d = j;
        }

        @Override // com.avito.android.analytics.screens.tracker.UnknownScreenTracker
        public void trackInit(long j) {
            this.b = j;
        }

        @Override // com.avito.android.analytics.screens.tracker.UnknownScreenTracker
        public void trackLoading() {
            this.c = this.a.elapsed();
        }
    }

    void startLoading();

    @NotNull
    ScreenTransfer toScreenTransfer();

    void trackDiInject(long j);

    void trackInit(long j);

    void trackLoading();
}
