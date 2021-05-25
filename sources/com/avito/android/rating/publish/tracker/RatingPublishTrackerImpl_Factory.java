package com.avito.android.rating.publish.tracker;

import com.avito.android.analytics.screens.ScreenFlowTrackerProvider;
import com.avito.android.analytics.screens.ScreenTransferRecovery;
import com.avito.android.analytics.screens.tracker.ScreenDiInjectTracker;
import com.avito.android.analytics.screens.tracker.ScreenInitTracker;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class RatingPublishTrackerImpl_Factory implements Factory<RatingPublishTrackerImpl> {
    public final Provider<ScreenDiInjectTracker> a;
    public final Provider<ScreenInitTracker> b;
    public final Provider<ScreenFlowTrackerProvider> c;
    public final Provider<ScreenTransferRecovery> d;

    public RatingPublishTrackerImpl_Factory(Provider<ScreenDiInjectTracker> provider, Provider<ScreenInitTracker> provider2, Provider<ScreenFlowTrackerProvider> provider3, Provider<ScreenTransferRecovery> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static RatingPublishTrackerImpl_Factory create(Provider<ScreenDiInjectTracker> provider, Provider<ScreenInitTracker> provider2, Provider<ScreenFlowTrackerProvider> provider3, Provider<ScreenTransferRecovery> provider4) {
        return new RatingPublishTrackerImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static RatingPublishTrackerImpl newInstance(ScreenDiInjectTracker screenDiInjectTracker, ScreenInitTracker screenInitTracker, ScreenFlowTrackerProvider screenFlowTrackerProvider, ScreenTransferRecovery screenTransferRecovery) {
        return new RatingPublishTrackerImpl(screenDiInjectTracker, screenInitTracker, screenFlowTrackerProvider, screenTransferRecovery);
    }

    @Override // javax.inject.Provider
    public RatingPublishTrackerImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
