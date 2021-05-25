package com.avito.android;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class MessengerServiceIntentFactoryImpl_Factory implements Factory<MessengerServiceIntentFactoryImpl> {
    public final Provider<Context> a;

    public MessengerServiceIntentFactoryImpl_Factory(Provider<Context> provider) {
        this.a = provider;
    }

    public static MessengerServiceIntentFactoryImpl_Factory create(Provider<Context> provider) {
        return new MessengerServiceIntentFactoryImpl_Factory(provider);
    }

    public static MessengerServiceIntentFactoryImpl newInstance(Context context) {
        return new MessengerServiceIntentFactoryImpl(context);
    }

    @Override // javax.inject.Provider
    public MessengerServiceIntentFactoryImpl get() {
        return newInstance(this.a.get());
    }
}
