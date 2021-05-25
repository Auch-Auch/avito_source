package com.avito.android.di;

import com.avito.android.remote.notification.NotificationBitmapInteractor;
import com.avito.android.util.DeviceMetrics;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class NotificationInteractorModule_ProvideNotificationBitmapInteractorFactory implements Factory<NotificationBitmapInteractor> {
    public final NotificationInteractorModule a;
    public final Provider<DeviceMetrics> b;
    public final Provider<SchedulersFactory> c;

    public NotificationInteractorModule_ProvideNotificationBitmapInteractorFactory(NotificationInteractorModule notificationInteractorModule, Provider<DeviceMetrics> provider, Provider<SchedulersFactory> provider2) {
        this.a = notificationInteractorModule;
        this.b = provider;
        this.c = provider2;
    }

    public static NotificationInteractorModule_ProvideNotificationBitmapInteractorFactory create(NotificationInteractorModule notificationInteractorModule, Provider<DeviceMetrics> provider, Provider<SchedulersFactory> provider2) {
        return new NotificationInteractorModule_ProvideNotificationBitmapInteractorFactory(notificationInteractorModule, provider, provider2);
    }

    public static NotificationBitmapInteractor provideNotificationBitmapInteractor(NotificationInteractorModule notificationInteractorModule, DeviceMetrics deviceMetrics, SchedulersFactory schedulersFactory) {
        return (NotificationBitmapInteractor) Preconditions.checkNotNullFromProvides(notificationInteractorModule.provideNotificationBitmapInteractor(deviceMetrics, schedulersFactory));
    }

    @Override // javax.inject.Provider
    public NotificationBitmapInteractor get() {
        return provideNotificationBitmapInteractor(this.a, this.b.get(), this.c.get());
    }
}
