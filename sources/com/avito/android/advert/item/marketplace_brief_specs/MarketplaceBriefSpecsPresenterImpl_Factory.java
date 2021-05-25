package com.avito.android.advert.item.marketplace_brief_specs;

import com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class MarketplaceBriefSpecsPresenterImpl_Factory implements Factory<MarketplaceBriefSpecsPresenterImpl> {
    public final Provider<String> a;
    public final Provider<AdvertDetailsAnalyticsInteractor> b;

    public MarketplaceBriefSpecsPresenterImpl_Factory(Provider<String> provider, Provider<AdvertDetailsAnalyticsInteractor> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static MarketplaceBriefSpecsPresenterImpl_Factory create(Provider<String> provider, Provider<AdvertDetailsAnalyticsInteractor> provider2) {
        return new MarketplaceBriefSpecsPresenterImpl_Factory(provider, provider2);
    }

    public static MarketplaceBriefSpecsPresenterImpl newInstance(String str, AdvertDetailsAnalyticsInteractor advertDetailsAnalyticsInteractor) {
        return new MarketplaceBriefSpecsPresenterImpl(str, advertDetailsAnalyticsInteractor);
    }

    @Override // javax.inject.Provider
    public MarketplaceBriefSpecsPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
