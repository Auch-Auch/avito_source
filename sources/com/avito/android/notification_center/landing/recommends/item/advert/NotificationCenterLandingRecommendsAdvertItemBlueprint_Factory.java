package com.avito.android.notification_center.landing.recommends.item.advert;

import com.avito.android.connection_quality.connectivity.ConnectivityProvider;
import com.avito.android.server_time.TimeSource;
import dagger.internal.Factory;
import java.util.Locale;
import javax.inject.Provider;
public final class NotificationCenterLandingRecommendsAdvertItemBlueprint_Factory implements Factory<NotificationCenterLandingRecommendsAdvertItemBlueprint> {
    public final Provider<NotificationCenterLandingRecommendsAdvertItemPresenter> a;
    public final Provider<TimeSource> b;
    public final Provider<Locale> c;
    public final Provider<ConnectivityProvider> d;

    public NotificationCenterLandingRecommendsAdvertItemBlueprint_Factory(Provider<NotificationCenterLandingRecommendsAdvertItemPresenter> provider, Provider<TimeSource> provider2, Provider<Locale> provider3, Provider<ConnectivityProvider> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static NotificationCenterLandingRecommendsAdvertItemBlueprint_Factory create(Provider<NotificationCenterLandingRecommendsAdvertItemPresenter> provider, Provider<TimeSource> provider2, Provider<Locale> provider3, Provider<ConnectivityProvider> provider4) {
        return new NotificationCenterLandingRecommendsAdvertItemBlueprint_Factory(provider, provider2, provider3, provider4);
    }

    public static NotificationCenterLandingRecommendsAdvertItemBlueprint newInstance(NotificationCenterLandingRecommendsAdvertItemPresenter notificationCenterLandingRecommendsAdvertItemPresenter, TimeSource timeSource, Locale locale, ConnectivityProvider connectivityProvider) {
        return new NotificationCenterLandingRecommendsAdvertItemBlueprint(notificationCenterLandingRecommendsAdvertItemPresenter, timeSource, locale, connectivityProvider);
    }

    @Override // javax.inject.Provider
    public NotificationCenterLandingRecommendsAdvertItemBlueprint get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
