package com.avito.android.di.module;

import android.content.res.Resources;
import com.avito.android.serp.adapter.AdvertSpanCountProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class SerpItemConverterModule_ProvideBigAdvertSpanCountProviderFactory implements Factory<AdvertSpanCountProvider> {
    public final Provider<Resources> a;

    public SerpItemConverterModule_ProvideBigAdvertSpanCountProviderFactory(Provider<Resources> provider) {
        this.a = provider;
    }

    public static SerpItemConverterModule_ProvideBigAdvertSpanCountProviderFactory create(Provider<Resources> provider) {
        return new SerpItemConverterModule_ProvideBigAdvertSpanCountProviderFactory(provider);
    }

    public static AdvertSpanCountProvider provideBigAdvertSpanCountProvider(Resources resources) {
        return (AdvertSpanCountProvider) Preconditions.checkNotNullFromProvides(SerpItemConverterModule.provideBigAdvertSpanCountProvider(resources));
    }

    @Override // javax.inject.Provider
    public AdvertSpanCountProvider get() {
        return provideBigAdvertSpanCountProvider(this.a.get());
    }
}
