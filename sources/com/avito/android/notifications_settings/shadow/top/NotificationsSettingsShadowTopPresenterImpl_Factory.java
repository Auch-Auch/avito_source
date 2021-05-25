package com.avito.android.notifications_settings.shadow.top;

import dagger.internal.Factory;
public final class NotificationsSettingsShadowTopPresenterImpl_Factory implements Factory<NotificationsSettingsShadowTopPresenterImpl> {

    public static final class a {
        public static final NotificationsSettingsShadowTopPresenterImpl_Factory a = new NotificationsSettingsShadowTopPresenterImpl_Factory();
    }

    public static NotificationsSettingsShadowTopPresenterImpl_Factory create() {
        return a.a;
    }

    public static NotificationsSettingsShadowTopPresenterImpl newInstance() {
        return new NotificationsSettingsShadowTopPresenterImpl();
    }

    @Override // javax.inject.Provider
    public NotificationsSettingsShadowTopPresenterImpl get() {
        return newInstance();
    }
}
