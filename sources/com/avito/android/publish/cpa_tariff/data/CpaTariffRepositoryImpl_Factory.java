package com.avito.android.publish.cpa_tariff.data;

import com.avito.android.remote.PublishApi;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class CpaTariffRepositoryImpl_Factory implements Factory<CpaTariffRepositoryImpl> {
    public final Provider<Integer> a;
    public final Provider<PublishApi> b;

    public CpaTariffRepositoryImpl_Factory(Provider<Integer> provider, Provider<PublishApi> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static CpaTariffRepositoryImpl_Factory create(Provider<Integer> provider, Provider<PublishApi> provider2) {
        return new CpaTariffRepositoryImpl_Factory(provider, provider2);
    }

    public static CpaTariffRepositoryImpl newInstance(int i, PublishApi publishApi) {
        return new CpaTariffRepositoryImpl(i, publishApi);
    }

    @Override // javax.inject.Provider
    public CpaTariffRepositoryImpl get() {
        return newInstance(this.a.get().intValue(), this.b.get());
    }
}
