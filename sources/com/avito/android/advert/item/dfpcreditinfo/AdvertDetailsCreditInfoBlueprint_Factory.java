package com.avito.android.advert.item.dfpcreditinfo;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertDetailsCreditInfoBlueprint_Factory implements Factory<AdvertDetailsCreditInfoBlueprint> {
    public final Provider<AdvertDetailsCreditInfoPresenter> a;
    public final Provider<CreditInfoResourcesProvider> b;

    public AdvertDetailsCreditInfoBlueprint_Factory(Provider<AdvertDetailsCreditInfoPresenter> provider, Provider<CreditInfoResourcesProvider> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static AdvertDetailsCreditInfoBlueprint_Factory create(Provider<AdvertDetailsCreditInfoPresenter> provider, Provider<CreditInfoResourcesProvider> provider2) {
        return new AdvertDetailsCreditInfoBlueprint_Factory(provider, provider2);
    }

    public static AdvertDetailsCreditInfoBlueprint newInstance(AdvertDetailsCreditInfoPresenter advertDetailsCreditInfoPresenter, CreditInfoResourcesProvider creditInfoResourcesProvider) {
        return new AdvertDetailsCreditInfoBlueprint(advertDetailsCreditInfoPresenter, creditInfoResourcesProvider);
    }

    @Override // javax.inject.Provider
    public AdvertDetailsCreditInfoBlueprint get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
