package com.avito.android.util;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ImplicitIntentFactoryImpl_Factory implements Factory<ImplicitIntentFactoryImpl> {
    public final Provider<Context> a;
    public final Provider<Formatter<String>> b;

    public ImplicitIntentFactoryImpl_Factory(Provider<Context> provider, Provider<Formatter<String>> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static ImplicitIntentFactoryImpl_Factory create(Provider<Context> provider, Provider<Formatter<String>> provider2) {
        return new ImplicitIntentFactoryImpl_Factory(provider, provider2);
    }

    public static ImplicitIntentFactoryImpl newInstance(Context context, Formatter<String> formatter) {
        return new ImplicitIntentFactoryImpl(context, formatter);
    }

    @Override // javax.inject.Provider
    public ImplicitIntentFactoryImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
