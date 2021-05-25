package com.avito.android.remote.notification;

import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class NotificationServiceInteractorImpl_Factory implements Factory<NotificationServiceInteractorImpl> {
    public final Provider<NotificationInteractor> a;
    public final Provider<Analytics> b;
    public final Provider<DeepLinkIntentFactory> c;

    public NotificationServiceInteractorImpl_Factory(Provider<NotificationInteractor> provider, Provider<Analytics> provider2, Provider<DeepLinkIntentFactory> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static NotificationServiceInteractorImpl_Factory create(Provider<NotificationInteractor> provider, Provider<Analytics> provider2, Provider<DeepLinkIntentFactory> provider3) {
        return new NotificationServiceInteractorImpl_Factory(provider, provider2, provider3);
    }

    public static NotificationServiceInteractorImpl newInstance(NotificationInteractor notificationInteractor, Analytics analytics, DeepLinkIntentFactory deepLinkIntentFactory) {
        return new NotificationServiceInteractorImpl(notificationInteractor, analytics, deepLinkIntentFactory);
    }

    @Override // javax.inject.Provider
    public NotificationServiceInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
