package com.avito.android.analytics.screens.tracker;

import com.avito.android.analytics.screens.ScreenFlowTrackerProvider;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class BaseScreenPerformanceTrackerImpl_Factory implements Factory<BaseScreenPerformanceTrackerImpl> {
    public final Provider<ScreenDiInjectTracker> a;
    public final Provider<ScreenInitTracker> b;
    public final Provider<ScreenFlowTrackerProvider> c;
    public final Provider<String> d;

    public BaseScreenPerformanceTrackerImpl_Factory(Provider<ScreenDiInjectTracker> provider, Provider<ScreenInitTracker> provider2, Provider<ScreenFlowTrackerProvider> provider3, Provider<String> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static BaseScreenPerformanceTrackerImpl_Factory create(Provider<ScreenDiInjectTracker> provider, Provider<ScreenInitTracker> provider2, Provider<ScreenFlowTrackerProvider> provider3, Provider<String> provider4) {
        return new BaseScreenPerformanceTrackerImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static BaseScreenPerformanceTrackerImpl newInstance(ScreenDiInjectTracker screenDiInjectTracker, ScreenInitTracker screenInitTracker, ScreenFlowTrackerProvider screenFlowTrackerProvider, String str) {
        return new BaseScreenPerformanceTrackerImpl(screenDiInjectTracker, screenInitTracker, screenFlowTrackerProvider, str);
    }

    @Override // javax.inject.Provider
    public BaseScreenPerformanceTrackerImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
