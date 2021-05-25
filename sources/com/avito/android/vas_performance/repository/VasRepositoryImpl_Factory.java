package com.avito.android.vas_performance.repository;

import com.avito.android.Features;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.vas.remote.VasApi;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class VasRepositoryImpl_Factory implements Factory<VasRepositoryImpl> {
    public final Provider<VasApi> a;
    public final Provider<SchedulersFactory> b;
    public final Provider<Features> c;

    public VasRepositoryImpl_Factory(Provider<VasApi> provider, Provider<SchedulersFactory> provider2, Provider<Features> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static VasRepositoryImpl_Factory create(Provider<VasApi> provider, Provider<SchedulersFactory> provider2, Provider<Features> provider3) {
        return new VasRepositoryImpl_Factory(provider, provider2, provider3);
    }

    public static VasRepositoryImpl newInstance(VasApi vasApi, SchedulersFactory schedulersFactory, Features features) {
        return new VasRepositoryImpl(vasApi, schedulersFactory, features);
    }

    @Override // javax.inject.Provider
    public VasRepositoryImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
