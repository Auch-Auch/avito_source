package com.avito.android.advert.item.price;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertDetailsPriceBlueprint_Factory implements Factory<AdvertDetailsPriceBlueprint> {
    public final Provider<AdvertDetailsPricePresenter> a;

    public AdvertDetailsPriceBlueprint_Factory(Provider<AdvertDetailsPricePresenter> provider) {
        this.a = provider;
    }

    public static AdvertDetailsPriceBlueprint_Factory create(Provider<AdvertDetailsPricePresenter> provider) {
        return new AdvertDetailsPriceBlueprint_Factory(provider);
    }

    public static AdvertDetailsPriceBlueprint newInstance(AdvertDetailsPricePresenter advertDetailsPricePresenter) {
        return new AdvertDetailsPriceBlueprint(advertDetailsPricePresenter);
    }

    @Override // javax.inject.Provider
    public AdvertDetailsPriceBlueprint get() {
        return newInstance(this.a.get());
    }
}
