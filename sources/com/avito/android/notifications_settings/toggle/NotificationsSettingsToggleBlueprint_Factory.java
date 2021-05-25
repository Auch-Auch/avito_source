package com.avito.android.notifications_settings.toggle;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class NotificationsSettingsToggleBlueprint_Factory implements Factory<NotificationsSettingsToggleBlueprint> {
    public final Provider<NotificationsSettingsTogglePresenter> a;

    public NotificationsSettingsToggleBlueprint_Factory(Provider<NotificationsSettingsTogglePresenter> provider) {
        this.a = provider;
    }

    public static NotificationsSettingsToggleBlueprint_Factory create(Provider<NotificationsSettingsTogglePresenter> provider) {
        return new NotificationsSettingsToggleBlueprint_Factory(provider);
    }

    public static NotificationsSettingsToggleBlueprint newInstance(NotificationsSettingsTogglePresenter notificationsSettingsTogglePresenter) {
        return new NotificationsSettingsToggleBlueprint(notificationsSettingsTogglePresenter);
    }

    @Override // javax.inject.Provider
    public NotificationsSettingsToggleBlueprint get() {
        return newInstance(this.a.get());
    }
}
