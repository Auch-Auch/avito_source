package com.avito.android.di.module;

import android.content.res.Resources;
import com.avito.android.Features;
import com.avito.android.serp.adapter.AdvertSpanCountProvider;
import com.avito.android.serp.adapter.SerpAdvertConverter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class SerpItemConverterModule_ProvideAdvertConverterFactory implements Factory<SerpAdvertConverter> {
    public final Provider<AdvertSpanCountProvider> a;
    public final Provider<AdvertSpanCountProvider> b;
    public final Provider<Resources> c;
    public final Provider<Features> d;

    public SerpItemConverterModule_ProvideAdvertConverterFactory(Provider<AdvertSpanCountProvider> provider, Provider<AdvertSpanCountProvider> provider2, Provider<Resources> provider3, Provider<Features> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static SerpItemConverterModule_ProvideAdvertConverterFactory create(Provider<AdvertSpanCountProvider> provider, Provider<AdvertSpanCountProvider> provider2, Provider<Resources> provider3, Provider<Features> provider4) {
        return new SerpItemConverterModule_ProvideAdvertConverterFactory(provider, provider2, provider3, provider4);
    }

    public static SerpAdvertConverter provideAdvertConverter(AdvertSpanCountProvider advertSpanCountProvider, AdvertSpanCountProvider advertSpanCountProvider2, Resources resources, Features features) {
        return (SerpAdvertConverter) Preconditions.checkNotNullFromProvides(SerpItemConverterModule.provideAdvertConverter(advertSpanCountProvider, advertSpanCountProvider2, resources, features));
    }

    @Override // javax.inject.Provider
    public SerpAdvertConverter get() {
        return provideAdvertConverter(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
