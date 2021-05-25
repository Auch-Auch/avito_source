package com.avito.android;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class DebugIntentFactoryImpl_Factory implements Factory<DebugIntentFactoryImpl> {
    public final Provider<Context> a;

    public DebugIntentFactoryImpl_Factory(Provider<Context> provider) {
        this.a = provider;
    }

    public static DebugIntentFactoryImpl_Factory create(Provider<Context> provider) {
        return new DebugIntentFactoryImpl_Factory(provider);
    }

    public static DebugIntentFactoryImpl newInstance(Context context) {
        return new DebugIntentFactoryImpl(context);
    }

    @Override // javax.inject.Provider
    public DebugIntentFactoryImpl get() {
        return newInstance(this.a.get());
    }
}
