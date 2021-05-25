package com.avito.android.di.module;

import android.content.res.Resources;
import com.avito.android.Features;
import com.avito.android.serp.adapter.advert_xl.SerpAdvertXlConverter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class SerpItemConverterModule_ProvideAdvertXlConverterFactory implements Factory<SerpAdvertXlConverter> {
    public final Provider<Resources> a;
    public final Provider<Features> b;

    public SerpItemConverterModule_ProvideAdvertXlConverterFactory(Provider<Resources> provider, Provider<Features> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static SerpItemConverterModule_ProvideAdvertXlConverterFactory create(Provider<Resources> provider, Provider<Features> provider2) {
        return new SerpItemConverterModule_ProvideAdvertXlConverterFactory(provider, provider2);
    }

    public static SerpAdvertXlConverter provideAdvertXlConverter(Resources resources, Features features) {
        return (SerpAdvertXlConverter) Preconditions.checkNotNullFromProvides(SerpItemConverterModule.provideAdvertXlConverter(resources, features));
    }

    @Override // javax.inject.Provider
    public SerpAdvertXlConverter get() {
        return provideAdvertXlConverter(this.a.get(), this.b.get());
    }
}
