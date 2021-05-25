package com.avito.android.advert.item.cre_geo_report;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertDetailsGeoReportTeaserBlueprint_Factory implements Factory<AdvertDetailsGeoReportTeaserBlueprint> {
    public final Provider<AdvertDetailsGeoReportTeaserPresenter> a;

    public AdvertDetailsGeoReportTeaserBlueprint_Factory(Provider<AdvertDetailsGeoReportTeaserPresenter> provider) {
        this.a = provider;
    }

    public static AdvertDetailsGeoReportTeaserBlueprint_Factory create(Provider<AdvertDetailsGeoReportTeaserPresenter> provider) {
        return new AdvertDetailsGeoReportTeaserBlueprint_Factory(provider);
    }

    public static AdvertDetailsGeoReportTeaserBlueprint newInstance(AdvertDetailsGeoReportTeaserPresenter advertDetailsGeoReportTeaserPresenter) {
        return new AdvertDetailsGeoReportTeaserBlueprint(advertDetailsGeoReportTeaserPresenter);
    }

    @Override // javax.inject.Provider
    public AdvertDetailsGeoReportTeaserBlueprint get() {
        return newInstance(this.a.get());
    }
}
