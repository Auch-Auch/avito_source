package com.avito.android.certificate_pinning;

import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class UnsafeNetworkPresenterImpl_Factory implements Factory<UnsafeNetworkPresenterImpl> {
    public final Provider<UnsafeNetworkInteractor> a;
    public final Provider<SchedulersFactory> b;
    public final Provider<Kundle> c;

    public UnsafeNetworkPresenterImpl_Factory(Provider<UnsafeNetworkInteractor> provider, Provider<SchedulersFactory> provider2, Provider<Kundle> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static UnsafeNetworkPresenterImpl_Factory create(Provider<UnsafeNetworkInteractor> provider, Provider<SchedulersFactory> provider2, Provider<Kundle> provider3) {
        return new UnsafeNetworkPresenterImpl_Factory(provider, provider2, provider3);
    }

    public static UnsafeNetworkPresenterImpl newInstance(UnsafeNetworkInteractor unsafeNetworkInteractor, SchedulersFactory schedulersFactory, Kundle kundle) {
        return new UnsafeNetworkPresenterImpl(unsafeNetworkInteractor, schedulersFactory, kundle);
    }

    @Override // javax.inject.Provider
    public UnsafeNetworkPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
