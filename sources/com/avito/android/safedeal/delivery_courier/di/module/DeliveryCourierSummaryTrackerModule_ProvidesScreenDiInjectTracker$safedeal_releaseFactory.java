package com.avito.android.safedeal.delivery_courier.di.module;

import com.avito.android.analytics.screens.TimerFactory;
import com.avito.android.analytics.screens.tracker.ScreenDiInjectTracker;
import com.avito.android.analytics.screens.tracker.ScreenTrackerFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class DeliveryCourierSummaryTrackerModule_ProvidesScreenDiInjectTracker$safedeal_releaseFactory implements Factory<ScreenDiInjectTracker> {
    public final Provider<ScreenTrackerFactory> a;
    public final Provider<TimerFactory> b;
    public final Provider<String> c;

    public DeliveryCourierSummaryTrackerModule_ProvidesScreenDiInjectTracker$safedeal_releaseFactory(Provider<ScreenTrackerFactory> provider, Provider<TimerFactory> provider2, Provider<String> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static DeliveryCourierSummaryTrackerModule_ProvidesScreenDiInjectTracker$safedeal_releaseFactory create(Provider<ScreenTrackerFactory> provider, Provider<TimerFactory> provider2, Provider<String> provider3) {
        return new DeliveryCourierSummaryTrackerModule_ProvidesScreenDiInjectTracker$safedeal_releaseFactory(provider, provider2, provider3);
    }

    public static ScreenDiInjectTracker providesScreenDiInjectTracker$safedeal_release(ScreenTrackerFactory screenTrackerFactory, TimerFactory timerFactory, String str) {
        return (ScreenDiInjectTracker) Preconditions.checkNotNullFromProvides(DeliveryCourierSummaryTrackerModule.INSTANCE.providesScreenDiInjectTracker$safedeal_release(screenTrackerFactory, timerFactory, str));
    }

    @Override // javax.inject.Provider
    public ScreenDiInjectTracker get() {
        return providesScreenDiInjectTracker$safedeal_release(this.a.get(), this.b.get(), this.c.get());
    }
}
