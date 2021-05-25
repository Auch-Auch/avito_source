package com.avito.android.in_app_calls.service;

import android.app.Service;
import com.avito.android.Features;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class RingtoneDelegateImpl_Factory implements Factory<RingtoneDelegateImpl> {
    public final Provider<Service> a;
    public final Provider<Features> b;

    public RingtoneDelegateImpl_Factory(Provider<Service> provider, Provider<Features> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static RingtoneDelegateImpl_Factory create(Provider<Service> provider, Provider<Features> provider2) {
        return new RingtoneDelegateImpl_Factory(provider, provider2);
    }

    public static RingtoneDelegateImpl newInstance(Service service, Features features) {
        return new RingtoneDelegateImpl(service, features);
    }

    @Override // javax.inject.Provider
    public RingtoneDelegateImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
