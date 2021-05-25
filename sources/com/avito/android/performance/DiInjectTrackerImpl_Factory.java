package com.avito.android.performance;

import com.avito.android.analytics.screens.tracker.ScreenDiInjectTracker;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class DiInjectTrackerImpl_Factory implements Factory<DiInjectTrackerImpl> {
    public final Provider<ScreenDiInjectTracker> a;

    public DiInjectTrackerImpl_Factory(Provider<ScreenDiInjectTracker> provider) {
        this.a = provider;
    }

    public static DiInjectTrackerImpl_Factory create(Provider<ScreenDiInjectTracker> provider) {
        return new DiInjectTrackerImpl_Factory(provider);
    }

    public static DiInjectTrackerImpl newInstance(ScreenDiInjectTracker screenDiInjectTracker) {
        return new DiInjectTrackerImpl(screenDiInjectTracker);
    }

    @Override // javax.inject.Provider
    public DiInjectTrackerImpl get() {
        return newInstance(this.a.get());
    }
}
