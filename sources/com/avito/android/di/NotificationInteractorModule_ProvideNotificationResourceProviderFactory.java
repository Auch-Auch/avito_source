package com.avito.android.di;

import android.app.Application;
import com.avito.android.remote.notification.NotificationResourceProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class NotificationInteractorModule_ProvideNotificationResourceProviderFactory implements Factory<NotificationResourceProvider> {
    public final NotificationInteractorModule a;
    public final Provider<Application> b;

    public NotificationInteractorModule_ProvideNotificationResourceProviderFactory(NotificationInteractorModule notificationInteractorModule, Provider<Application> provider) {
        this.a = notificationInteractorModule;
        this.b = provider;
    }

    public static NotificationInteractorModule_ProvideNotificationResourceProviderFactory create(NotificationInteractorModule notificationInteractorModule, Provider<Application> provider) {
        return new NotificationInteractorModule_ProvideNotificationResourceProviderFactory(notificationInteractorModule, provider);
    }

    public static NotificationResourceProvider provideNotificationResourceProvider(NotificationInteractorModule notificationInteractorModule, Application application) {
        return (NotificationResourceProvider) Preconditions.checkNotNullFromProvides(notificationInteractorModule.provideNotificationResourceProvider(application));
    }

    @Override // javax.inject.Provider
    public NotificationResourceProvider get() {
        return provideNotificationResourceProvider(this.a, this.b.get());
    }
}
