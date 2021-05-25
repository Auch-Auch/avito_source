package com.avito.android.advert.item.dfpcreditinfo;

import com.avito.android.advert_core.analytics.broker.SravniEventTracker;
import dagger.internal.Factory;
import javax.inject.Provider;
import ru.sravni.android.bankproduct.network.di.SravniNetworkConfiguration;
public final class AdvertDetailsCreditInfoPresenterImpl_Factory implements Factory<AdvertDetailsCreditInfoPresenterImpl> {
    public final Provider<CreditInfoResourcesProvider> a;
    public final Provider<SravniNetworkConfiguration> b;
    public final Provider<SravniEventTracker> c;

    public AdvertDetailsCreditInfoPresenterImpl_Factory(Provider<CreditInfoResourcesProvider> provider, Provider<SravniNetworkConfiguration> provider2, Provider<SravniEventTracker> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static AdvertDetailsCreditInfoPresenterImpl_Factory create(Provider<CreditInfoResourcesProvider> provider, Provider<SravniNetworkConfiguration> provider2, Provider<SravniEventTracker> provider3) {
        return new AdvertDetailsCreditInfoPresenterImpl_Factory(provider, provider2, provider3);
    }

    public static AdvertDetailsCreditInfoPresenterImpl newInstance(CreditInfoResourcesProvider creditInfoResourcesProvider, SravniNetworkConfiguration sravniNetworkConfiguration, SravniEventTracker sravniEventTracker) {
        return new AdvertDetailsCreditInfoPresenterImpl(creditInfoResourcesProvider, sravniNetworkConfiguration, sravniEventTracker);
    }

    @Override // javax.inject.Provider
    public AdvertDetailsCreditInfoPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
