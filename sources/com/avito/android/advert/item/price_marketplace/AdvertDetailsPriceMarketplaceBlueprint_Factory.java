package com.avito.android.advert.item.price_marketplace;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertDetailsPriceMarketplaceBlueprint_Factory implements Factory<AdvertDetailsPriceMarketplaceBlueprint> {
    public final Provider<AdvertDetailsPriceMarketplacePresenter> a;

    public AdvertDetailsPriceMarketplaceBlueprint_Factory(Provider<AdvertDetailsPriceMarketplacePresenter> provider) {
        this.a = provider;
    }

    public static AdvertDetailsPriceMarketplaceBlueprint_Factory create(Provider<AdvertDetailsPriceMarketplacePresenter> provider) {
        return new AdvertDetailsPriceMarketplaceBlueprint_Factory(provider);
    }

    public static AdvertDetailsPriceMarketplaceBlueprint newInstance(AdvertDetailsPriceMarketplacePresenter advertDetailsPriceMarketplacePresenter) {
        return new AdvertDetailsPriceMarketplaceBlueprint(advertDetailsPriceMarketplacePresenter);
    }

    @Override // javax.inject.Provider
    public AdvertDetailsPriceMarketplaceBlueprint get() {
        return newInstance(this.a.get());
    }
}
