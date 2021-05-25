package com.avito.android.remote.notification;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class NotificationServiceIntentFactoryImpl_Factory implements Factory<NotificationServiceIntentFactoryImpl> {
    public final Provider<Context> a;

    public NotificationServiceIntentFactoryImpl_Factory(Provider<Context> provider) {
        this.a = provider;
    }

    public static NotificationServiceIntentFactoryImpl_Factory create(Provider<Context> provider) {
        return new NotificationServiceIntentFactoryImpl_Factory(provider);
    }

    public static NotificationServiceIntentFactoryImpl newInstance(Context context) {
        return new NotificationServiceIntentFactoryImpl(context);
    }

    @Override // javax.inject.Provider
    public NotificationServiceIntentFactoryImpl get() {
        return newInstance(this.a.get());
    }
}
