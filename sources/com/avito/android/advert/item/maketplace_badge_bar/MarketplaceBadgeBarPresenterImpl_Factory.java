package com.avito.android.advert.item.maketplace_badge_bar;

import dagger.internal.Factory;
public final class MarketplaceBadgeBarPresenterImpl_Factory implements Factory<MarketplaceBadgeBarPresenterImpl> {

    public static final class a {
        public static final MarketplaceBadgeBarPresenterImpl_Factory a = new MarketplaceBadgeBarPresenterImpl_Factory();
    }

    public static MarketplaceBadgeBarPresenterImpl_Factory create() {
        return a.a;
    }

    public static MarketplaceBadgeBarPresenterImpl newInstance() {
        return new MarketplaceBadgeBarPresenterImpl();
    }

    @Override // javax.inject.Provider
    public MarketplaceBadgeBarPresenterImpl get() {
        return newInstance();
    }
}
