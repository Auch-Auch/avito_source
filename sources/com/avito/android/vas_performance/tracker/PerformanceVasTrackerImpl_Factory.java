package com.avito.android.vas_performance.tracker;

import com.avito.android.analytics.screens.ScreenFlowTrackerProvider;
import com.avito.android.analytics.screens.tracker.ScreenDiInjectTracker;
import com.avito.android.analytics.screens.tracker.ScreenInitTracker;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class PerformanceVasTrackerImpl_Factory implements Factory<PerformanceVasTrackerImpl> {
    public final Provider<ScreenDiInjectTracker> a;
    public final Provider<ScreenInitTracker> b;
    public final Provider<ScreenFlowTrackerProvider> c;

    public PerformanceVasTrackerImpl_Factory(Provider<ScreenDiInjectTracker> provider, Provider<ScreenInitTracker> provider2, Provider<ScreenFlowTrackerProvider> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static PerformanceVasTrackerImpl_Factory create(Provider<ScreenDiInjectTracker> provider, Provider<ScreenInitTracker> provider2, Provider<ScreenFlowTrackerProvider> provider3) {
        return new PerformanceVasTrackerImpl_Factory(provider, provider2, provider3);
    }

    public static PerformanceVasTrackerImpl newInstance(ScreenDiInjectTracker screenDiInjectTracker, ScreenInitTracker screenInitTracker, ScreenFlowTrackerProvider screenFlowTrackerProvider) {
        return new PerformanceVasTrackerImpl(screenDiInjectTracker, screenInitTracker, screenFlowTrackerProvider);
    }

    @Override // javax.inject.Provider
    public PerformanceVasTrackerImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
