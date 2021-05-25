package com.avito.android.di.module;

import com.avito.android.serp.adapter.LayoutTypeProvider;
import com.avito.android.serp.adapter.ViewTypeColumnProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class SerpItemConverterModule_ProvideViewTypeColumnProviderFactory implements Factory<ViewTypeColumnProvider> {
    public final Provider<LayoutTypeProvider> a;

    public SerpItemConverterModule_ProvideViewTypeColumnProviderFactory(Provider<LayoutTypeProvider> provider) {
        this.a = provider;
    }

    public static SerpItemConverterModule_ProvideViewTypeColumnProviderFactory create(Provider<LayoutTypeProvider> provider) {
        return new SerpItemConverterModule_ProvideViewTypeColumnProviderFactory(provider);
    }

    public static ViewTypeColumnProvider provideViewTypeColumnProvider(LayoutTypeProvider layoutTypeProvider) {
        return (ViewTypeColumnProvider) Preconditions.checkNotNullFromProvides(SerpItemConverterModule.provideViewTypeColumnProvider(layoutTypeProvider));
    }

    @Override // javax.inject.Provider
    public ViewTypeColumnProvider get() {
        return provideViewTypeColumnProvider(this.a.get());
    }
}
