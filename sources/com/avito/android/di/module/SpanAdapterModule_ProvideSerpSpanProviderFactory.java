package com.avito.android.di.module;

import android.content.res.Resources;
import com.avito.android.serp.adapter.SerpSpanProvider;
import com.avito.android.serp.adapter.SpannedGridPositionProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class SpanAdapterModule_ProvideSerpSpanProviderFactory implements Factory<SerpSpanProvider> {
    public final Provider<SpannedGridPositionProvider> a;
    public final Provider<Resources> b;

    public SpanAdapterModule_ProvideSerpSpanProviderFactory(Provider<SpannedGridPositionProvider> provider, Provider<Resources> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static SpanAdapterModule_ProvideSerpSpanProviderFactory create(Provider<SpannedGridPositionProvider> provider, Provider<Resources> provider2) {
        return new SpanAdapterModule_ProvideSerpSpanProviderFactory(provider, provider2);
    }

    public static SerpSpanProvider provideSerpSpanProvider(SpannedGridPositionProvider spannedGridPositionProvider, Resources resources) {
        return (SerpSpanProvider) Preconditions.checkNotNullFromProvides(SpanAdapterModule.provideSerpSpanProvider(spannedGridPositionProvider, resources));
    }

    @Override // javax.inject.Provider
    public SerpSpanProvider get() {
        return provideSerpSpanProvider(this.a.get(), this.b.get());
    }
}
