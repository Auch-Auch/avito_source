package com.avito.android.di.module;

import com.avito.android.serp.ad.AdResourceProvider;
import com.avito.android.serp.adapter.AdvertSpanCountProvider;
import com.avito.android.serp.adapter.SerpCommercialBannerConverter;
import com.avito.android.util.RandomKeyProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class SerpItemConverterModule_ProvideCommercialConverterFactory implements Factory<SerpCommercialBannerConverter> {
    public final Provider<AdvertSpanCountProvider> a;
    public final Provider<AdvertSpanCountProvider> b;
    public final Provider<AdResourceProvider> c;
    public final Provider<RandomKeyProvider> d;

    public SerpItemConverterModule_ProvideCommercialConverterFactory(Provider<AdvertSpanCountProvider> provider, Provider<AdvertSpanCountProvider> provider2, Provider<AdResourceProvider> provider3, Provider<RandomKeyProvider> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static SerpItemConverterModule_ProvideCommercialConverterFactory create(Provider<AdvertSpanCountProvider> provider, Provider<AdvertSpanCountProvider> provider2, Provider<AdResourceProvider> provider3, Provider<RandomKeyProvider> provider4) {
        return new SerpItemConverterModule_ProvideCommercialConverterFactory(provider, provider2, provider3, provider4);
    }

    public static SerpCommercialBannerConverter provideCommercialConverter(AdvertSpanCountProvider advertSpanCountProvider, AdvertSpanCountProvider advertSpanCountProvider2, AdResourceProvider adResourceProvider, RandomKeyProvider randomKeyProvider) {
        return (SerpCommercialBannerConverter) Preconditions.checkNotNullFromProvides(SerpItemConverterModule.provideCommercialConverter(advertSpanCountProvider, advertSpanCountProvider2, adResourceProvider, randomKeyProvider));
    }

    @Override // javax.inject.Provider
    public SerpCommercialBannerConverter get() {
        return provideCommercialConverter(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
