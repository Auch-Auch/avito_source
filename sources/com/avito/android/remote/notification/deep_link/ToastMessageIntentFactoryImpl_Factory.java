package com.avito.android.remote.notification.deep_link;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ToastMessageIntentFactoryImpl_Factory implements Factory<ToastMessageIntentFactoryImpl> {
    public final Provider<Context> a;

    public ToastMessageIntentFactoryImpl_Factory(Provider<Context> provider) {
        this.a = provider;
    }

    public static ToastMessageIntentFactoryImpl_Factory create(Provider<Context> provider) {
        return new ToastMessageIntentFactoryImpl_Factory(provider);
    }

    public static ToastMessageIntentFactoryImpl newInstance(Context context) {
        return new ToastMessageIntentFactoryImpl(context);
    }

    @Override // javax.inject.Provider
    public ToastMessageIntentFactoryImpl get() {
        return newInstance(this.a.get());
    }
}
