package com.avito.android.advert.item.maketplace_badge_bar;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class MarketplaceBadgeBarBlueprint_Factory implements Factory<MarketplaceBadgeBarBlueprint> {
    public final Provider<MarketplaceBadgeBarPresenter> a;

    public MarketplaceBadgeBarBlueprint_Factory(Provider<MarketplaceBadgeBarPresenter> provider) {
        this.a = provider;
    }

    public static MarketplaceBadgeBarBlueprint_Factory create(Provider<MarketplaceBadgeBarPresenter> provider) {
        return new MarketplaceBadgeBarBlueprint_Factory(provider);
    }

    public static MarketplaceBadgeBarBlueprint newInstance(MarketplaceBadgeBarPresenter marketplaceBadgeBarPresenter) {
        return new MarketplaceBadgeBarBlueprint(marketplaceBadgeBarPresenter);
    }

    @Override // javax.inject.Provider
    public MarketplaceBadgeBarBlueprint get() {
        return newInstance(this.a.get());
    }
}
