package com.avito.android.notifications_settings.title;

import dagger.internal.Factory;
public final class NotificationsSettingsTitlePresenterImpl_Factory implements Factory<NotificationsSettingsTitlePresenterImpl> {

    public static final class a {
        public static final NotificationsSettingsTitlePresenterImpl_Factory a = new NotificationsSettingsTitlePresenterImpl_Factory();
    }

    public static NotificationsSettingsTitlePresenterImpl_Factory create() {
        return a.a;
    }

    public static NotificationsSettingsTitlePresenterImpl newInstance() {
        return new NotificationsSettingsTitlePresenterImpl();
    }

    @Override // javax.inject.Provider
    public NotificationsSettingsTitlePresenterImpl get() {
        return newInstance();
    }
}
