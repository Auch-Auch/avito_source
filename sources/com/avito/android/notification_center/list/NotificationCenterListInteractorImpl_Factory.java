package com.avito.android.notification_center.list;

import com.avito.android.remote.NotificationsApi;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class NotificationCenterListInteractorImpl_Factory implements Factory<NotificationCenterListInteractorImpl> {
    public final Provider<NotificationsApi> a;
    public final Provider<SchedulersFactory> b;

    public NotificationCenterListInteractorImpl_Factory(Provider<NotificationsApi> provider, Provider<SchedulersFactory> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static NotificationCenterListInteractorImpl_Factory create(Provider<NotificationsApi> provider, Provider<SchedulersFactory> provider2) {
        return new NotificationCenterListInteractorImpl_Factory(provider, provider2);
    }

    public static NotificationCenterListInteractorImpl newInstance(NotificationsApi notificationsApi, SchedulersFactory schedulersFactory) {
        return new NotificationCenterListInteractorImpl(notificationsApi, schedulersFactory);
    }

    @Override // javax.inject.Provider
    public NotificationCenterListInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
