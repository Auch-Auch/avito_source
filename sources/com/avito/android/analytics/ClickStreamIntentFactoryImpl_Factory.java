package com.avito.android.analytics;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ClickStreamIntentFactoryImpl_Factory implements Factory<ClickStreamIntentFactoryImpl> {
    public final Provider<Context> a;

    public ClickStreamIntentFactoryImpl_Factory(Provider<Context> provider) {
        this.a = provider;
    }

    public static ClickStreamIntentFactoryImpl_Factory create(Provider<Context> provider) {
        return new ClickStreamIntentFactoryImpl_Factory(provider);
    }

    public static ClickStreamIntentFactoryImpl newInstance(Context context) {
        return new ClickStreamIntentFactoryImpl(context);
    }

    @Override // javax.inject.Provider
    public ClickStreamIntentFactoryImpl get() {
        return newInstance(this.a.get());
    }
}
