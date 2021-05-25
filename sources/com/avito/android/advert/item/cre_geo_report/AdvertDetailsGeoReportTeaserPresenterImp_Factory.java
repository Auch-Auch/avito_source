package com.avito.android.advert.item.cre_geo_report;

import com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertDetailsGeoReportTeaserPresenterImp_Factory implements Factory<AdvertDetailsGeoReportTeaserPresenterImp> {
    public final Provider<AdvertDetailsAnalyticsInteractor> a;

    public AdvertDetailsGeoReportTeaserPresenterImp_Factory(Provider<AdvertDetailsAnalyticsInteractor> provider) {
        this.a = provider;
    }

    public static AdvertDetailsGeoReportTeaserPresenterImp_Factory create(Provider<AdvertDetailsAnalyticsInteractor> provider) {
        return new AdvertDetailsGeoReportTeaserPresenterImp_Factory(provider);
    }

    public static AdvertDetailsGeoReportTeaserPresenterImp newInstance(AdvertDetailsAnalyticsInteractor advertDetailsAnalyticsInteractor) {
        return new AdvertDetailsGeoReportTeaserPresenterImp(advertDetailsAnalyticsInteractor);
    }

    @Override // javax.inject.Provider
    public AdvertDetailsGeoReportTeaserPresenterImp get() {
        return newInstance(this.a.get());
    }
}
