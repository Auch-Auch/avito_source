package com.avito.android.abuse;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AbuseIntentFactoryImpl_Factory implements Factory<AbuseIntentFactoryImpl> {
    public final Provider<Context> a;

    public AbuseIntentFactoryImpl_Factory(Provider<Context> provider) {
        this.a = provider;
    }

    public static AbuseIntentFactoryImpl_Factory create(Provider<Context> provider) {
        return new AbuseIntentFactoryImpl_Factory(provider);
    }

    public static AbuseIntentFactoryImpl newInstance(Context context) {
        return new AbuseIntentFactoryImpl(context);
    }

    @Override // javax.inject.Provider
    public AbuseIntentFactoryImpl get() {
        return newInstance(this.a.get());
    }
}
