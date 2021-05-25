package com.avito.android.analytics.screen;

import com.avito.android.analytics.screens.ScreenFlowTrackerProvider;
import com.avito.android.analytics.screens.tracker.ScreenDiInjectTracker;
import com.avito.android.analytics.screens.tracker.ScreenInitTracker;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class UserProfileTrackerImpl_Factory implements Factory<UserProfileTrackerImpl> {
    public final Provider<ScreenDiInjectTracker> a;
    public final Provider<ScreenInitTracker> b;
    public final Provider<ScreenFlowTrackerProvider> c;

    public UserProfileTrackerImpl_Factory(Provider<ScreenDiInjectTracker> provider, Provider<ScreenInitTracker> provider2, Provider<ScreenFlowTrackerProvider> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static UserProfileTrackerImpl_Factory create(Provider<ScreenDiInjectTracker> provider, Provider<ScreenInitTracker> provider2, Provider<ScreenFlowTrackerProvider> provider3) {
        return new UserProfileTrackerImpl_Factory(provider, provider2, provider3);
    }

    public static UserProfileTrackerImpl newInstance(ScreenDiInjectTracker screenDiInjectTracker, ScreenInitTracker screenInitTracker, ScreenFlowTrackerProvider screenFlowTrackerProvider) {
        return new UserProfileTrackerImpl(screenDiInjectTracker, screenInitTracker, screenFlowTrackerProvider);
    }

    @Override // javax.inject.Provider
    public UserProfileTrackerImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
