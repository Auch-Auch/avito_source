package com.avito.android.publish.analytics;

import com.avito.android.analytics.screens.ScreenFlowTrackerProvider;
import com.avito.android.analytics.screens.tracker.ScreenDiInjectTracker;
import com.avito.android.analytics.screens.tracker.ScreenInitTracker;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class PublishContactsTrackerImpl_Factory implements Factory<PublishContactsTrackerImpl> {
    public final Provider<ScreenDiInjectTracker> a;
    public final Provider<ScreenInitTracker> b;
    public final Provider<ScreenFlowTrackerProvider> c;

    public PublishContactsTrackerImpl_Factory(Provider<ScreenDiInjectTracker> provider, Provider<ScreenInitTracker> provider2, Provider<ScreenFlowTrackerProvider> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static PublishContactsTrackerImpl_Factory create(Provider<ScreenDiInjectTracker> provider, Provider<ScreenInitTracker> provider2, Provider<ScreenFlowTrackerProvider> provider3) {
        return new PublishContactsTrackerImpl_Factory(provider, provider2, provider3);
    }

    public static PublishContactsTrackerImpl newInstance(ScreenDiInjectTracker screenDiInjectTracker, ScreenInitTracker screenInitTracker, ScreenFlowTrackerProvider screenFlowTrackerProvider) {
        return new PublishContactsTrackerImpl(screenDiInjectTracker, screenInitTracker, screenFlowTrackerProvider);
    }

    @Override // javax.inject.Provider
    public PublishContactsTrackerImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
