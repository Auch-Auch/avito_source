package com.avito.android.remote.notification.deep_link;

import com.avito.android.analytics.Analytics;
import com.avito.android.notification_center.counter.NotificationCenterCounterMarker;
import com.avito.android.notification_center.push.NcPushClicksListener;
import com.avito.android.remote.notification.NotificationInteractor;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class NotificationDeepLinkPresenterImpl_Factory implements Factory<NotificationDeepLinkPresenterImpl> {
    public final Provider<Analytics> a;
    public final Provider<NcPushClicksListener> b;
    public final Provider<NotificationCenterCounterMarker> c;
    public final Provider<NotificationInteractor> d;
    public final Provider<NotificationDeepLinkRouter> e;

    public NotificationDeepLinkPresenterImpl_Factory(Provider<Analytics> provider, Provider<NcPushClicksListener> provider2, Provider<NotificationCenterCounterMarker> provider3, Provider<NotificationInteractor> provider4, Provider<NotificationDeepLinkRouter> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static NotificationDeepLinkPresenterImpl_Factory create(Provider<Analytics> provider, Provider<NcPushClicksListener> provider2, Provider<NotificationCenterCounterMarker> provider3, Provider<NotificationInteractor> provider4, Provider<NotificationDeepLinkRouter> provider5) {
        return new NotificationDeepLinkPresenterImpl_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static NotificationDeepLinkPresenterImpl newInstance(Analytics analytics, NcPushClicksListener ncPushClicksListener, NotificationCenterCounterMarker notificationCenterCounterMarker, NotificationInteractor notificationInteractor, NotificationDeepLinkRouter notificationDeepLinkRouter) {
        return new NotificationDeepLinkPresenterImpl(analytics, ncPushClicksListener, notificationCenterCounterMarker, notificationInteractor, notificationDeepLinkRouter);
    }

    @Override // javax.inject.Provider
    public NotificationDeepLinkPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
