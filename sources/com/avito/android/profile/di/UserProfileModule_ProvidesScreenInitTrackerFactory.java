package com.avito.android.profile.di;

import com.avito.android.analytics.screens.TimerFactory;
import com.avito.android.analytics.screens.tracker.ScreenInitTracker;
import com.avito.android.analytics.screens.tracker.ScreenTrackerFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class UserProfileModule_ProvidesScreenInitTrackerFactory implements Factory<ScreenInitTracker> {
    public final UserProfileModule a;
    public final Provider<ScreenTrackerFactory> b;
    public final Provider<TimerFactory> c;

    public UserProfileModule_ProvidesScreenInitTrackerFactory(UserProfileModule userProfileModule, Provider<ScreenTrackerFactory> provider, Provider<TimerFactory> provider2) {
        this.a = userProfileModule;
        this.b = provider;
        this.c = provider2;
    }

    public static UserProfileModule_ProvidesScreenInitTrackerFactory create(UserProfileModule userProfileModule, Provider<ScreenTrackerFactory> provider, Provider<TimerFactory> provider2) {
        return new UserProfileModule_ProvidesScreenInitTrackerFactory(userProfileModule, provider, provider2);
    }

    public static ScreenInitTracker providesScreenInitTracker(UserProfileModule userProfileModule, ScreenTrackerFactory screenTrackerFactory, TimerFactory timerFactory) {
        return (ScreenInitTracker) Preconditions.checkNotNullFromProvides(userProfileModule.providesScreenInitTracker(screenTrackerFactory, timerFactory));
    }

    @Override // javax.inject.Provider
    public ScreenInitTracker get() {
        return providesScreenInitTracker(this.a, this.b.get(), this.c.get());
    }
}
