package com.avito.android.bundles.repository;

import com.avito.android.remote.VasBundlesApi;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class VasBundlesRepositoryImpl_Factory implements Factory<VasBundlesRepositoryImpl> {
    public final Provider<VasBundlesApi> a;
    public final Provider<SchedulersFactory3> b;

    public VasBundlesRepositoryImpl_Factory(Provider<VasBundlesApi> provider, Provider<SchedulersFactory3> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static VasBundlesRepositoryImpl_Factory create(Provider<VasBundlesApi> provider, Provider<SchedulersFactory3> provider2) {
        return new VasBundlesRepositoryImpl_Factory(provider, provider2);
    }

    public static VasBundlesRepositoryImpl newInstance(VasBundlesApi vasBundlesApi, SchedulersFactory3 schedulersFactory3) {
        return new VasBundlesRepositoryImpl(vasBundlesApi, schedulersFactory3);
    }

    @Override // javax.inject.Provider
    public VasBundlesRepositoryImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
