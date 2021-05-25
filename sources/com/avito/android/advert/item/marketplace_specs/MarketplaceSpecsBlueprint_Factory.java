package com.avito.android.advert.item.marketplace_specs;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class MarketplaceSpecsBlueprint_Factory implements Factory<MarketplaceSpecsBlueprint> {
    public final Provider<MarketplaceSpecsPresenter> a;

    public MarketplaceSpecsBlueprint_Factory(Provider<MarketplaceSpecsPresenter> provider) {
        this.a = provider;
    }

    public static MarketplaceSpecsBlueprint_Factory create(Provider<MarketplaceSpecsPresenter> provider) {
        return new MarketplaceSpecsBlueprint_Factory(provider);
    }

    public static MarketplaceSpecsBlueprint newInstance(MarketplaceSpecsPresenter marketplaceSpecsPresenter) {
        return new MarketplaceSpecsBlueprint(marketplaceSpecsPresenter);
    }

    @Override // javax.inject.Provider
    public MarketplaceSpecsBlueprint get() {
        return newInstance(this.a.get());
    }
}
