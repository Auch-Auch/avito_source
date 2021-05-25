package com.avito.android.publish.slots.market_price.item;

import dagger.internal.Factory;
public final class MarketPriceItemPresenter_Factory implements Factory<MarketPriceItemPresenter> {

    public static final class a {
        public static final MarketPriceItemPresenter_Factory a = new MarketPriceItemPresenter_Factory();
    }

    public static MarketPriceItemPresenter_Factory create() {
        return a.a;
    }

    public static MarketPriceItemPresenter newInstance() {
        return new MarketPriceItemPresenter();
    }

    @Override // javax.inject.Provider
    public MarketPriceItemPresenter get() {
        return newInstance();
    }
}
