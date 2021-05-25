package com.avito.android.notifications_settings.shadow.top;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class NotificationsSettingsShadowTopBlueprint_Factory implements Factory<NotificationsSettingsShadowTopBlueprint> {
    public final Provider<NotificationsSettingsShadowTopPresenter> a;

    public NotificationsSettingsShadowTopBlueprint_Factory(Provider<NotificationsSettingsShadowTopPresenter> provider) {
        this.a = provider;
    }

    public static NotificationsSettingsShadowTopBlueprint_Factory create(Provider<NotificationsSettingsShadowTopPresenter> provider) {
        return new NotificationsSettingsShadowTopBlueprint_Factory(provider);
    }

    public static NotificationsSettingsShadowTopBlueprint newInstance(NotificationsSettingsShadowTopPresenter notificationsSettingsShadowTopPresenter) {
        return new NotificationsSettingsShadowTopBlueprint(notificationsSettingsShadowTopPresenter);
    }

    @Override // javax.inject.Provider
    public NotificationsSettingsShadowTopBlueprint get() {
        return newInstance(this.a.get());
    }
}
