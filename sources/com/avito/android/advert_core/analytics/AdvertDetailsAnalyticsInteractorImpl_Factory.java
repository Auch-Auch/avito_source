package com.avito.android.advert_core.analytics;

import com.avito.android.Features;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.advert_core.analytics.broker.CreditBrokerAnalyticsInteractor;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.provider.TreeStateIdGenerator;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.serp.CommercialBannersAnalyticsInteractor;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertDetailsAnalyticsInteractorImpl_Factory implements Factory<AdvertDetailsAnalyticsInteractorImpl> {
    public final Provider<Analytics> a;
    public final Provider<CommercialBannersAnalyticsInteractor> b;
    public final Provider<CreditBrokerAnalyticsInteractor> c;
    public final Provider<AccountStateProvider> d;
    public final Provider<TreeStateIdGenerator> e;
    public final Provider<TreeClickStreamParent> f;
    public final Provider<Features> g;

    public AdvertDetailsAnalyticsInteractorImpl_Factory(Provider<Analytics> provider, Provider<CommercialBannersAnalyticsInteractor> provider2, Provider<CreditBrokerAnalyticsInteractor> provider3, Provider<AccountStateProvider> provider4, Provider<TreeStateIdGenerator> provider5, Provider<TreeClickStreamParent> provider6, Provider<Features> provider7) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
    }

    public static AdvertDetailsAnalyticsInteractorImpl_Factory create(Provider<Analytics> provider, Provider<CommercialBannersAnalyticsInteractor> provider2, Provider<CreditBrokerAnalyticsInteractor> provider3, Provider<AccountStateProvider> provider4, Provider<TreeStateIdGenerator> provider5, Provider<TreeClickStreamParent> provider6, Provider<Features> provider7) {
        return new AdvertDetailsAnalyticsInteractorImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static AdvertDetailsAnalyticsInteractorImpl newInstance(Analytics analytics, CommercialBannersAnalyticsInteractor commercialBannersAnalyticsInteractor, CreditBrokerAnalyticsInteractor creditBrokerAnalyticsInteractor, AccountStateProvider accountStateProvider, TreeStateIdGenerator treeStateIdGenerator, TreeClickStreamParent treeClickStreamParent, Features features) {
        return new AdvertDetailsAnalyticsInteractorImpl(analytics, commercialBannersAnalyticsInteractor, creditBrokerAnalyticsInteractor, accountStateProvider, treeStateIdGenerator, treeClickStreamParent, features);
    }

    @Override // javax.inject.Provider
    public AdvertDetailsAnalyticsInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get());
    }
}
