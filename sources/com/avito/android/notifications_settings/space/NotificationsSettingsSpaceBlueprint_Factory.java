package com.avito.android.notifications_settings.space;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class NotificationsSettingsSpaceBlueprint_Factory implements Factory<NotificationsSettingsSpaceBlueprint> {
    public final Provider<NotificationsSettingsSpacePresenter> a;

    public NotificationsSettingsSpaceBlueprint_Factory(Provider<NotificationsSettingsSpacePresenter> provider) {
        this.a = provider;
    }

    public static NotificationsSettingsSpaceBlueprint_Factory create(Provider<NotificationsSettingsSpacePresenter> provider) {
        return new NotificationsSettingsSpaceBlueprint_Factory(provider);
    }

    public static NotificationsSettingsSpaceBlueprint newInstance(NotificationsSettingsSpacePresenter notificationsSettingsSpacePresenter) {
        return new NotificationsSettingsSpaceBlueprint(notificationsSettingsSpacePresenter);
    }

    @Override // javax.inject.Provider
    public NotificationsSettingsSpaceBlueprint get() {
        return newInstance(this.a.get());
    }
}
