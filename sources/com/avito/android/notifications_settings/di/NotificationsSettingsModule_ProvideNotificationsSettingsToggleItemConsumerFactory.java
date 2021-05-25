package com.avito.android.notifications_settings.di;

import com.avito.android.notifications_settings.toggle.NotificationsSettingsToggleItem;
import com.jakewharton.rxrelay2.Relay;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class NotificationsSettingsModule_ProvideNotificationsSettingsToggleItemConsumerFactory implements Factory<Relay<NotificationsSettingsToggleItem>> {

    public static final class a {
        public static final NotificationsSettingsModule_ProvideNotificationsSettingsToggleItemConsumerFactory a = new NotificationsSettingsModule_ProvideNotificationsSettingsToggleItemConsumerFactory();
    }

    public static NotificationsSettingsModule_ProvideNotificationsSettingsToggleItemConsumerFactory create() {
        return a.a;
    }

    public static Relay<NotificationsSettingsToggleItem> provideNotificationsSettingsToggleItemConsumer() {
        return (Relay) Preconditions.checkNotNullFromProvides(NotificationsSettingsModule.provideNotificationsSettingsToggleItemConsumer());
    }

    @Override // javax.inject.Provider
    public Relay<NotificationsSettingsToggleItem> get() {
        return provideNotificationsSettingsToggleItemConsumer();
    }
}
