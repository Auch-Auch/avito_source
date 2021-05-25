package com.avito.android.advert.di;

import android.content.res.Resources;
import com.avito.android.serp.ad.AdResourceProvider;
import com.avito.android.serp.adapter.SerpCommercialBannerConverter;
import com.avito.android.util.RandomKeyProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class AdvertFragmentModule_ProvideCommercialConverterFactory implements Factory<SerpCommercialBannerConverter> {
    public final Provider<Resources> a;
    public final Provider<AdResourceProvider> b;
    public final Provider<RandomKeyProvider> c;

    public AdvertFragmentModule_ProvideCommercialConverterFactory(Provider<Resources> provider, Provider<AdResourceProvider> provider2, Provider<RandomKeyProvider> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static AdvertFragmentModule_ProvideCommercialConverterFactory create(Provider<Resources> provider, Provider<AdResourceProvider> provider2, Provider<RandomKeyProvider> provider3) {
        return new AdvertFragmentModule_ProvideCommercialConverterFactory(provider, provider2, provider3);
    }

    public static SerpCommercialBannerConverter provideCommercialConverter(Resources resources, AdResourceProvider adResourceProvider, RandomKeyProvider randomKeyProvider) {
        return (SerpCommercialBannerConverter) Preconditions.checkNotNullFromProvides(AdvertFragmentModule.INSTANCE.provideCommercialConverter(resources, adResourceProvider, randomKeyProvider));
    }

    @Override // javax.inject.Provider
    public SerpCommercialBannerConverter get() {
        return provideCommercialConverter(this.a.get(), this.b.get(), this.c.get());
    }
}
