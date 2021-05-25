package com.avito.android.serp;

import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.provider.TreeStateIdGenerator;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.serp.analytics.BannerPageSource;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class CommercialBannersAnalyticsInteractorImpl_Factory implements Factory<CommercialBannersAnalyticsInteractorImpl> {
    public final Provider<BannerPageSource> a;
    public final Provider<Analytics> b;
    public final Provider<TreeClickStreamParent> c;
    public final Provider<TreeStateIdGenerator> d;
    public final Provider<CommercialBannerTimeProvider> e;

    public CommercialBannersAnalyticsInteractorImpl_Factory(Provider<BannerPageSource> provider, Provider<Analytics> provider2, Provider<TreeClickStreamParent> provider3, Provider<TreeStateIdGenerator> provider4, Provider<CommercialBannerTimeProvider> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static CommercialBannersAnalyticsInteractorImpl_Factory create(Provider<BannerPageSource> provider, Provider<Analytics> provider2, Provider<TreeClickStreamParent> provider3, Provider<TreeStateIdGenerator> provider4, Provider<CommercialBannerTimeProvider> provider5) {
        return new CommercialBannersAnalyticsInteractorImpl_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static CommercialBannersAnalyticsInteractorImpl newInstance(BannerPageSource bannerPageSource, Analytics analytics, Provider<TreeClickStreamParent> provider, TreeStateIdGenerator treeStateIdGenerator, CommercialBannerTimeProvider commercialBannerTimeProvider) {
        return new CommercialBannersAnalyticsInteractorImpl(bannerPageSource, analytics, provider, treeStateIdGenerator, commercialBannerTimeProvider);
    }

    @Override // javax.inject.Provider
    public CommercialBannersAnalyticsInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c, this.d.get(), this.e.get());
    }
}
