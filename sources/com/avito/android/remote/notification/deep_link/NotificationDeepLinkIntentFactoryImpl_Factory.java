package com.avito.android.remote.notification.deep_link;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class NotificationDeepLinkIntentFactoryImpl_Factory implements Factory<NotificationDeepLinkIntentFactoryImpl> {
    public final Provider<Context> a;

    public NotificationDeepLinkIntentFactoryImpl_Factory(Provider<Context> provider) {
        this.a = provider;
    }

    public static NotificationDeepLinkIntentFactoryImpl_Factory create(Provider<Context> provider) {
        return new NotificationDeepLinkIntentFactoryImpl_Factory(provider);
    }

    public static NotificationDeepLinkIntentFactoryImpl newInstance(Context context) {
        return new NotificationDeepLinkIntentFactoryImpl(context);
    }

    @Override // javax.inject.Provider
    public NotificationDeepLinkIntentFactoryImpl get() {
        return newInstance(this.a.get());
    }
}
