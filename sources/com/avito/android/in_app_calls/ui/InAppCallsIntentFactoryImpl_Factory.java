package com.avito.android.in_app_calls.ui;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class InAppCallsIntentFactoryImpl_Factory implements Factory<InAppCallsIntentFactoryImpl> {
    public final Provider<Context> a;

    public InAppCallsIntentFactoryImpl_Factory(Provider<Context> provider) {
        this.a = provider;
    }

    public static InAppCallsIntentFactoryImpl_Factory create(Provider<Context> provider) {
        return new InAppCallsIntentFactoryImpl_Factory(provider);
    }

    public static InAppCallsIntentFactoryImpl newInstance(Context context) {
        return new InAppCallsIntentFactoryImpl(context);
    }

    @Override // javax.inject.Provider
    public InAppCallsIntentFactoryImpl get() {
        return newInstance(this.a.get());
    }
}
