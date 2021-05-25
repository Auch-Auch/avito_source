package com.avito.android.notification_center.landing.recommends;

import com.avito.android.remote.NotificationsApi;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class NotificationCenterLandingRecommendsInteractorImpl_Factory implements Factory<NotificationCenterLandingRecommendsInteractorImpl> {
    public final Provider<NotificationsApi> a;
    public final Provider<SchedulersFactory> b;

    public NotificationCenterLandingRecommendsInteractorImpl_Factory(Provider<NotificationsApi> provider, Provider<SchedulersFactory> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static NotificationCenterLandingRecommendsInteractorImpl_Factory create(Provider<NotificationsApi> provider, Provider<SchedulersFactory> provider2) {
        return new NotificationCenterLandingRecommendsInteractorImpl_Factory(provider, provider2);
    }

    public static NotificationCenterLandingRecommendsInteractorImpl newInstance(NotificationsApi notificationsApi, SchedulersFactory schedulersFactory) {
        return new NotificationCenterLandingRecommendsInteractorImpl(notificationsApi, schedulersFactory);
    }

    @Override // javax.inject.Provider
    public NotificationCenterLandingRecommendsInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
