package com.avito.android.publish.slots.market_price_v2.item;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class MarketPriceV2Blueprint_Factory implements Factory<MarketPriceV2Blueprint> {
    public final Provider<MarketPriceV2Presenter> a;

    public MarketPriceV2Blueprint_Factory(Provider<MarketPriceV2Presenter> provider) {
        this.a = provider;
    }

    public static MarketPriceV2Blueprint_Factory create(Provider<MarketPriceV2Presenter> provider) {
        return new MarketPriceV2Blueprint_Factory(provider);
    }

    public static MarketPriceV2Blueprint newInstance(MarketPriceV2Presenter marketPriceV2Presenter) {
        return new MarketPriceV2Blueprint(marketPriceV2Presenter);
    }

    @Override // javax.inject.Provider
    public MarketPriceV2Blueprint get() {
        return newInstance(this.a.get());
    }
}
