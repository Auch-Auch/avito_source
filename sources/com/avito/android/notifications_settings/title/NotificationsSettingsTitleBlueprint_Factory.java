package com.avito.android.notifications_settings.title;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class NotificationsSettingsTitleBlueprint_Factory implements Factory<NotificationsSettingsTitleBlueprint> {
    public final Provider<NotificationsSettingsTitlePresenter> a;

    public NotificationsSettingsTitleBlueprint_Factory(Provider<NotificationsSettingsTitlePresenter> provider) {
        this.a = provider;
    }

    public static NotificationsSettingsTitleBlueprint_Factory create(Provider<NotificationsSettingsTitlePresenter> provider) {
        return new NotificationsSettingsTitleBlueprint_Factory(provider);
    }

    public static NotificationsSettingsTitleBlueprint newInstance(NotificationsSettingsTitlePresenter notificationsSettingsTitlePresenter) {
        return new NotificationsSettingsTitleBlueprint(notificationsSettingsTitlePresenter);
    }

    @Override // javax.inject.Provider
    public NotificationsSettingsTitleBlueprint get() {
        return newInstance(this.a.get());
    }
}
