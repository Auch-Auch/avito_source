package com.avito.android.basket.paid_services;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class BasketIntentFactoryImpl_Factory implements Factory<BasketIntentFactoryImpl> {
    public final Provider<Context> a;

    public BasketIntentFactoryImpl_Factory(Provider<Context> provider) {
        this.a = provider;
    }

    public static BasketIntentFactoryImpl_Factory create(Provider<Context> provider) {
        return new BasketIntentFactoryImpl_Factory(provider);
    }

    public static BasketIntentFactoryImpl newInstance(Context context) {
        return new BasketIntentFactoryImpl(context);
    }

    @Override // javax.inject.Provider
    public BasketIntentFactoryImpl get() {
        return newInstance(this.a.get());
    }
}
