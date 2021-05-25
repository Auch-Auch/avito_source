package com.avito.android.brandspace.items.marketplace.tab;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class MarketplaceTabBlueprint_Factory implements Factory<MarketplaceTabBlueprint> {
    public final Provider<MarketplaceTabPresenter> a;

    public MarketplaceTabBlueprint_Factory(Provider<MarketplaceTabPresenter> provider) {
        this.a = provider;
    }

    public static MarketplaceTabBlueprint_Factory create(Provider<MarketplaceTabPresenter> provider) {
        return new MarketplaceTabBlueprint_Factory(provider);
    }

    public static MarketplaceTabBlueprint newInstance(MarketplaceTabPresenter marketplaceTabPresenter) {
        return new MarketplaceTabBlueprint(marketplaceTabPresenter);
    }

    @Override // javax.inject.Provider
    public MarketplaceTabBlueprint get() {
        return newInstance(this.a.get());
    }
}
