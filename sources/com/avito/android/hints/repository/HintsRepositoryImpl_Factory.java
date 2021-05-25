package com.avito.android.hints.repository;

import com.avito.android.hints.remote.HintsApi;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class HintsRepositoryImpl_Factory implements Factory<HintsRepositoryImpl> {
    public final Provider<HintsApi> a;
    public final Provider<SchedulersFactory> b;

    public HintsRepositoryImpl_Factory(Provider<HintsApi> provider, Provider<SchedulersFactory> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static HintsRepositoryImpl_Factory create(Provider<HintsApi> provider, Provider<SchedulersFactory> provider2) {
        return new HintsRepositoryImpl_Factory(provider, provider2);
    }

    public static HintsRepositoryImpl newInstance(HintsApi hintsApi, SchedulersFactory schedulersFactory) {
        return new HintsRepositoryImpl(hintsApi, schedulersFactory);
    }

    @Override // javax.inject.Provider
    public HintsRepositoryImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
