package com.avito.android.extended_profile.tracker;

import com.avito.android.analytics.screens.ScreenFlowTrackerProvider;
import com.avito.android.analytics.screens.ScreenTransferRecovery;
import com.avito.android.analytics.screens.tracker.ScreenDiInjectTracker;
import com.avito.android.analytics.screens.tracker.ScreenInitTracker;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ExtendedProfileTrackerImpl_Factory implements Factory<ExtendedProfileTrackerImpl> {
    public final Provider<ScreenDiInjectTracker> a;
    public final Provider<ScreenInitTracker> b;
    public final Provider<ScreenFlowTrackerProvider> c;
    public final Provider<ScreenTransferRecovery> d;

    public ExtendedProfileTrackerImpl_Factory(Provider<ScreenDiInjectTracker> provider, Provider<ScreenInitTracker> provider2, Provider<ScreenFlowTrackerProvider> provider3, Provider<ScreenTransferRecovery> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static ExtendedProfileTrackerImpl_Factory create(Provider<ScreenDiInjectTracker> provider, Provider<ScreenInitTracker> provider2, Provider<ScreenFlowTrackerProvider> provider3, Provider<ScreenTransferRecovery> provider4) {
        return new ExtendedProfileTrackerImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static ExtendedProfileTrackerImpl newInstance(ScreenDiInjectTracker screenDiInjectTracker, ScreenInitTracker screenInitTracker, ScreenFlowTrackerProvider screenFlowTrackerProvider, ScreenTransferRecovery screenTransferRecovery) {
        return new ExtendedProfileTrackerImpl(screenDiInjectTracker, screenInitTracker, screenFlowTrackerProvider, screenTransferRecovery);
    }

    @Override // javax.inject.Provider
    public ExtendedProfileTrackerImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
