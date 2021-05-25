package com.avito.android.advert.item.price_subscription;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertDetailsPriceSubscriptionBlueprint_Factory implements Factory<AdvertDetailsPriceSubscriptionBlueprint> {
    public final Provider<AdvertDetailsPriceSubscriptionPresenter> a;

    public AdvertDetailsPriceSubscriptionBlueprint_Factory(Provider<AdvertDetailsPriceSubscriptionPresenter> provider) {
        this.a = provider;
    }

    public static AdvertDetailsPriceSubscriptionBlueprint_Factory create(Provider<AdvertDetailsPriceSubscriptionPresenter> provider) {
        return new AdvertDetailsPriceSubscriptionBlueprint_Factory(provider);
    }

    public static AdvertDetailsPriceSubscriptionBlueprint newInstance(AdvertDetailsPriceSubscriptionPresenter advertDetailsPriceSubscriptionPresenter) {
        return new AdvertDetailsPriceSubscriptionBlueprint(advertDetailsPriceSubscriptionPresenter);
    }

    @Override // javax.inject.Provider
    public AdvertDetailsPriceSubscriptionBlueprint get() {
        return newInstance(this.a.get());
    }
}
