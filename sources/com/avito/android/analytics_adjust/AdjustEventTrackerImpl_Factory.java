package com.avito.android.analytics_adjust;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdjustEventTrackerImpl_Factory implements Factory<AdjustEventTrackerImpl> {
    public final Provider<Adjust> a;
    public final Provider<Criteo> b;

    public AdjustEventTrackerImpl_Factory(Provider<Adjust> provider, Provider<Criteo> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static AdjustEventTrackerImpl_Factory create(Provider<Adjust> provider, Provider<Criteo> provider2) {
        return new AdjustEventTrackerImpl_Factory(provider, provider2);
    }

    public static AdjustEventTrackerImpl newInstance(Adjust adjust, Criteo criteo) {
        return new AdjustEventTrackerImpl(adjust, criteo);
    }

    @Override // javax.inject.Provider
    public AdjustEventTrackerImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
