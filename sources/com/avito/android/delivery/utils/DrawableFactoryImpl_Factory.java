package com.avito.android.delivery.utils;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class DrawableFactoryImpl_Factory implements Factory<DrawableFactoryImpl> {
    public final Provider<Context> a;

    public DrawableFactoryImpl_Factory(Provider<Context> provider) {
        this.a = provider;
    }

    public static DrawableFactoryImpl_Factory create(Provider<Context> provider) {
        return new DrawableFactoryImpl_Factory(provider);
    }

    public static DrawableFactoryImpl newInstance(Context context) {
        return new DrawableFactoryImpl(context);
    }

    @Override // javax.inject.Provider
    public DrawableFactoryImpl get() {
        return newInstance(this.a.get());
    }
}
