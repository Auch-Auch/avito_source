package com.avito.android.advert.item.safedeal.services;

import com.avito.android.deep_linking.DeepLinkFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertDetailsSafeDealServicesBlueprint_Factory implements Factory<AdvertDetailsSafeDealServicesBlueprint> {
    public final Provider<AdvertDetailsSafeDealServicesPresenter> a;
    public final Provider<DeepLinkFactory> b;

    public AdvertDetailsSafeDealServicesBlueprint_Factory(Provider<AdvertDetailsSafeDealServicesPresenter> provider, Provider<DeepLinkFactory> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static AdvertDetailsSafeDealServicesBlueprint_Factory create(Provider<AdvertDetailsSafeDealServicesPresenter> provider, Provider<DeepLinkFactory> provider2) {
        return new AdvertDetailsSafeDealServicesBlueprint_Factory(provider, provider2);
    }

    public static AdvertDetailsSafeDealServicesBlueprint newInstance(AdvertDetailsSafeDealServicesPresenter advertDetailsSafeDealServicesPresenter, DeepLinkFactory deepLinkFactory) {
        return new AdvertDetailsSafeDealServicesBlueprint(advertDetailsSafeDealServicesPresenter, deepLinkFactory);
    }

    @Override // javax.inject.Provider
    public AdvertDetailsSafeDealServicesBlueprint get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
