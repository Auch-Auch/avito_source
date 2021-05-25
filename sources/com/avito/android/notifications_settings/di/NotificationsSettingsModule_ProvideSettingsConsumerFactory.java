package com.avito.android.notifications_settings.di;

import com.jakewharton.rxrelay2.Relay;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import kotlin.Unit;
public final class NotificationsSettingsModule_ProvideSettingsConsumerFactory implements Factory<Relay<Unit>> {

    public static final class a {
        public static final NotificationsSettingsModule_ProvideSettingsConsumerFactory a = new NotificationsSettingsModule_ProvideSettingsConsumerFactory();
    }

    public static NotificationsSettingsModule_ProvideSettingsConsumerFactory create() {
        return a.a;
    }

    public static Relay<Unit> provideSettingsConsumer() {
        return (Relay) Preconditions.checkNotNullFromProvides(NotificationsSettingsModule.provideSettingsConsumer());
    }

    @Override // javax.inject.Provider
    public Relay<Unit> get() {
        return provideSettingsConsumer();
    }
}
