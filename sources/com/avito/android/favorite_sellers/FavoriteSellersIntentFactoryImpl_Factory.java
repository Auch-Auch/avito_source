package com.avito.android.favorite_sellers;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class FavoriteSellersIntentFactoryImpl_Factory implements Factory<FavoriteSellersIntentFactoryImpl> {
    public final Provider<Context> a;

    public FavoriteSellersIntentFactoryImpl_Factory(Provider<Context> provider) {
        this.a = provider;
    }

    public static FavoriteSellersIntentFactoryImpl_Factory create(Provider<Context> provider) {
        return new FavoriteSellersIntentFactoryImpl_Factory(provider);
    }

    public static FavoriteSellersIntentFactoryImpl newInstance(Context context) {
        return new FavoriteSellersIntentFactoryImpl(context);
    }

    @Override // javax.inject.Provider
    public FavoriteSellersIntentFactoryImpl get() {
        return newInstance(this.a.get());
    }
}
