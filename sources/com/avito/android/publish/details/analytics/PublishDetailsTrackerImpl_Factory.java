package com.avito.android.publish.details.analytics;

import com.avito.android.analytics.screens.ScreenFlowTrackerProvider;
import com.avito.android.analytics.screens.ScreenTransferRecovery;
import com.avito.android.analytics.screens.tracker.ScreenDiInjectTracker;
import com.avito.android.analytics.screens.tracker.ScreenInitTracker;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class PublishDetailsTrackerImpl_Factory implements Factory<PublishDetailsTrackerImpl> {
    public final Provider<ScreenFlowTrackerProvider> a;
    public final Provider<ScreenDiInjectTracker> b;
    public final Provider<ScreenInitTracker> c;
    public final Provider<ScreenTransferRecovery> d;

    public PublishDetailsTrackerImpl_Factory(Provider<ScreenFlowTrackerProvider> provider, Provider<ScreenDiInjectTracker> provider2, Provider<ScreenInitTracker> provider3, Provider<ScreenTransferRecovery> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static PublishDetailsTrackerImpl_Factory create(Provider<ScreenFlowTrackerProvider> provider, Provider<ScreenDiInjectTracker> provider2, Provider<ScreenInitTracker> provider3, Provider<ScreenTransferRecovery> provider4) {
        return new PublishDetailsTrackerImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static PublishDetailsTrackerImpl newInstance(ScreenFlowTrackerProvider screenFlowTrackerProvider, ScreenDiInjectTracker screenDiInjectTracker, ScreenInitTracker screenInitTracker, ScreenTransferRecovery screenTransferRecovery) {
        return new PublishDetailsTrackerImpl(screenFlowTrackerProvider, screenDiInjectTracker, screenInitTracker, screenTransferRecovery);
    }

    @Override // javax.inject.Provider
    public PublishDetailsTrackerImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
