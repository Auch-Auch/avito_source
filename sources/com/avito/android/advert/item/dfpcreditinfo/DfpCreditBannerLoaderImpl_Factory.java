package com.avito.android.advert.item.dfpcreditinfo;

import android.content.Context;
import com.avito.android.Features;
import com.avito.android.ab_tests.configs.TinkoffCreditCalculatorTestGroup;
import com.avito.android.ab_tests.models.SingleManuallyExposedAbTestGroup;
import com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor;
import com.avito.android.advert_core.analytics.broker.CreditBrokerSessionProvider;
import com.avito.android.advert_details.remote.AdvertDetailsApi;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class DfpCreditBannerLoaderImpl_Factory implements Factory<DfpCreditBannerLoaderImpl> {
    public final Provider<Context> a;
    public final Provider<SchedulersFactory3> b;
    public final Provider<AdvertDetailsApi> c;
    public final Provider<AdvertDetailsAnalyticsInteractor> d;
    public final Provider<CreditInfoResourcesProvider> e;
    public final Provider<CreditBrokerSessionProvider> f;
    public final Provider<BuildInfo> g;
    public final Provider<SingleManuallyExposedAbTestGroup<TinkoffCreditCalculatorTestGroup>> h;
    public final Provider<Features> i;

    public DfpCreditBannerLoaderImpl_Factory(Provider<Context> provider, Provider<SchedulersFactory3> provider2, Provider<AdvertDetailsApi> provider3, Provider<AdvertDetailsAnalyticsInteractor> provider4, Provider<CreditInfoResourcesProvider> provider5, Provider<CreditBrokerSessionProvider> provider6, Provider<BuildInfo> provider7, Provider<SingleManuallyExposedAbTestGroup<TinkoffCreditCalculatorTestGroup>> provider8, Provider<Features> provider9) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
        this.h = provider8;
        this.i = provider9;
    }

    public static DfpCreditBannerLoaderImpl_Factory create(Provider<Context> provider, Provider<SchedulersFactory3> provider2, Provider<AdvertDetailsApi> provider3, Provider<AdvertDetailsAnalyticsInteractor> provider4, Provider<CreditInfoResourcesProvider> provider5, Provider<CreditBrokerSessionProvider> provider6, Provider<BuildInfo> provider7, Provider<SingleManuallyExposedAbTestGroup<TinkoffCreditCalculatorTestGroup>> provider8, Provider<Features> provider9) {
        return new DfpCreditBannerLoaderImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9);
    }

    public static DfpCreditBannerLoaderImpl newInstance(Context context, SchedulersFactory3 schedulersFactory3, AdvertDetailsApi advertDetailsApi, AdvertDetailsAnalyticsInteractor advertDetailsAnalyticsInteractor, CreditInfoResourcesProvider creditInfoResourcesProvider, CreditBrokerSessionProvider creditBrokerSessionProvider, BuildInfo buildInfo, SingleManuallyExposedAbTestGroup<TinkoffCreditCalculatorTestGroup> singleManuallyExposedAbTestGroup, Features features) {
        return new DfpCreditBannerLoaderImpl(context, schedulersFactory3, advertDetailsApi, advertDetailsAnalyticsInteractor, creditInfoResourcesProvider, creditBrokerSessionProvider, buildInfo, singleManuallyExposedAbTestGroup, features);
    }

    @Override // javax.inject.Provider
    public DfpCreditBannerLoaderImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get(), this.i.get());
    }
}
