package com.avito.android.notification_center.landing.feedback;

import com.avito.android.remote.NotificationsApi;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class NotificationCenterLandingFeedbackInteractorImpl_Factory implements Factory<NotificationCenterLandingFeedbackInteractorImpl> {
    public final Provider<NotificationsApi> a;
    public final Provider<SchedulersFactory> b;

    public NotificationCenterLandingFeedbackInteractorImpl_Factory(Provider<NotificationsApi> provider, Provider<SchedulersFactory> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static NotificationCenterLandingFeedbackInteractorImpl_Factory create(Provider<NotificationsApi> provider, Provider<SchedulersFactory> provider2) {
        return new NotificationCenterLandingFeedbackInteractorImpl_Factory(provider, provider2);
    }

    public static NotificationCenterLandingFeedbackInteractorImpl newInstance(NotificationsApi notificationsApi, SchedulersFactory schedulersFactory) {
        return new NotificationCenterLandingFeedbackInteractorImpl(notificationsApi, schedulersFactory);
    }

    @Override // javax.inject.Provider
    public NotificationCenterLandingFeedbackInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
