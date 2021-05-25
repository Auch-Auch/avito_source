package com.avito.android.notifications_settings.shadow.bottom;

import dagger.internal.Factory;
public final class NotificationsSettingsShadowBottomPresenterImpl_Factory implements Factory<NotificationsSettingsShadowBottomPresenterImpl> {

    public static final class a {
        public static final NotificationsSettingsShadowBottomPresenterImpl_Factory a = new NotificationsSettingsShadowBottomPresenterImpl_Factory();
    }

    public static NotificationsSettingsShadowBottomPresenterImpl_Factory create() {
        return a.a;
    }

    public static NotificationsSettingsShadowBottomPresenterImpl newInstance() {
        return new NotificationsSettingsShadowBottomPresenterImpl();
    }

    @Override // javax.inject.Provider
    public NotificationsSettingsShadowBottomPresenterImpl get() {
        return newInstance();
    }
}
