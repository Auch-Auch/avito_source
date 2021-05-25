package com.avito.android.async_phone;

import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.analytics.screens.PublicConstantsKt;
import com.avito.android.analytics.screens.Screen;
import com.avito.android.analytics.screens.ScreenFlowTrackerProvider;
import com.avito.android.analytics.screens.TimerFactory;
import com.avito.android.analytics.screens.tracker.ContentLoadingTracker;
import com.avito.android.analytics.screens.tracker.ScreenTrackerFactory;
import com.avito.android.remote.auth.AuthSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0004R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/avito/android/async_phone/AsyncPhoneTrackerImpl;", "Lcom/avito/android/async_phone/AsyncPhoneTracker;", "", "startLoadingPhone", "()V", "trackPhoneLoaded", "trackPhoneLoadError", "Lcom/avito/android/analytics/screens/ScreenFlowTrackerProvider;", AuthSource.SEND_ABUSE, "Lcom/avito/android/analytics/screens/ScreenFlowTrackerProvider;", "flowTrackerProvider", "Lcom/avito/android/analytics/screens/tracker/ContentLoadingTracker;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/analytics/screens/tracker/ContentLoadingTracker;", "phoneLoadingTracker", "Lcom/avito/android/analytics/screens/tracker/ScreenTrackerFactory;", "screenTrackerFactory", "Lcom/avito/android/analytics/screens/TimerFactory;", "factory", "Lcom/avito/android/analytics/screens/Screen;", InternalConstsKt.SCREEN, "<init>", "(Lcom/avito/android/analytics/screens/tracker/ScreenTrackerFactory;Lcom/avito/android/analytics/screens/TimerFactory;Lcom/avito/android/analytics/screens/Screen;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class AsyncPhoneTrackerImpl implements AsyncPhoneTracker {
    public final ScreenFlowTrackerProvider a;
    public ContentLoadingTracker b;

    @Inject
    public AsyncPhoneTrackerImpl(@NotNull ScreenTrackerFactory screenTrackerFactory, @NotNull TimerFactory timerFactory, @NotNull Screen screen) {
        Intrinsics.checkNotNullParameter(screenTrackerFactory, "screenTrackerFactory");
        Intrinsics.checkNotNullParameter(timerFactory, "factory");
        Intrinsics.checkNotNullParameter(screen, InternalConstsKt.SCREEN);
        this.a = screenTrackerFactory.createScreenFlowTrackerProvider(screen, timerFactory);
    }

    @Override // com.avito.android.async_phone.AsyncPhoneTracker
    public void startLoadingPhone() {
        ContentLoadingTracker contentLoadingFromRemoteStorage = this.a.getContentLoadingFromRemoteStorage("phone");
        contentLoadingFromRemoteStorage.start();
        Unit unit = Unit.INSTANCE;
        this.b = contentLoadingFromRemoteStorage;
    }

    @Override // com.avito.android.async_phone.AsyncPhoneTracker
    public void trackPhoneLoadError() {
        ContentLoadingTracker contentLoadingTracker = this.b;
        if (contentLoadingTracker != null) {
            ContentLoadingTracker.DefaultImpls.trackContentLoading$default(contentLoadingTracker, null, PublicConstantsKt.FAILURE, 0, 4, null);
        }
        this.b = null;
    }

    @Override // com.avito.android.async_phone.AsyncPhoneTracker
    public void trackPhoneLoaded() {
        ContentLoadingTracker contentLoadingTracker = this.b;
        if (contentLoadingTracker != null) {
            ContentLoadingTracker.DefaultImpls.trackContentLoading$default(contentLoadingTracker, null, "success", 0, 4, null);
        }
        this.b = null;
    }
}
