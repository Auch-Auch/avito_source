package com.avito.android.notification_center.landing.main;

import com.avito.android.analytics.Analytics;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class NotificationCenterLandingMainPresenterImpl_Factory implements Factory<NotificationCenterLandingMainPresenterImpl> {
    public final Provider<String> a;
    public final Provider<NotificationCenterLandingMainInteractor> b;
    public final Provider<SchedulersFactory> c;
    public final Provider<Analytics> d;
    public final Provider<Kundle> e;

    public NotificationCenterLandingMainPresenterImpl_Factory(Provider<String> provider, Provider<NotificationCenterLandingMainInteractor> provider2, Provider<SchedulersFactory> provider3, Provider<Analytics> provider4, Provider<Kundle> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static NotificationCenterLandingMainPresenterImpl_Factory create(Provider<String> provider, Provider<NotificationCenterLandingMainInteractor> provider2, Provider<SchedulersFactory> provider3, Provider<Analytics> provider4, Provider<Kundle> provider5) {
        return new NotificationCenterLandingMainPresenterImpl_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static NotificationCenterLandingMainPresenterImpl newInstance(String str, NotificationCenterLandingMainInteractor notificationCenterLandingMainInteractor, SchedulersFactory schedulersFactory, Analytics analytics, Kundle kundle) {
        return new NotificationCenterLandingMainPresenterImpl(str, notificationCenterLandingMainInteractor, schedulersFactory, analytics, kundle);
    }

    @Override // javax.inject.Provider
    public NotificationCenterLandingMainPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
