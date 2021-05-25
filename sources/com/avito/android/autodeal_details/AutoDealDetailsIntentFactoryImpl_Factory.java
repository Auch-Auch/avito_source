package com.avito.android.autodeal_details;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AutoDealDetailsIntentFactoryImpl_Factory implements Factory<AutoDealDetailsIntentFactoryImpl> {
    public final Provider<Context> a;

    public AutoDealDetailsIntentFactoryImpl_Factory(Provider<Context> provider) {
        this.a = provider;
    }

    public static AutoDealDetailsIntentFactoryImpl_Factory create(Provider<Context> provider) {
        return new AutoDealDetailsIntentFactoryImpl_Factory(provider);
    }

    public static AutoDealDetailsIntentFactoryImpl newInstance(Context context) {
        return new AutoDealDetailsIntentFactoryImpl(context);
    }

    @Override // javax.inject.Provider
    public AutoDealDetailsIntentFactoryImpl get() {
        return newInstance(this.a.get());
    }
}
