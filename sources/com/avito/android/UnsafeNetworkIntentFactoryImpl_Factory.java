package com.avito.android;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class UnsafeNetworkIntentFactoryImpl_Factory implements Factory<UnsafeNetworkIntentFactoryImpl> {
    public final Provider<Context> a;

    public UnsafeNetworkIntentFactoryImpl_Factory(Provider<Context> provider) {
        this.a = provider;
    }

    public static UnsafeNetworkIntentFactoryImpl_Factory create(Provider<Context> provider) {
        return new UnsafeNetworkIntentFactoryImpl_Factory(provider);
    }

    public static UnsafeNetworkIntentFactoryImpl newInstance(Context context) {
        return new UnsafeNetworkIntentFactoryImpl(context);
    }

    @Override // javax.inject.Provider
    public UnsafeNetworkIntentFactoryImpl get() {
        return newInstance(this.a.get());
    }
}
