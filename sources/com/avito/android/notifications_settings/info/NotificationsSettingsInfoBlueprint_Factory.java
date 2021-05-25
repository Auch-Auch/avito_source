package com.avito.android.notifications_settings.info;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class NotificationsSettingsInfoBlueprint_Factory implements Factory<NotificationsSettingsInfoBlueprint> {
    public final Provider<NotificationsSettingsInfoPresenter> a;

    public NotificationsSettingsInfoBlueprint_Factory(Provider<NotificationsSettingsInfoPresenter> provider) {
        this.a = provider;
    }

    public static NotificationsSettingsInfoBlueprint_Factory create(Provider<NotificationsSettingsInfoPresenter> provider) {
        return new NotificationsSettingsInfoBlueprint_Factory(provider);
    }

    public static NotificationsSettingsInfoBlueprint newInstance(NotificationsSettingsInfoPresenter notificationsSettingsInfoPresenter) {
        return new NotificationsSettingsInfoBlueprint(notificationsSettingsInfoPresenter);
    }

    @Override // javax.inject.Provider
    public NotificationsSettingsInfoBlueprint get() {
        return newInstance(this.a.get());
    }
}
