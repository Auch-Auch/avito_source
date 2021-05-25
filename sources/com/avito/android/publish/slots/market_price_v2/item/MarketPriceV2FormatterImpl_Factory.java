package com.avito.android.publish.slots.market_price_v2.item;

import dagger.internal.Factory;
public final class MarketPriceV2FormatterImpl_Factory implements Factory<MarketPriceV2FormatterImpl> {

    public static final class a {
        public static final MarketPriceV2FormatterImpl_Factory a = new MarketPriceV2FormatterImpl_Factory();
    }

    public static MarketPriceV2FormatterImpl_Factory create() {
        return a.a;
    }

    public static MarketPriceV2FormatterImpl newInstance() {
        return new MarketPriceV2FormatterImpl();
    }

    @Override // javax.inject.Provider
    public MarketPriceV2FormatterImpl get() {
        return newInstance();
    }
}
