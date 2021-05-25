package com.avito.android.favorites;

import android.content.Context;
import android.content.res.Resources;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class FavoriteResourceProviderImpl_Factory implements Factory<FavoriteResourceProviderImpl> {
    public final Provider<Context> a;
    public final Provider<Resources> b;

    public FavoriteResourceProviderImpl_Factory(Provider<Context> provider, Provider<Resources> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static FavoriteResourceProviderImpl_Factory create(Provider<Context> provider, Provider<Resources> provider2) {
        return new FavoriteResourceProviderImpl_Factory(provider, provider2);
    }

    public static FavoriteResourceProviderImpl newInstance(Context context, Resources resources) {
        return new FavoriteResourceProviderImpl(context, resources);
    }

    @Override // javax.inject.Provider
    public FavoriteResourceProviderImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
