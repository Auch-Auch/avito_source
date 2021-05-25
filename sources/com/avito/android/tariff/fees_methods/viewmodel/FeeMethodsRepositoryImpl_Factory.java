package com.avito.android.tariff.fees_methods.viewmodel;

import com.avito.android.Features;
import com.avito.android.remote.TariffApi;
import com.avito.android.tariff.fees_methods.limits_info.PaidPublishLimitsInfoRepository;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class FeeMethodsRepositoryImpl_Factory implements Factory<FeeMethodsRepositoryImpl> {
    public final Provider<TariffApi> a;
    public final Provider<SchedulersFactory3> b;
    public final Provider<Features> c;
    public final Provider<PaidPublishLimitsInfoRepository> d;

    public FeeMethodsRepositoryImpl_Factory(Provider<TariffApi> provider, Provider<SchedulersFactory3> provider2, Provider<Features> provider3, Provider<PaidPublishLimitsInfoRepository> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static FeeMethodsRepositoryImpl_Factory create(Provider<TariffApi> provider, Provider<SchedulersFactory3> provider2, Provider<Features> provider3, Provider<PaidPublishLimitsInfoRepository> provider4) {
        return new FeeMethodsRepositoryImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static FeeMethodsRepositoryImpl newInstance(TariffApi tariffApi, SchedulersFactory3 schedulersFactory3, Features features, PaidPublishLimitsInfoRepository paidPublishLimitsInfoRepository) {
        return new FeeMethodsRepositoryImpl(tariffApi, schedulersFactory3, features, paidPublishLimitsInfoRepository);
    }

    @Override // javax.inject.Provider
    public FeeMethodsRepositoryImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
