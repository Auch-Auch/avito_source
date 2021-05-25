package com.avito.android.di;

import android.app.Application;
import androidx.core.app.NotificationManagerCompat;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class NotificationInteractorModule_ProvideNotificationManagerFactory implements Factory<NotificationManagerCompat> {
    public final NotificationInteractorModule a;
    public final Provider<Application> b;

    public NotificationInteractorModule_ProvideNotificationManagerFactory(NotificationInteractorModule notificationInteractorModule, Provider<Application> provider) {
        this.a = notificationInteractorModule;
        this.b = provider;
    }

    public static NotificationInteractorModule_ProvideNotificationManagerFactory create(NotificationInteractorModule notificationInteractorModule, Provider<Application> provider) {
        return new NotificationInteractorModule_ProvideNotificationManagerFactory(notificationInteractorModule, provider);
    }

    public static NotificationManagerCompat provideNotificationManager(NotificationInteractorModule notificationInteractorModule, Application application) {
        return (NotificationManagerCompat) Preconditions.checkNotNullFromProvides(notificationInteractorModule.provideNotificationManager(application));
    }

    @Override // javax.inject.Provider
    public NotificationManagerCompat get() {
        return provideNotificationManager(this.a, this.b.get());
    }
}
