package com.avito.android.analytics.screens;

import com.avito.android.analytics.screens.ScreenTransferRecovery;
import com.avito.android.analytics.screens.tracker.ScreenTrackerFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ScreenTransferRecovery_Impl_Factory implements Factory<ScreenTransferRecovery.Impl> {
    public final Provider<ScreenTrackerFactory> a;
    public final Provider<TimerFactory> b;

    public ScreenTransferRecovery_Impl_Factory(Provider<ScreenTrackerFactory> provider, Provider<TimerFactory> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static ScreenTransferRecovery_Impl_Factory create(Provider<ScreenTrackerFactory> provider, Provider<TimerFactory> provider2) {
        return new ScreenTransferRecovery_Impl_Factory(provider, provider2);
    }

    public static ScreenTransferRecovery.Impl newInstance(ScreenTrackerFactory screenTrackerFactory, TimerFactory timerFactory) {
        return new ScreenTransferRecovery.Impl(screenTrackerFactory, timerFactory);
    }

    @Override // javax.inject.Provider
    public ScreenTransferRecovery.Impl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
