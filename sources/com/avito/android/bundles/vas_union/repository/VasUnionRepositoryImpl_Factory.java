package com.avito.android.bundles.vas_union.repository;

import com.avito.android.remote.VasUnionApi;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class VasUnionRepositoryImpl_Factory implements Factory<VasUnionRepositoryImpl> {
    public final Provider<VasUnionApi> a;
    public final Provider<SchedulersFactory3> b;

    public VasUnionRepositoryImpl_Factory(Provider<VasUnionApi> provider, Provider<SchedulersFactory3> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static VasUnionRepositoryImpl_Factory create(Provider<VasUnionApi> provider, Provider<SchedulersFactory3> provider2) {
        return new VasUnionRepositoryImpl_Factory(provider, provider2);
    }

    public static VasUnionRepositoryImpl newInstance(VasUnionApi vasUnionApi, SchedulersFactory3 schedulersFactory3) {
        return new VasUnionRepositoryImpl(vasUnionApi, schedulersFactory3);
    }

    @Override // javax.inject.Provider
    public VasUnionRepositoryImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
