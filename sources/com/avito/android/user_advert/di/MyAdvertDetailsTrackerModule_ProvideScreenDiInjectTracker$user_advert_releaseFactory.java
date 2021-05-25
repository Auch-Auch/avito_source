package com.avito.android.user_advert.di;

import com.avito.android.analytics.screens.TimerFactory;
import com.avito.android.analytics.screens.tracker.ScreenDiInjectTracker;
import com.avito.android.analytics.screens.tracker.ScreenTrackerFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class MyAdvertDetailsTrackerModule_ProvideScreenDiInjectTracker$user_advert_releaseFactory implements Factory<ScreenDiInjectTracker> {
    public final Provider<ScreenTrackerFactory> a;
    public final Provider<TimerFactory> b;

    public MyAdvertDetailsTrackerModule_ProvideScreenDiInjectTracker$user_advert_releaseFactory(Provider<ScreenTrackerFactory> provider, Provider<TimerFactory> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static MyAdvertDetailsTrackerModule_ProvideScreenDiInjectTracker$user_advert_releaseFactory create(Provider<ScreenTrackerFactory> provider, Provider<TimerFactory> provider2) {
        return new MyAdvertDetailsTrackerModule_ProvideScreenDiInjectTracker$user_advert_releaseFactory(provider, provider2);
    }

    public static ScreenDiInjectTracker provideScreenDiInjectTracker$user_advert_release(ScreenTrackerFactory screenTrackerFactory, TimerFactory timerFactory) {
        return (ScreenDiInjectTracker) Preconditions.checkNotNullFromProvides(MyAdvertDetailsTrackerModule.provideScreenDiInjectTracker$user_advert_release(screenTrackerFactory, timerFactory));
    }

    @Override // javax.inject.Provider
    public ScreenDiInjectTracker get() {
        return provideScreenDiInjectTracker$user_advert_release(this.a.get(), this.b.get());
    }
}
