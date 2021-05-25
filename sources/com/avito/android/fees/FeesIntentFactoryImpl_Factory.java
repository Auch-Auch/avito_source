package com.avito.android.fees;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class FeesIntentFactoryImpl_Factory implements Factory<FeesIntentFactoryImpl> {
    public final Provider<Context> a;

    public FeesIntentFactoryImpl_Factory(Provider<Context> provider) {
        this.a = provider;
    }

    public static FeesIntentFactoryImpl_Factory create(Provider<Context> provider) {
        return new FeesIntentFactoryImpl_Factory(provider);
    }

    public static FeesIntentFactoryImpl newInstance(Context context) {
        return new FeesIntentFactoryImpl(context);
    }

    @Override // javax.inject.Provider
    public FeesIntentFactoryImpl get() {
        return newInstance(this.a.get());
    }
}
