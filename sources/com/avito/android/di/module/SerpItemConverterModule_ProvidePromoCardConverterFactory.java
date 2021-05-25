package com.avito.android.di.module;

import android.content.res.Resources;
import com.avito.android.Features;
import com.avito.android.serp.adapter.promo_card.PromoCardConverter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class SerpItemConverterModule_ProvidePromoCardConverterFactory implements Factory<PromoCardConverter> {
    public final Provider<Resources> a;
    public final Provider<Features> b;

    public SerpItemConverterModule_ProvidePromoCardConverterFactory(Provider<Resources> provider, Provider<Features> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static SerpItemConverterModule_ProvidePromoCardConverterFactory create(Provider<Resources> provider, Provider<Features> provider2) {
        return new SerpItemConverterModule_ProvidePromoCardConverterFactory(provider, provider2);
    }

    public static PromoCardConverter providePromoCardConverter(Resources resources, Features features) {
        return (PromoCardConverter) Preconditions.checkNotNullFromProvides(SerpItemConverterModule.providePromoCardConverter(resources, features));
    }

    @Override // javax.inject.Provider
    public PromoCardConverter get() {
        return providePromoCardConverter(this.a.get(), this.b.get());
    }
}
