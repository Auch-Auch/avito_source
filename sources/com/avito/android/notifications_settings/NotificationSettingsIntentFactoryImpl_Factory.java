package com.avito.android.notifications_settings;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class NotificationSettingsIntentFactoryImpl_Factory implements Factory<NotificationSettingsIntentFactoryImpl> {
    public final Provider<Context> a;

    public NotificationSettingsIntentFactoryImpl_Factory(Provider<Context> provider) {
        this.a = provider;
    }

    public static NotificationSettingsIntentFactoryImpl_Factory create(Provider<Context> provider) {
        return new NotificationSettingsIntentFactoryImpl_Factory(provider);
    }

    public static NotificationSettingsIntentFactoryImpl newInstance(Context context) {
        return new NotificationSettingsIntentFactoryImpl(context);
    }

    @Override // javax.inject.Provider
    public NotificationSettingsIntentFactoryImpl get() {
        return newInstance(this.a.get());
    }
}
