package com.avito.android.analytics.screens.tracker;

import com.avito.android.analytics.screens.TimerFactory;
import com.avito.android.analytics.screens.tracker.UnknownScreenTracker;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class UnknownScreenTracker_Impl_Factory implements Factory<UnknownScreenTracker.Impl> {
    public final Provider<TimerFactory> a;

    public UnknownScreenTracker_Impl_Factory(Provider<TimerFactory> provider) {
        this.a = provider;
    }

    public static UnknownScreenTracker_Impl_Factory create(Provider<TimerFactory> provider) {
        return new UnknownScreenTracker_Impl_Factory(provider);
    }

    public static UnknownScreenTracker.Impl newInstance(TimerFactory timerFactory) {
        return new UnknownScreenTracker.Impl(timerFactory);
    }

    @Override // javax.inject.Provider
    public UnknownScreenTracker.Impl get() {
        return newInstance(this.a.get());
    }
}
