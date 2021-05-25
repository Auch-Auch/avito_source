package com.avito.android.basket_legacy.fees;

import com.avito.android.analytics.publish.PublishAnalyticsDataProvider;
import com.avito.android.basket_legacy.repositories.BasketRepository;
import com.avito.android.basket_legacy.utils.VasType;
import com.avito.android.fees.remote.FeesApi;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class BasketInteractorImpl_Factory implements Factory<BasketInteractorImpl> {
    public final Provider<String> a;
    public final Provider<Boolean> b;
    public final Provider<VasType> c;
    public final Provider<FeesApi> d;
    public final Provider<PublishAnalyticsDataProvider> e;
    public final Provider<BasketRepository> f;
    public final Provider<SchedulersFactory> g;
    public final Provider<SingleFeeServiceConverter> h;

    public BasketInteractorImpl_Factory(Provider<String> provider, Provider<Boolean> provider2, Provider<VasType> provider3, Provider<FeesApi> provider4, Provider<PublishAnalyticsDataProvider> provider5, Provider<BasketRepository> provider6, Provider<SchedulersFactory> provider7, Provider<SingleFeeServiceConverter> provider8) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
        this.h = provider8;
    }

    public static BasketInteractorImpl_Factory create(Provider<String> provider, Provider<Boolean> provider2, Provider<VasType> provider3, Provider<FeesApi> provider4, Provider<PublishAnalyticsDataProvider> provider5, Provider<BasketRepository> provider6, Provider<SchedulersFactory> provider7, Provider<SingleFeeServiceConverter> provider8) {
        return new BasketInteractorImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    public static BasketInteractorImpl newInstance(String str, boolean z, VasType vasType, FeesApi feesApi, PublishAnalyticsDataProvider publishAnalyticsDataProvider, BasketRepository basketRepository, SchedulersFactory schedulersFactory, SingleFeeServiceConverter singleFeeServiceConverter) {
        return new BasketInteractorImpl(str, z, vasType, feesApi, publishAnalyticsDataProvider, basketRepository, schedulersFactory, singleFeeServiceConverter);
    }

    @Override // javax.inject.Provider
    public BasketInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get().booleanValue(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get());
    }
}
