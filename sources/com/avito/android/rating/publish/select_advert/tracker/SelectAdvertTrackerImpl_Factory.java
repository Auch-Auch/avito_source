package com.avito.android.rating.publish.select_advert.tracker;

import com.avito.android.analytics.screens.ScreenFlowTrackerProvider;
import com.avito.android.analytics.screens.tracker.ScreenDiInjectTracker;
import com.avito.android.analytics.screens.tracker.ScreenInitTracker;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SelectAdvertTrackerImpl_Factory implements Factory<SelectAdvertTrackerImpl> {
    public final Provider<ScreenDiInjectTracker> a;
    public final Provider<ScreenInitTracker> b;
    public final Provider<ScreenFlowTrackerProvider> c;

    public SelectAdvertTrackerImpl_Factory(Provider<ScreenDiInjectTracker> provider, Provider<ScreenInitTracker> provider2, Provider<ScreenFlowTrackerProvider> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static SelectAdvertTrackerImpl_Factory create(Provider<ScreenDiInjectTracker> provider, Provider<ScreenInitTracker> provider2, Provider<ScreenFlowTrackerProvider> provider3) {
        return new SelectAdvertTrackerImpl_Factory(provider, provider2, provider3);
    }

    public static SelectAdvertTrackerImpl newInstance(ScreenDiInjectTracker screenDiInjectTracker, ScreenInitTracker screenInitTracker, ScreenFlowTrackerProvider screenFlowTrackerProvider) {
        return new SelectAdvertTrackerImpl(screenDiInjectTracker, screenInitTracker, screenFlowTrackerProvider);
    }

    @Override // javax.inject.Provider
    public SelectAdvertTrackerImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
