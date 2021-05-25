package com.avito.android.advert.item.dfpcreditinfo;

import com.avito.android.advert_core.analytics.broker.CreditBrokerAnalyticsInteractor;
import com.avito.android.brandspace_entry_point.BrandspaceEntryPointAnalyticsInteractor;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class CreditBannerFilter_Factory implements Factory<CreditBannerFilter> {
    public final Provider<CreditBrokerAnalyticsInteractor> a;
    public final Provider<BrandspaceEntryPointAnalyticsInteractor> b;

    public CreditBannerFilter_Factory(Provider<CreditBrokerAnalyticsInteractor> provider, Provider<BrandspaceEntryPointAnalyticsInteractor> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static CreditBannerFilter_Factory create(Provider<CreditBrokerAnalyticsInteractor> provider, Provider<BrandspaceEntryPointAnalyticsInteractor> provider2) {
        return new CreditBannerFilter_Factory(provider, provider2);
    }

    public static CreditBannerFilter newInstance(CreditBrokerAnalyticsInteractor creditBrokerAnalyticsInteractor, BrandspaceEntryPointAnalyticsInteractor brandspaceEntryPointAnalyticsInteractor) {
        return new CreditBannerFilter(creditBrokerAnalyticsInteractor, brandspaceEntryPointAnalyticsInteractor);
    }

    @Override // javax.inject.Provider
    public CreditBannerFilter get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
