package com.avito.android.user_advert.tracker;

import com.avito.android.analytics.screens.ScreenFlowTrackerProvider;
import com.avito.android.analytics.screens.tracker.ScreenDiInjectTracker;
import com.avito.android.analytics.screens.tracker.ScreenInitTracker;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class MyAdvertDetailsTrackerImpl_Factory implements Factory<MyAdvertDetailsTrackerImpl> {
    public final Provider<ScreenDiInjectTracker> a;
    public final Provider<ScreenInitTracker> b;
    public final Provider<ScreenFlowTrackerProvider> c;

    public MyAdvertDetailsTrackerImpl_Factory(Provider<ScreenDiInjectTracker> provider, Provider<ScreenInitTracker> provider2, Provider<ScreenFlowTrackerProvider> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static MyAdvertDetailsTrackerImpl_Factory create(Provider<ScreenDiInjectTracker> provider, Provider<ScreenInitTracker> provider2, Provider<ScreenFlowTrackerProvider> provider3) {
        return new MyAdvertDetailsTrackerImpl_Factory(provider, provider2, provider3);
    }

    public static MyAdvertDetailsTrackerImpl newInstance(ScreenDiInjectTracker screenDiInjectTracker, ScreenInitTracker screenInitTracker, ScreenFlowTrackerProvider screenFlowTrackerProvider) {
        return new MyAdvertDetailsTrackerImpl(screenDiInjectTracker, screenInitTracker, screenFlowTrackerProvider);
    }

    @Override // javax.inject.Provider
    public MyAdvertDetailsTrackerImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
