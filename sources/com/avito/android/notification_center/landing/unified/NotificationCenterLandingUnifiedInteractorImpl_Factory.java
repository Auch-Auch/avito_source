package com.avito.android.notification_center.landing.unified;

import com.avito.android.remote.NotificationsApi;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class NotificationCenterLandingUnifiedInteractorImpl_Factory implements Factory<NotificationCenterLandingUnifiedInteractorImpl> {
    public final Provider<NotificationsApi> a;
    public final Provider<SchedulersFactory> b;

    public NotificationCenterLandingUnifiedInteractorImpl_Factory(Provider<NotificationsApi> provider, Provider<SchedulersFactory> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static NotificationCenterLandingUnifiedInteractorImpl_Factory create(Provider<NotificationsApi> provider, Provider<SchedulersFactory> provider2) {
        return new NotificationCenterLandingUnifiedInteractorImpl_Factory(provider, provider2);
    }

    public static NotificationCenterLandingUnifiedInteractorImpl newInstance(NotificationsApi notificationsApi, SchedulersFactory schedulersFactory) {
        return new NotificationCenterLandingUnifiedInteractorImpl(notificationsApi, schedulersFactory);
    }

    @Override // javax.inject.Provider
    public NotificationCenterLandingUnifiedInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
