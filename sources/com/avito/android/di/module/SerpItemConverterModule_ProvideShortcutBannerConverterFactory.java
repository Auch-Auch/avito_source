package com.avito.android.di.module;

import android.content.res.Resources;
import com.avito.android.deep_linking.DeepLinkFactory;
import com.avito.android.serp.adapter.ShortcutBannerConverter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class SerpItemConverterModule_ProvideShortcutBannerConverterFactory implements Factory<ShortcutBannerConverter> {
    public final Provider<DeepLinkFactory> a;
    public final Provider<Resources> b;

    public SerpItemConverterModule_ProvideShortcutBannerConverterFactory(Provider<DeepLinkFactory> provider, Provider<Resources> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static SerpItemConverterModule_ProvideShortcutBannerConverterFactory create(Provider<DeepLinkFactory> provider, Provider<Resources> provider2) {
        return new SerpItemConverterModule_ProvideShortcutBannerConverterFactory(provider, provider2);
    }

    public static ShortcutBannerConverter provideShortcutBannerConverter(DeepLinkFactory deepLinkFactory, Resources resources) {
        return (ShortcutBannerConverter) Preconditions.checkNotNullFromProvides(SerpItemConverterModule.provideShortcutBannerConverter(deepLinkFactory, resources));
    }

    @Override // javax.inject.Provider
    public ShortcutBannerConverter get() {
        return provideShortcutBannerConverter(this.a.get(), this.b.get());
    }
}
