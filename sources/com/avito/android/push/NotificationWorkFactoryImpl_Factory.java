package com.avito.android.push;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class NotificationWorkFactoryImpl_Factory implements Factory<NotificationWorkFactoryImpl> {
    public final Provider<Context> a;

    public NotificationWorkFactoryImpl_Factory(Provider<Context> provider) {
        this.a = provider;
    }

    public static NotificationWorkFactoryImpl_Factory create(Provider<Context> provider) {
        return new NotificationWorkFactoryImpl_Factory(provider);
    }

    public static NotificationWorkFactoryImpl newInstance(Context context) {
        return new NotificationWorkFactoryImpl(context);
    }

    @Override // javax.inject.Provider
    public NotificationWorkFactoryImpl get() {
        return newInstance(this.a.get());
    }
}
