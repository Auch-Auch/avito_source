package com.avito.android.user_stats.tracker;

import com.avito.android.analytics.screens.tracker.ScreenDiInjectTracker;
import com.avito.android.analytics.screens.tracker.ScreenInitTracker;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class UserStatsTabTrackerImpl_Factory implements Factory<UserStatsTabTrackerImpl> {
    public final Provider<ScreenDiInjectTracker> a;
    public final Provider<ScreenInitTracker> b;

    public UserStatsTabTrackerImpl_Factory(Provider<ScreenDiInjectTracker> provider, Provider<ScreenInitTracker> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static UserStatsTabTrackerImpl_Factory create(Provider<ScreenDiInjectTracker> provider, Provider<ScreenInitTracker> provider2) {
        return new UserStatsTabTrackerImpl_Factory(provider, provider2);
    }

    public static UserStatsTabTrackerImpl newInstance(ScreenDiInjectTracker screenDiInjectTracker, ScreenInitTracker screenInitTracker) {
        return new UserStatsTabTrackerImpl(screenDiInjectTracker, screenInitTracker);
    }

    @Override // javax.inject.Provider
    public UserStatsTabTrackerImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
