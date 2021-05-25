package com.avito.android.item_visibility_tracker.filters;

import com.avito.android.serp.CommercialBannersAnalyticsInteractor;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class BannerViewFilter_Factory implements Factory<BannerViewFilter> {
    public final Provider<CommercialBannersAnalyticsInteractor> a;

    public BannerViewFilter_Factory(Provider<CommercialBannersAnalyticsInteractor> provider) {
        this.a = provider;
    }

    public static BannerViewFilter_Factory create(Provider<CommercialBannersAnalyticsInteractor> provider) {
        return new BannerViewFilter_Factory(provider);
    }

    public static BannerViewFilter newInstance(CommercialBannersAnalyticsInteractor commercialBannersAnalyticsInteractor) {
        return new BannerViewFilter(commercialBannersAnalyticsInteractor);
    }

    @Override // javax.inject.Provider
    public BannerViewFilter get() {
        return newInstance(this.a.get());
    }
}
