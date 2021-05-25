package com.avito.android.publish.slots.market_price_v2.item;

import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.publish.PublishAnalyticsDataProvider;
import com.avito.android.util.text.AttributedTextFormatter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class MarketPriceV2PresenterImpl_Factory implements Factory<MarketPriceV2PresenterImpl> {
    public final Provider<MarketPriceV2Formatter> a;
    public final Provider<AttributedTextFormatter> b;
    public final Provider<PublishAnalyticsDataProvider> c;
    public final Provider<Analytics> d;

    public MarketPriceV2PresenterImpl_Factory(Provider<MarketPriceV2Formatter> provider, Provider<AttributedTextFormatter> provider2, Provider<PublishAnalyticsDataProvider> provider3, Provider<Analytics> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static MarketPriceV2PresenterImpl_Factory create(Provider<MarketPriceV2Formatter> provider, Provider<AttributedTextFormatter> provider2, Provider<PublishAnalyticsDataProvider> provider3, Provider<Analytics> provider4) {
        return new MarketPriceV2PresenterImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static MarketPriceV2PresenterImpl newInstance(MarketPriceV2Formatter marketPriceV2Formatter, AttributedTextFormatter attributedTextFormatter, PublishAnalyticsDataProvider publishAnalyticsDataProvider, Analytics analytics) {
        return new MarketPriceV2PresenterImpl(marketPriceV2Formatter, attributedTextFormatter, publishAnalyticsDataProvider, analytics);
    }

    @Override // javax.inject.Provider
    public MarketPriceV2PresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
