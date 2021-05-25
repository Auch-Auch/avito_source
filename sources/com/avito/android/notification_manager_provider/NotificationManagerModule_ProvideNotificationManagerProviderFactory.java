package com.avito.android.notification_manager_provider;

import androidx.core.app.NotificationManagerCompat;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class NotificationManagerModule_ProvideNotificationManagerProviderFactory implements Factory<NotificationManagerProvider> {
    public final NotificationManagerModule a;
    public final Provider<NotificationManagerCompat> b;

    public NotificationManagerModule_ProvideNotificationManagerProviderFactory(NotificationManagerModule notificationManagerModule, Provider<NotificationManagerCompat> provider) {
        this.a = notificationManagerModule;
        this.b = provider;
    }

    public static NotificationManagerModule_ProvideNotificationManagerProviderFactory create(NotificationManagerModule notificationManagerModule, Provider<NotificationManagerCompat> provider) {
        return new NotificationManagerModule_ProvideNotificationManagerProviderFactory(notificationManagerModule, provider);
    }

    public static NotificationManagerProvider provideNotificationManagerProvider(NotificationManagerModule notificationManagerModule, NotificationManagerCompat notificationManagerCompat) {
        return (NotificationManagerProvider) Preconditions.checkNotNullFromProvides(notificationManagerModule.provideNotificationManagerProvider(notificationManagerCompat));
    }

    @Override // javax.inject.Provider
    public NotificationManagerProvider get() {
        return provideNotificationManagerProvider(this.a, this.b.get());
    }
}
