package com.avito.android.basket_legacy;

import com.avito.android.analytics.screens.tracker.ScreenDiInjectTracker;
import com.avito.android.analytics.screens.tracker.ScreenInitTracker;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class LegacyPaidServicesTrackerImpl_Factory implements Factory<LegacyPaidServicesTrackerImpl> {
    public final Provider<ScreenDiInjectTracker> a;
    public final Provider<ScreenInitTracker> b;

    public LegacyPaidServicesTrackerImpl_Factory(Provider<ScreenDiInjectTracker> provider, Provider<ScreenInitTracker> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static LegacyPaidServicesTrackerImpl_Factory create(Provider<ScreenDiInjectTracker> provider, Provider<ScreenInitTracker> provider2) {
        return new LegacyPaidServicesTrackerImpl_Factory(provider, provider2);
    }

    public static LegacyPaidServicesTrackerImpl newInstance(ScreenDiInjectTracker screenDiInjectTracker, ScreenInitTracker screenInitTracker) {
        return new LegacyPaidServicesTrackerImpl(screenDiInjectTracker, screenInitTracker);
    }

    @Override // javax.inject.Provider
    public LegacyPaidServicesTrackerImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
