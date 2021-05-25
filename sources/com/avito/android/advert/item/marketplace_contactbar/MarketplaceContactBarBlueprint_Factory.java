package com.avito.android.advert.item.marketplace_contactbar;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class MarketplaceContactBarBlueprint_Factory implements Factory<MarketplaceContactBarBlueprint> {
    public final Provider<MarketplaceContactBarPresenter> a;

    public MarketplaceContactBarBlueprint_Factory(Provider<MarketplaceContactBarPresenter> provider) {
        this.a = provider;
    }

    public static MarketplaceContactBarBlueprint_Factory create(Provider<MarketplaceContactBarPresenter> provider) {
        return new MarketplaceContactBarBlueprint_Factory(provider);
    }

    public static MarketplaceContactBarBlueprint newInstance(MarketplaceContactBarPresenter marketplaceContactBarPresenter) {
        return new MarketplaceContactBarBlueprint(marketplaceContactBarPresenter);
    }

    @Override // javax.inject.Provider
    public MarketplaceContactBarBlueprint get() {
        return newInstance(this.a.get());
    }
}
