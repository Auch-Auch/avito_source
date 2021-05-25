package com.avito.android.notification_center.landing.share;

import com.avito.android.analytics.Analytics;
import com.avito.android.connection_quality.connectivity.ConnectivityProvider;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.ImplicitIntentFactory;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import java.util.Locale;
import javax.inject.Provider;
public final class NotificationCenterLandingShareActivity_MembersInjector implements MembersInjector<NotificationCenterLandingShareActivity> {
    public final Provider<Analytics> a;
    public final Provider<ImplicitIntentFactory> b;
    public final Provider<Locale> c;
    public final Provider<NotificationCenterLandingSharePresenter> d;
    public final Provider<TimeSource> e;
    public final Provider<ConnectivityProvider> f;

    public NotificationCenterLandingShareActivity_MembersInjector(Provider<Analytics> provider, Provider<ImplicitIntentFactory> provider2, Provider<Locale> provider3, Provider<NotificationCenterLandingSharePresenter> provider4, Provider<TimeSource> provider5, Provider<ConnectivityProvider> provider6) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
    }

    public static MembersInjector<NotificationCenterLandingShareActivity> create(Provider<Analytics> provider, Provider<ImplicitIntentFactory> provider2, Provider<Locale> provider3, Provider<NotificationCenterLandingSharePresenter> provider4, Provider<TimeSource> provider5, Provider<ConnectivityProvider> provider6) {
        return new NotificationCenterLandingShareActivity_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6);
    }

    @InjectedFieldSignature("com.avito.android.notification_center.landing.share.NotificationCenterLandingShareActivity.analytics")
    public static void injectAnalytics(NotificationCenterLandingShareActivity notificationCenterLandingShareActivity, Analytics analytics) {
        notificationCenterLandingShareActivity.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.notification_center.landing.share.NotificationCenterLandingShareActivity.connectivityProvider")
    public static void injectConnectivityProvider(NotificationCenterLandingShareActivity notificationCenterLandingShareActivity, ConnectivityProvider connectivityProvider) {
        notificationCenterLandingShareActivity.connectivityProvider = connectivityProvider;
    }

    @InjectedFieldSignature("com.avito.android.notification_center.landing.share.NotificationCenterLandingShareActivity.implicitIntentFactory")
    public static void injectImplicitIntentFactory(NotificationCenterLandingShareActivity notificationCenterLandingShareActivity, ImplicitIntentFactory implicitIntentFactory) {
        notificationCenterLandingShareActivity.implicitIntentFactory = implicitIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.notification_center.landing.share.NotificationCenterLandingShareActivity.locale")
    public static void injectLocale(NotificationCenterLandingShareActivity notificationCenterLandingShareActivity, Locale locale) {
        notificationCenterLandingShareActivity.locale = locale;
    }

    @InjectedFieldSignature("com.avito.android.notification_center.landing.share.NotificationCenterLandingShareActivity.presenter")
    public static void injectPresenter(NotificationCenterLandingShareActivity notificationCenterLandingShareActivity, NotificationCenterLandingSharePresenter notificationCenterLandingSharePresenter) {
        notificationCenterLandingShareActivity.presenter = notificationCenterLandingSharePresenter;
    }

    @InjectedFieldSignature("com.avito.android.notification_center.landing.share.NotificationCenterLandingShareActivity.timeSource")
    public static void injectTimeSource(NotificationCenterLandingShareActivity notificationCenterLandingShareActivity, TimeSource timeSource) {
        notificationCenterLandingShareActivity.timeSource = timeSource;
    }

    public void injectMembers(NotificationCenterLandingShareActivity notificationCenterLandingShareActivity) {
        injectAnalytics(notificationCenterLandingShareActivity, this.a.get());
        injectImplicitIntentFactory(notificationCenterLandingShareActivity, this.b.get());
        injectLocale(notificationCenterLandingShareActivity, this.c.get());
        injectPresenter(notificationCenterLandingShareActivity, this.d.get());
        injectTimeSource(notificationCenterLandingShareActivity, this.e.get());
        injectConnectivityProvider(notificationCenterLandingShareActivity, this.f.get());
    }
}
