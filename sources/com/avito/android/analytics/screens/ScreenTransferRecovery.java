package com.avito.android.analytics.screens;

import com.avito.android.analytics.screens.tracker.ContentLoadingTracker;
import com.avito.android.analytics.screens.tracker.ScreenTrackerFactory;
import com.avito.android.analytics.screens.tracker.ScreenTransfer;
import com.avito.android.remote.auth.AuthSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u000bJ'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/avito/android/analytics/screens/ScreenTransferRecovery;", "", "Lcom/avito/android/analytics/screens/tracker/ScreenTransfer;", "transfer", "Lcom/avito/android/analytics/screens/Screen;", InternalConstsKt.SCREEN, "", "contentType", "", "recover", "(Lcom/avito/android/analytics/screens/tracker/ScreenTransfer;Lcom/avito/android/analytics/screens/Screen;Ljava/lang/String;)V", "Impl", "analytics-screens_release"}, k = 1, mv = {1, 4, 2})
public interface ScreenTransferRecovery {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b\u0013\u0010\u0014J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/avito/android/analytics/screens/ScreenTransferRecovery$Impl;", "Lcom/avito/android/analytics/screens/ScreenTransferRecovery;", "Lcom/avito/android/analytics/screens/tracker/ScreenTransfer;", "transfer", "Lcom/avito/android/analytics/screens/Screen;", InternalConstsKt.SCREEN, "", "contentType", "", "recover", "(Lcom/avito/android/analytics/screens/tracker/ScreenTransfer;Lcom/avito/android/analytics/screens/Screen;Ljava/lang/String;)V", "Lcom/avito/android/analytics/screens/tracker/ScreenTrackerFactory;", AuthSource.SEND_ABUSE, "Lcom/avito/android/analytics/screens/tracker/ScreenTrackerFactory;", "screenTrackerFactory", "Lcom/avito/android/analytics/screens/TimerFactory;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/analytics/screens/TimerFactory;", "factory", "<init>", "(Lcom/avito/android/analytics/screens/tracker/ScreenTrackerFactory;Lcom/avito/android/analytics/screens/TimerFactory;)V", "analytics-screens_release"}, k = 1, mv = {1, 4, 2})
    public static final class Impl implements ScreenTransferRecovery {
        public final ScreenTrackerFactory a;
        public final TimerFactory b;

        @Inject
        public Impl(@NotNull ScreenTrackerFactory screenTrackerFactory, @NotNull TimerFactory timerFactory) {
            Intrinsics.checkNotNullParameter(screenTrackerFactory, "screenTrackerFactory");
            Intrinsics.checkNotNullParameter(timerFactory, "factory");
            this.a = screenTrackerFactory;
            this.b = timerFactory;
        }

        @Override // com.avito.android.analytics.screens.ScreenTransferRecovery
        public void recover(@NotNull ScreenTransfer screenTransfer, @NotNull Screen screen, @NotNull String str) {
            Intrinsics.checkNotNullParameter(screenTransfer, "transfer");
            Intrinsics.checkNotNullParameter(screen, InternalConstsKt.SCREEN);
            Intrinsics.checkNotNullParameter(str, "contentType");
            if (screenTransfer.getInitTime() != -1) {
                this.a.createDiInjectTracker(screen, this.b, str).track(screenTransfer.getInitTime());
            }
            if (screenTransfer.getLoadingTime() != -1) {
                ContentLoadingTracker.DefaultImpls.trackContentLoading$default(this.a.createScreenFlowTrackerProvider(screen, this.b).getContentLoadingFromRemoteStorage(str), null, "success", screenTransfer.getLoadingTime(), 1, null);
            }
            if (screenTransfer.getDiTime() != -1) {
                this.a.createInitTracker(screen, this.b, str).trackInit(screenTransfer.getDiTime());
            }
        }
    }

    void recover(@NotNull ScreenTransfer screenTransfer, @NotNull Screen screen, @NotNull String str);
}
