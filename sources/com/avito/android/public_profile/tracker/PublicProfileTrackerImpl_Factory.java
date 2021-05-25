package com.avito.android.public_profile.tracker;

import com.avito.android.analytics.screens.Screen;
import com.avito.android.analytics.screens.ScreenFlowTrackerProvider;
import com.avito.android.analytics.screens.ScreenTransferRecovery;
import com.avito.android.analytics.screens.tracker.ScreenDiInjectTracker;
import com.avito.android.analytics.screens.tracker.ScreenInitTracker;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class PublicProfileTrackerImpl_Factory implements Factory<PublicProfileTrackerImpl> {
    public final Provider<ScreenDiInjectTracker> a;
    public final Provider<ScreenInitTracker> b;
    public final Provider<ScreenFlowTrackerProvider> c;
    public final Provider<Screen> d;
    public final Provider<ScreenTransferRecovery> e;

    public PublicProfileTrackerImpl_Factory(Provider<ScreenDiInjectTracker> provider, Provider<ScreenInitTracker> provider2, Provider<ScreenFlowTrackerProvider> provider3, Provider<Screen> provider4, Provider<ScreenTransferRecovery> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static PublicProfileTrackerImpl_Factory create(Provider<ScreenDiInjectTracker> provider, Provider<ScreenInitTracker> provider2, Provider<ScreenFlowTrackerProvider> provider3, Provider<Screen> provider4, Provider<ScreenTransferRecovery> provider5) {
        return new PublicProfileTrackerImpl_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static PublicProfileTrackerImpl newInstance(ScreenDiInjectTracker screenDiInjectTracker, ScreenInitTracker screenInitTracker, ScreenFlowTrackerProvider screenFlowTrackerProvider, Screen screen, ScreenTransferRecovery screenTransferRecovery) {
        return new PublicProfileTrackerImpl(screenDiInjectTracker, screenInitTracker, screenFlowTrackerProvider, screen, screenTransferRecovery);
    }

    @Override // javax.inject.Provider
    public PublicProfileTrackerImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
