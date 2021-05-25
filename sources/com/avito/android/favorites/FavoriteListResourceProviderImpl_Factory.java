package com.avito.android.favorites;

import android.content.res.Resources;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class FavoriteListResourceProviderImpl_Factory implements Factory<FavoriteListResourceProviderImpl> {
    public final Provider<Resources> a;

    public FavoriteListResourceProviderImpl_Factory(Provider<Resources> provider) {
        this.a = provider;
    }

    public static FavoriteListResourceProviderImpl_Factory create(Provider<Resources> provider) {
        return new FavoriteListResourceProviderImpl_Factory(provider);
    }

    public static FavoriteListResourceProviderImpl newInstance(Resources resources) {
        return new FavoriteListResourceProviderImpl(resources);
    }

    @Override // javax.inject.Provider
    public FavoriteListResourceProviderImpl get() {
        return newInstance(this.a.get());
    }
}
