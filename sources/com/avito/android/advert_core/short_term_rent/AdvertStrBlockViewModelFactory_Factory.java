package com.avito.android.advert_core.short_term_rent;

import com.avito.android.remote.model.AdvertSellerShortTermRent;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.text.AttributedTextFormatter;
import com.jakewharton.rxrelay3.PublishRelay;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertStrBlockViewModelFactory_Factory implements Factory<AdvertStrBlockViewModelFactory> {
    public final Provider<AdvertStrBlockInteractor> a;
    public final Provider<SchedulersFactory3> b;
    public final Provider<AttributedTextFormatter> c;
    public final Provider<AdvertStrBlockViewResourceProvider> d;
    public final Provider<AdvertStrBlockAnalyticsInteractor> e;
    public final Provider<PublishRelay<AdvertSellerShortTermRent>> f;

    public AdvertStrBlockViewModelFactory_Factory(Provider<AdvertStrBlockInteractor> provider, Provider<SchedulersFactory3> provider2, Provider<AttributedTextFormatter> provider3, Provider<AdvertStrBlockViewResourceProvider> provider4, Provider<AdvertStrBlockAnalyticsInteractor> provider5, Provider<PublishRelay<AdvertSellerShortTermRent>> provider6) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
    }

    public static AdvertStrBlockViewModelFactory_Factory create(Provider<AdvertStrBlockInteractor> provider, Provider<SchedulersFactory3> provider2, Provider<AttributedTextFormatter> provider3, Provider<AdvertStrBlockViewResourceProvider> provider4, Provider<AdvertStrBlockAnalyticsInteractor> provider5, Provider<PublishRelay<AdvertSellerShortTermRent>> provider6) {
        return new AdvertStrBlockViewModelFactory_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static AdvertStrBlockViewModelFactory newInstance(AdvertStrBlockInteractor advertStrBlockInteractor, SchedulersFactory3 schedulersFactory3, AttributedTextFormatter attributedTextFormatter, AdvertStrBlockViewResourceProvider advertStrBlockViewResourceProvider, AdvertStrBlockAnalyticsInteractor advertStrBlockAnalyticsInteractor, PublishRelay<AdvertSellerShortTermRent> publishRelay) {
        return new AdvertStrBlockViewModelFactory(advertStrBlockInteractor, schedulersFactory3, attributedTextFormatter, advertStrBlockViewResourceProvider, advertStrBlockAnalyticsInteractor, publishRelay);
    }

    @Override // javax.inject.Provider
    public AdvertStrBlockViewModelFactory get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get());
    }
}
