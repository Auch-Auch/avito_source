package com.avito.android.public_profile.tracker;

import com.avito.android.analytics.screens.ScreenFlowTrackerProvider;
import com.avito.android.analytics.screens.tracker.ScreenDiInjectTracker;
import com.avito.android.analytics.screens.tracker.ScreenInitTracker;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class PublicProfileAdvertsTrackerImpl_Factory implements Factory<PublicProfileAdvertsTrackerImpl> {
    public final Provider<ScreenDiInjectTracker> a;
    public final Provider<ScreenInitTracker> b;
    public final Provider<ScreenFlowTrackerProvider> c;
    public final Provider<String> d;

    public PublicProfileAdvertsTrackerImpl_Factory(Provider<ScreenDiInjectTracker> provider, Provider<ScreenInitTracker> provider2, Provider<ScreenFlowTrackerProvider> provider3, Provider<String> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static PublicProfileAdvertsTrackerImpl_Factory create(Provider<ScreenDiInjectTracker> provider, Provider<ScreenInitTracker> provider2, Provider<ScreenFlowTrackerProvider> provider3, Provider<String> provider4) {
        return new PublicProfileAdvertsTrackerImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static PublicProfileAdvertsTrackerImpl newInstance(ScreenDiInjectTracker screenDiInjectTracker, ScreenInitTracker screenInitTracker, ScreenFlowTrackerProvider screenFlowTrackerProvider, String str) {
        return new PublicProfileAdvertsTrackerImpl(screenDiInjectTracker, screenInitTracker, screenFlowTrackerProvider, str);
    }

    @Override // javax.inject.Provider
    public PublicProfileAdvertsTrackerImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
