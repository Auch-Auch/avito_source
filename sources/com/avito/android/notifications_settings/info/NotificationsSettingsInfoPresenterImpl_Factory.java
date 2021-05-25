package com.avito.android.notifications_settings.info;

import dagger.internal.Factory;
public final class NotificationsSettingsInfoPresenterImpl_Factory implements Factory<NotificationsSettingsInfoPresenterImpl> {

    public static final class a {
        public static final NotificationsSettingsInfoPresenterImpl_Factory a = new NotificationsSettingsInfoPresenterImpl_Factory();
    }

    public static NotificationsSettingsInfoPresenterImpl_Factory create() {
        return a.a;
    }

    public static NotificationsSettingsInfoPresenterImpl newInstance() {
        return new NotificationsSettingsInfoPresenterImpl();
    }

    @Override // javax.inject.Provider
    public NotificationsSettingsInfoPresenterImpl get() {
        return newInstance();
    }
}
