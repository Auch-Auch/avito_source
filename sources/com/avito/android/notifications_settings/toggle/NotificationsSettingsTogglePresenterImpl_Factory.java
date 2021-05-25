package com.avito.android.notifications_settings.toggle;

import com.jakewharton.rxrelay2.Relay;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class NotificationsSettingsTogglePresenterImpl_Factory implements Factory<NotificationsSettingsTogglePresenterImpl> {
    public final Provider<Relay<NotificationsSettingsToggleItem>> a;

    public NotificationsSettingsTogglePresenterImpl_Factory(Provider<Relay<NotificationsSettingsToggleItem>> provider) {
        this.a = provider;
    }

    public static NotificationsSettingsTogglePresenterImpl_Factory create(Provider<Relay<NotificationsSettingsToggleItem>> provider) {
        return new NotificationsSettingsTogglePresenterImpl_Factory(provider);
    }

    public static NotificationsSettingsTogglePresenterImpl newInstance(Relay<NotificationsSettingsToggleItem> relay) {
        return new NotificationsSettingsTogglePresenterImpl(relay);
    }

    @Override // javax.inject.Provider
    public NotificationsSettingsTogglePresenterImpl get() {
        return newInstance(this.a.get());
    }
}
