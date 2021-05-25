package com.avito.android.extended_profile.di;

import android.content.res.Resources;
import com.avito.android.Features;
import com.avito.android.serp.adapter.SerpAdvertConverter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ExtendedProfileModule_ProvideAdvertConverterFactory implements Factory<SerpAdvertConverter> {
    public final Provider<Resources> a;
    public final Provider<Features> b;

    public ExtendedProfileModule_ProvideAdvertConverterFactory(Provider<Resources> provider, Provider<Features> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static ExtendedProfileModule_ProvideAdvertConverterFactory create(Provider<Resources> provider, Provider<Features> provider2) {
        return new ExtendedProfileModule_ProvideAdvertConverterFactory(provider, provider2);
    }

    public static SerpAdvertConverter provideAdvertConverter(Resources resources, Features features) {
        return (SerpAdvertConverter) Preconditions.checkNotNullFromProvides(ExtendedProfileModule.provideAdvertConverter(resources, features));
    }

    @Override // javax.inject.Provider
    public SerpAdvertConverter get() {
        return provideAdvertConverter(this.a.get(), this.b.get());
    }
}
