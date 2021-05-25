package com.avito.android.analytics_adjust;

import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdjustEventObserver_Factory implements Factory<AdjustEventObserver> {
    public final Provider<AdjustEventTracker> a;
    public final Provider<SchedulersFactory> b;

    public AdjustEventObserver_Factory(Provider<AdjustEventTracker> provider, Provider<SchedulersFactory> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static AdjustEventObserver_Factory create(Provider<AdjustEventTracker> provider, Provider<SchedulersFactory> provider2) {
        return new AdjustEventObserver_Factory(provider, provider2);
    }

    public static AdjustEventObserver newInstance(AdjustEventTracker adjustEventTracker, SchedulersFactory schedulersFactory) {
        return new AdjustEventObserver(adjustEventTracker, schedulersFactory);
    }

    @Override // javax.inject.Provider
    public AdjustEventObserver get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
