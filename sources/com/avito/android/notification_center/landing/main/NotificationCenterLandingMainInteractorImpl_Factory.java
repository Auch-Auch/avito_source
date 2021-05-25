package com.avito.android.notification_center.landing.main;

import com.avito.android.remote.NotificationsApi;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class NotificationCenterLandingMainInteractorImpl_Factory implements Factory<NotificationCenterLandingMainInteractorImpl> {
    public final Provider<NotificationsApi> a;
    public final Provider<SchedulersFactory> b;

    public NotificationCenterLandingMainInteractorImpl_Factory(Provider<NotificationsApi> provider, Provider<SchedulersFactory> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static NotificationCenterLandingMainInteractorImpl_Factory create(Provider<NotificationsApi> provider, Provider<SchedulersFactory> provider2) {
        return new NotificationCenterLandingMainInteractorImpl_Factory(provider, provider2);
    }

    public static NotificationCenterLandingMainInteractorImpl newInstance(NotificationsApi notificationsApi, SchedulersFactory schedulersFactory) {
        return new NotificationCenterLandingMainInteractorImpl(notificationsApi, schedulersFactory);
    }

    @Override // javax.inject.Provider
    public NotificationCenterLandingMainInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
