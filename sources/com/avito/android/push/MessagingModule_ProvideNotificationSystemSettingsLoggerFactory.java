package com.avito.android.push;

import com.avito.android.analytics.Analytics;
import com.avito.android.notification_manager_provider.NotificationManagerProvider;
import com.avito.android.preferences.TokenStorage;
import com.avito.android.remote.notification.NotificationSystemSettingsLogger;
import com.avito.android.util.preferences.Preferences;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class MessagingModule_ProvideNotificationSystemSettingsLoggerFactory implements Factory<NotificationSystemSettingsLogger> {
    public final Provider<Analytics> a;
    public final Provider<TokenStorage> b;
    public final Provider<NotificationManagerProvider> c;
    public final Provider<Preferences> d;

    public MessagingModule_ProvideNotificationSystemSettingsLoggerFactory(Provider<Analytics> provider, Provider<TokenStorage> provider2, Provider<NotificationManagerProvider> provider3, Provider<Preferences> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static MessagingModule_ProvideNotificationSystemSettingsLoggerFactory create(Provider<Analytics> provider, Provider<TokenStorage> provider2, Provider<NotificationManagerProvider> provider3, Provider<Preferences> provider4) {
        return new MessagingModule_ProvideNotificationSystemSettingsLoggerFactory(provider, provider2, provider3, provider4);
    }

    public static NotificationSystemSettingsLogger provideNotificationSystemSettingsLogger(Analytics analytics, TokenStorage tokenStorage, NotificationManagerProvider notificationManagerProvider, Preferences preferences) {
        return (NotificationSystemSettingsLogger) Preconditions.checkNotNullFromProvides(MessagingModule.provideNotificationSystemSettingsLogger(analytics, tokenStorage, notificationManagerProvider, preferences));
    }

    @Override // javax.inject.Provider
    public NotificationSystemSettingsLogger get() {
        return provideNotificationSystemSettingsLogger(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
