package com.avito.android.soa_stat.profile_settings;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SoaStatIntentFactoryImpl_Factory implements Factory<SoaStatIntentFactoryImpl> {
    public final Provider<Context> a;

    public SoaStatIntentFactoryImpl_Factory(Provider<Context> provider) {
        this.a = provider;
    }

    public static SoaStatIntentFactoryImpl_Factory create(Provider<Context> provider) {
        return new SoaStatIntentFactoryImpl_Factory(provider);
    }

    public static SoaStatIntentFactoryImpl newInstance(Context context) {
        return new SoaStatIntentFactoryImpl(context);
    }

    @Override // javax.inject.Provider
    public SoaStatIntentFactoryImpl get() {
        return newInstance(this.a.get());
    }
}
