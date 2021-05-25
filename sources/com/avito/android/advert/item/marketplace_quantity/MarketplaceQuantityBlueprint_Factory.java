package com.avito.android.advert.item.marketplace_quantity;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class MarketplaceQuantityBlueprint_Factory implements Factory<MarketplaceQuantityBlueprint> {
    public final Provider<MarketplaceQuantityPresenter> a;

    public MarketplaceQuantityBlueprint_Factory(Provider<MarketplaceQuantityPresenter> provider) {
        this.a = provider;
    }

    public static MarketplaceQuantityBlueprint_Factory create(Provider<MarketplaceQuantityPresenter> provider) {
        return new MarketplaceQuantityBlueprint_Factory(provider);
    }

    public static MarketplaceQuantityBlueprint newInstance(MarketplaceQuantityPresenter marketplaceQuantityPresenter) {
        return new MarketplaceQuantityBlueprint(marketplaceQuantityPresenter);
    }

    @Override // javax.inject.Provider
    public MarketplaceQuantityBlueprint get() {
        return newInstance(this.a.get());
    }
}
