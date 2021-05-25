package com.avito.android.favorite_sellers.service;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class FavoriteSellerServiceIntentFactoryImpl_Factory implements Factory<FavoriteSellerServiceIntentFactoryImpl> {
    public final Provider<Context> a;

    public FavoriteSellerServiceIntentFactoryImpl_Factory(Provider<Context> provider) {
        this.a = provider;
    }

    public static FavoriteSellerServiceIntentFactoryImpl_Factory create(Provider<Context> provider) {
        return new FavoriteSellerServiceIntentFactoryImpl_Factory(provider);
    }

    public static FavoriteSellerServiceIntentFactoryImpl newInstance(Context context) {
        return new FavoriteSellerServiceIntentFactoryImpl(context);
    }

    @Override // javax.inject.Provider
    public FavoriteSellerServiceIntentFactoryImpl get() {
        return newInstance(this.a.get());
    }
}
