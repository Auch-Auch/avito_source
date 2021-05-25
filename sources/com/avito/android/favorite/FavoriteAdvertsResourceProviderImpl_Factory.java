package com.avito.android.favorite;

import android.content.res.Resources;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class FavoriteAdvertsResourceProviderImpl_Factory implements Factory<FavoriteAdvertsResourceProviderImpl> {
    public final Provider<Resources> a;

    public FavoriteAdvertsResourceProviderImpl_Factory(Provider<Resources> provider) {
        this.a = provider;
    }

    public static FavoriteAdvertsResourceProviderImpl_Factory create(Provider<Resources> provider) {
        return new FavoriteAdvertsResourceProviderImpl_Factory(provider);
    }

    public static FavoriteAdvertsResourceProviderImpl newInstance(Resources resources) {
        return new FavoriteAdvertsResourceProviderImpl(resources);
    }

    @Override // javax.inject.Provider
    public FavoriteAdvertsResourceProviderImpl get() {
        return newInstance(this.a.get());
    }
}
