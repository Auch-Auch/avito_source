package com.avito.android.di.module;

import android.content.res.Resources;
import com.avito.android.serp.adapter.SpannedGridPositionProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class SpanAdapterModule_ProvideSpannedGridPositionProviderFactory implements Factory<SpannedGridPositionProvider> {
    public final Provider<Resources> a;

    public SpanAdapterModule_ProvideSpannedGridPositionProviderFactory(Provider<Resources> provider) {
        this.a = provider;
    }

    public static SpanAdapterModule_ProvideSpannedGridPositionProviderFactory create(Provider<Resources> provider) {
        return new SpanAdapterModule_ProvideSpannedGridPositionProviderFactory(provider);
    }

    public static SpannedGridPositionProvider provideSpannedGridPositionProvider(Resources resources) {
        return (SpannedGridPositionProvider) Preconditions.checkNotNullFromProvides(SpanAdapterModule.provideSpannedGridPositionProvider(resources));
    }

    @Override // javax.inject.Provider
    public SpannedGridPositionProvider get() {
        return provideSpannedGridPositionProvider(this.a.get());
    }
}
