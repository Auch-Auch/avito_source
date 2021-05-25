package com.avito.android.notification_center.counter;

import com.avito.android.remote.NotificationsApi;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class NotificationCenterCounterModule_ProvideCounterFactory implements Factory<NotificationCenterCounter> {
    public final NotificationCenterCounterModule a;
    public final Provider<NotificationsApi> b;
    public final Provider<SchedulersFactory3> c;

    public NotificationCenterCounterModule_ProvideCounterFactory(NotificationCenterCounterModule notificationCenterCounterModule, Provider<NotificationsApi> provider, Provider<SchedulersFactory3> provider2) {
        this.a = notificationCenterCounterModule;
        this.b = provider;
        this.c = provider2;
    }

    public static NotificationCenterCounterModule_ProvideCounterFactory create(NotificationCenterCounterModule notificationCenterCounterModule, Provider<NotificationsApi> provider, Provider<SchedulersFactory3> provider2) {
        return new NotificationCenterCounterModule_ProvideCounterFactory(notificationCenterCounterModule, provider, provider2);
    }

    public static NotificationCenterCounter provideCounter(NotificationCenterCounterModule notificationCenterCounterModule, NotificationsApi notificationsApi, SchedulersFactory3 schedulersFactory3) {
        return (NotificationCenterCounter) Preconditions.checkNotNullFromProvides(notificationCenterCounterModule.provideCounter(notificationsApi, schedulersFactory3));
    }

    @Override // javax.inject.Provider
    public NotificationCenterCounter get() {
        return provideCounter(this.a, this.b.get(), this.c.get());
    }
}
