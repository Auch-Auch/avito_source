package com.avito.android;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class MessengerWorkFactoryImpl_Factory implements Factory<MessengerWorkFactoryImpl> {
    public final Provider<Context> a;
    public final Provider<Features> b;

    public MessengerWorkFactoryImpl_Factory(Provider<Context> provider, Provider<Features> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static MessengerWorkFactoryImpl_Factory create(Provider<Context> provider, Provider<Features> provider2) {
        return new MessengerWorkFactoryImpl_Factory(provider, provider2);
    }

    public static MessengerWorkFactoryImpl newInstance(Context context, Features features) {
        return new MessengerWorkFactoryImpl(context, features);
    }

    @Override // javax.inject.Provider
    public MessengerWorkFactoryImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
