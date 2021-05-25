package com.avito.android.async_phone;

import com.avito.android.analytics.screens.Screen;
import com.avito.android.analytics.screens.TimerFactory;
import com.avito.android.analytics.screens.tracker.ScreenTrackerFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AsyncPhoneTrackerImpl_Factory implements Factory<AsyncPhoneTrackerImpl> {
    public final Provider<ScreenTrackerFactory> a;
    public final Provider<TimerFactory> b;
    public final Provider<Screen> c;

    public AsyncPhoneTrackerImpl_Factory(Provider<ScreenTrackerFactory> provider, Provider<TimerFactory> provider2, Provider<Screen> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static AsyncPhoneTrackerImpl_Factory create(Provider<ScreenTrackerFactory> provider, Provider<TimerFactory> provider2, Provider<Screen> provider3) {
        return new AsyncPhoneTrackerImpl_Factory(provider, provider2, provider3);
    }

    public static AsyncPhoneTrackerImpl newInstance(ScreenTrackerFactory screenTrackerFactory, TimerFactory timerFactory, Screen screen) {
        return new AsyncPhoneTrackerImpl(screenTrackerFactory, timerFactory, screen);
    }

    @Override // javax.inject.Provider
    public AsyncPhoneTrackerImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
