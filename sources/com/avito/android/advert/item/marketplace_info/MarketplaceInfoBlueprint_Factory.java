package com.avito.android.advert.item.marketplace_info;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class MarketplaceInfoBlueprint_Factory implements Factory<MarketplaceInfoBlueprint> {
    public final Provider<MarketplaceInfoPresenter> a;

    public MarketplaceInfoBlueprint_Factory(Provider<MarketplaceInfoPresenter> provider) {
        this.a = provider;
    }

    public static MarketplaceInfoBlueprint_Factory create(Provider<MarketplaceInfoPresenter> provider) {
        return new MarketplaceInfoBlueprint_Factory(provider);
    }

    public static MarketplaceInfoBlueprint newInstance(MarketplaceInfoPresenter marketplaceInfoPresenter) {
        return new MarketplaceInfoBlueprint(marketplaceInfoPresenter);
    }

    @Override // javax.inject.Provider
    public MarketplaceInfoBlueprint get() {
        return newInstance(this.a.get());
    }
}
