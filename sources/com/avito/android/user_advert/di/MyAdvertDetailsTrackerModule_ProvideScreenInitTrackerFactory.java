package com.avito.android.user_advert.di;

import com.avito.android.analytics.screens.TimerFactory;
import com.avito.android.analytics.screens.tracker.ScreenInitTracker;
import com.avito.android.analytics.screens.tracker.ScreenTrackerFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class MyAdvertDetailsTrackerModule_ProvideScreenInitTrackerFactory implements Factory<ScreenInitTracker> {
    public final Provider<ScreenTrackerFactory> a;
    public final Provider<TimerFactory> b;

    public MyAdvertDetailsTrackerModule_ProvideScreenInitTrackerFactory(Provider<ScreenTrackerFactory> provider, Provider<TimerFactory> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static MyAdvertDetailsTrackerModule_ProvideScreenInitTrackerFactory create(Provider<ScreenTrackerFactory> provider, Provider<TimerFactory> provider2) {
        return new MyAdvertDetailsTrackerModule_ProvideScreenInitTrackerFactory(provider, provider2);
    }

    public static ScreenInitTracker provideScreenInitTracker(ScreenTrackerFactory screenTrackerFactory, TimerFactory timerFactory) {
        return (ScreenInitTracker) Preconditions.checkNotNullFromProvides(MyAdvertDetailsTrackerModule.provideScreenInitTracker(screenTrackerFactory, timerFactory));
    }

    @Override // javax.inject.Provider
    public ScreenInitTracker get() {
        return provideScreenInitTracker(this.a.get(), this.b.get());
    }
}
