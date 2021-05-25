package com.avito.android.profile.di;

import com.avito.android.analytics.screens.ScreenFlowTrackerProvider;
import com.avito.android.analytics.screens.TimerFactory;
import com.avito.android.analytics.screens.tracker.ScreenTrackerFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class UserProfileModule_ProvidesScreenFlowTrackerProviderFactory implements Factory<ScreenFlowTrackerProvider> {
    public final UserProfileModule a;
    public final Provider<ScreenTrackerFactory> b;
    public final Provider<TimerFactory> c;

    public UserProfileModule_ProvidesScreenFlowTrackerProviderFactory(UserProfileModule userProfileModule, Provider<ScreenTrackerFactory> provider, Provider<TimerFactory> provider2) {
        this.a = userProfileModule;
        this.b = provider;
        this.c = provider2;
    }

    public static UserProfileModule_ProvidesScreenFlowTrackerProviderFactory create(UserProfileModule userProfileModule, Provider<ScreenTrackerFactory> provider, Provider<TimerFactory> provider2) {
        return new UserProfileModule_ProvidesScreenFlowTrackerProviderFactory(userProfileModule, provider, provider2);
    }

    public static ScreenFlowTrackerProvider providesScreenFlowTrackerProvider(UserProfileModule userProfileModule, ScreenTrackerFactory screenTrackerFactory, TimerFactory timerFactory) {
        return (ScreenFlowTrackerProvider) Preconditions.checkNotNullFromProvides(userProfileModule.providesScreenFlowTrackerProvider(screenTrackerFactory, timerFactory));
    }

    @Override // javax.inject.Provider
    public ScreenFlowTrackerProvider get() {
        return providesScreenFlowTrackerProvider(this.a, this.b.get(), this.c.get());
    }
}
