package com.avito.android.extended_profile.di;

import android.content.res.Resources;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ExtendedProfileModule_ProvideAdvertsColumnCountFactory implements Factory<Integer> {
    public final Provider<Resources> a;

    public ExtendedProfileModule_ProvideAdvertsColumnCountFactory(Provider<Resources> provider) {
        this.a = provider;
    }

    public static ExtendedProfileModule_ProvideAdvertsColumnCountFactory create(Provider<Resources> provider) {
        return new ExtendedProfileModule_ProvideAdvertsColumnCountFactory(provider);
    }

    public static int provideAdvertsColumnCount(Resources resources) {
        return ExtendedProfileModule.INSTANCE.provideAdvertsColumnCount(resources);
    }

    @Override // javax.inject.Provider
    public Integer get() {
        return Integer.valueOf(provideAdvertsColumnCount(this.a.get()));
    }
}
