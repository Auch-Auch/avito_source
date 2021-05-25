package com.avito.android.favorites;

import android.content.res.Resources;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class FavoriteAdvertItemConverterResourceProviderImpl_Factory implements Factory<FavoriteAdvertItemConverterResourceProviderImpl> {
    public final Provider<Resources> a;

    public FavoriteAdvertItemConverterResourceProviderImpl_Factory(Provider<Resources> provider) {
        this.a = provider;
    }

    public static FavoriteAdvertItemConverterResourceProviderImpl_Factory create(Provider<Resources> provider) {
        return new FavoriteAdvertItemConverterResourceProviderImpl_Factory(provider);
    }

    public static FavoriteAdvertItemConverterResourceProviderImpl newInstance(Resources resources) {
        return new FavoriteAdvertItemConverterResourceProviderImpl(resources);
    }

    @Override // javax.inject.Provider
    public FavoriteAdvertItemConverterResourceProviderImpl get() {
        return newInstance(this.a.get());
    }
}
