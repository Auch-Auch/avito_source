package com.avito.android.serp;

import com.avito.android.serp.ad.DfpBannerLoader;
import com.avito.android.serp.ad.MyTargetBannerLoader;
import com.avito.android.serp.ad.YandexBannerLoader;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class CommercialBannersInteractorImpl_Factory implements Factory<CommercialBannersInteractorImpl> {
    public final Provider<DfpBannerLoader> a;
    public final Provider<YandexBannerLoader> b;
    public final Provider<MyTargetBannerLoader> c;
    public final Provider<CommercialBannersAnalyticsInteractor> d;
    public final Provider<CommercialBannerTimeProvider> e;
    public final Provider<SchedulersFactory3> f;
    public final Provider<BannerInfoFactory> g;

    public CommercialBannersInteractorImpl_Factory(Provider<DfpBannerLoader> provider, Provider<YandexBannerLoader> provider2, Provider<MyTargetBannerLoader> provider3, Provider<CommercialBannersAnalyticsInteractor> provider4, Provider<CommercialBannerTimeProvider> provider5, Provider<SchedulersFactory3> provider6, Provider<BannerInfoFactory> provider7) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
    }

    public static CommercialBannersInteractorImpl_Factory create(Provider<DfpBannerLoader> provider, Provider<YandexBannerLoader> provider2, Provider<MyTargetBannerLoader> provider3, Provider<CommercialBannersAnalyticsInteractor> provider4, Provider<CommercialBannerTimeProvider> provider5, Provider<SchedulersFactory3> provider6, Provider<BannerInfoFactory> provider7) {
        return new CommercialBannersInteractorImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static CommercialBannersInteractorImpl newInstance(DfpBannerLoader dfpBannerLoader, YandexBannerLoader yandexBannerLoader, MyTargetBannerLoader myTargetBannerLoader, CommercialBannersAnalyticsInteractor commercialBannersAnalyticsInteractor, CommercialBannerTimeProvider commercialBannerTimeProvider, SchedulersFactory3 schedulersFactory3, BannerInfoFactory bannerInfoFactory) {
        return new CommercialBannersInteractorImpl(dfpBannerLoader, yandexBannerLoader, myTargetBannerLoader, commercialBannersAnalyticsInteractor, commercialBannerTimeProvider, schedulersFactory3, bannerInfoFactory);
    }

    @Override // javax.inject.Provider
    public CommercialBannersInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get());
    }
}
