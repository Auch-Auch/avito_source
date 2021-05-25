package com.avito.android.cart;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class CartIntentFactoryImpl_Factory implements Factory<CartIntentFactoryImpl> {
    public final Provider<Context> a;

    public CartIntentFactoryImpl_Factory(Provider<Context> provider) {
        this.a = provider;
    }

    public static CartIntentFactoryImpl_Factory create(Provider<Context> provider) {
        return new CartIntentFactoryImpl_Factory(provider);
    }

    public static CartIntentFactoryImpl newInstance(Context context) {
        return new CartIntentFactoryImpl(context);
    }

    @Override // javax.inject.Provider
    public CartIntentFactoryImpl get() {
        return newInstance(this.a.get());
    }
}
