package com.avito.android.di.module;

import com.avito.android.events.notifications_settings.NotificationSettingsChangeEvent;
import com.jakewharton.rxrelay3.PublishRelay;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class NotificationSettingsRelayModule_ProvideRelayFactory implements Factory<PublishRelay<NotificationSettingsChangeEvent>> {

    public static final class a {
        public static final NotificationSettingsRelayModule_ProvideRelayFactory a = new NotificationSettingsRelayModule_ProvideRelayFactory();
    }

    public static NotificationSettingsRelayModule_ProvideRelayFactory create() {
        return a.a;
    }

    public static PublishRelay<NotificationSettingsChangeEvent> provideRelay() {
        return (PublishRelay) Preconditions.checkNotNullFromProvides(NotificationSettingsRelayModule.provideRelay());
    }

    @Override // javax.inject.Provider
    public PublishRelay<NotificationSettingsChangeEvent> get() {
        return provideRelay();
    }
}
