package com.avito.android.notification_center.landing.share;

import com.avito.android.remote.NotificationsApi;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class NotificationCenterLandingShareModule_ProvideInteractorFactory implements Factory<NotificationCenterLandingShareInteractor> {
    public final NotificationCenterLandingShareModule a;
    public final Provider<NotificationsApi> b;
    public final Provider<SchedulersFactory> c;

    public NotificationCenterLandingShareModule_ProvideInteractorFactory(NotificationCenterLandingShareModule notificationCenterLandingShareModule, Provider<NotificationsApi> provider, Provider<SchedulersFactory> provider2) {
        this.a = notificationCenterLandingShareModule;
        this.b = provider;
        this.c = provider2;
    }

    public static NotificationCenterLandingShareModule_ProvideInteractorFactory create(NotificationCenterLandingShareModule notificationCenterLandingShareModule, Provider<NotificationsApi> provider, Provider<SchedulersFactory> provider2) {
        return new NotificationCenterLandingShareModule_ProvideInteractorFactory(notificationCenterLandingShareModule, provider, provider2);
    }

    public static NotificationCenterLandingShareInteractor provideInteractor(NotificationCenterLandingShareModule notificationCenterLandingShareModule, NotificationsApi notificationsApi, SchedulersFactory schedulersFactory) {
        return (NotificationCenterLandingShareInteractor) Preconditions.checkNotNullFromProvides(notificationCenterLandingShareModule.provideInteractor(notificationsApi, schedulersFactory));
    }

    @Override // javax.inject.Provider
    public NotificationCenterLandingShareInteractor get() {
        return provideInteractor(this.a, this.b.get(), this.c.get());
    }
}
