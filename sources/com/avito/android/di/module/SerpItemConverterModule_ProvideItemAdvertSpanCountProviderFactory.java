package com.avito.android.di.module;

import android.content.res.Resources;
import com.avito.android.serp.adapter.AdvertSpanCountProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class SerpItemConverterModule_ProvideItemAdvertSpanCountProviderFactory implements Factory<AdvertSpanCountProvider> {
    public final Provider<Resources> a;

    public SerpItemConverterModule_ProvideItemAdvertSpanCountProviderFactory(Provider<Resources> provider) {
        this.a = provider;
    }

    public static SerpItemConverterModule_ProvideItemAdvertSpanCountProviderFactory create(Provider<Resources> provider) {
        return new SerpItemConverterModule_ProvideItemAdvertSpanCountProviderFactory(provider);
    }

    public static AdvertSpanCountProvider provideItemAdvertSpanCountProvider(Resources resources) {
        return (AdvertSpanCountProvider) Preconditions.checkNotNullFromProvides(SerpItemConverterModule.provideItemAdvertSpanCountProvider(resources));
    }

    @Override // javax.inject.Provider
    public AdvertSpanCountProvider get() {
        return provideItemAdvertSpanCountProvider(this.a.get());
    }
}
