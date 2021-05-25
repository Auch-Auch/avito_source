package com.avito.android.notifications_settings.space;

import dagger.internal.Factory;
public final class NotificationsSettingsSpacePresenterImpl_Factory implements Factory<NotificationsSettingsSpacePresenterImpl> {

    public static final class a {
        public static final NotificationsSettingsSpacePresenterImpl_Factory a = new NotificationsSettingsSpacePresenterImpl_Factory();
    }

    public static NotificationsSettingsSpacePresenterImpl_Factory create() {
        return a.a;
    }

    public static NotificationsSettingsSpacePresenterImpl newInstance() {
        return new NotificationsSettingsSpacePresenterImpl();
    }

    @Override // javax.inject.Provider
    public NotificationsSettingsSpacePresenterImpl get() {
        return newInstance();
    }
}
