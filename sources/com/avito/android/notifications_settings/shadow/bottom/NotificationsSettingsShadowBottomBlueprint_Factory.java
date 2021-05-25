package com.avito.android.notifications_settings.shadow.bottom;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class NotificationsSettingsShadowBottomBlueprint_Factory implements Factory<NotificationsSettingsShadowBottomBlueprint> {
    public final Provider<NotificationsSettingsShadowBottomPresenter> a;

    public NotificationsSettingsShadowBottomBlueprint_Factory(Provider<NotificationsSettingsShadowBottomPresenter> provider) {
        this.a = provider;
    }

    public static NotificationsSettingsShadowBottomBlueprint_Factory create(Provider<NotificationsSettingsShadowBottomPresenter> provider) {
        return new NotificationsSettingsShadowBottomBlueprint_Factory(provider);
    }

    public static NotificationsSettingsShadowBottomBlueprint newInstance(NotificationsSettingsShadowBottomPresenter notificationsSettingsShadowBottomPresenter) {
        return new NotificationsSettingsShadowBottomBlueprint(notificationsSettingsShadowBottomPresenter);
    }

    @Override // javax.inject.Provider
    public NotificationsSettingsShadowBottomBlueprint get() {
        return newInstance(this.a.get());
    }
}
