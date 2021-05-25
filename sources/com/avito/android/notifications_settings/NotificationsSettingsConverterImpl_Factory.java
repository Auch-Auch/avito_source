package com.avito.android.notifications_settings;

import dagger.internal.Factory;
public final class NotificationsSettingsConverterImpl_Factory implements Factory<NotificationsSettingsConverterImpl> {

    public static final class a {
        public static final NotificationsSettingsConverterImpl_Factory a = new NotificationsSettingsConverterImpl_Factory();
    }

    public static NotificationsSettingsConverterImpl_Factory create() {
        return a.a;
    }

    public static NotificationsSettingsConverterImpl newInstance() {
        return new NotificationsSettingsConverterImpl();
    }

    @Override // javax.inject.Provider
    public NotificationsSettingsConverterImpl get() {
        return newInstance();
    }
}
