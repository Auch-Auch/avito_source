package com.avito.android.publish.slots.market_price.item;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class MarketPriceOldBlueprint_Factory implements Factory<MarketPriceOldBlueprint> {
    public final Provider<MarketPriceItemPresenter> a;

    public MarketPriceOldBlueprint_Factory(Provider<MarketPriceItemPresenter> provider) {
        this.a = provider;
    }

    public static MarketPriceOldBlueprint_Factory create(Provider<MarketPriceItemPresenter> provider) {
        return new MarketPriceOldBlueprint_Factory(provider);
    }

    public static MarketPriceOldBlueprint newInstance(MarketPriceItemPresenter marketPriceItemPresenter) {
        return new MarketPriceOldBlueprint(marketPriceItemPresenter);
    }

    @Override // javax.inject.Provider
    public MarketPriceOldBlueprint get() {
        return newInstance(this.a.get());
    }
}
