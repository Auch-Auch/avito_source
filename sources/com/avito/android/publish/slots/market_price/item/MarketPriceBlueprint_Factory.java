package com.avito.android.publish.slots.market_price.item;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class MarketPriceBlueprint_Factory implements Factory<MarketPriceBlueprint> {
    public final Provider<MarketPriceItemPresenter> a;

    public MarketPriceBlueprint_Factory(Provider<MarketPriceItemPresenter> provider) {
        this.a = provider;
    }

    public static MarketPriceBlueprint_Factory create(Provider<MarketPriceItemPresenter> provider) {
        return new MarketPriceBlueprint_Factory(provider);
    }

    public static MarketPriceBlueprint newInstance(MarketPriceItemPresenter marketPriceItemPresenter) {
        return new MarketPriceBlueprint(marketPriceItemPresenter);
    }

    @Override // javax.inject.Provider
    public MarketPriceBlueprint get() {
        return newInstance(this.a.get());
    }
}
