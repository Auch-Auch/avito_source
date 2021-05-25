package com.avito.android.notification_center.landing.main;

import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class NotificationCenterLandingMainActivity_MembersInjector implements MembersInjector<NotificationCenterLandingMainActivity> {
    public final Provider<DeepLinkIntentFactory> a;
    public final Provider<NotificationCenterLandingMainPresenter> b;
    public final Provider<Analytics> c;

    public NotificationCenterLandingMainActivity_MembersInjector(Provider<DeepLinkIntentFactory> provider, Provider<NotificationCenterLandingMainPresenter> provider2, Provider<Analytics> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static MembersInjector<NotificationCenterLandingMainActivity> create(Provider<DeepLinkIntentFactory> provider, Provider<NotificationCenterLandingMainPresenter> provider2, Provider<Analytics> provider3) {
        return new NotificationCenterLandingMainActivity_MembersInjector(provider, provider2, provider3);
    }

    @InjectedFieldSignature("com.avito.android.notification_center.landing.main.NotificationCenterLandingMainActivity.analytics")
    public static void injectAnalytics(NotificationCenterLandingMainActivity notificationCenterLandingMainActivity, Analytics analytics) {
        notificationCenterLandingMainActivity.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.notification_center.landing.main.NotificationCenterLandingMainActivity.deepLinkIntentFactory")
    public static void injectDeepLinkIntentFactory(NotificationCenterLandingMainActivity notificationCenterLandingMainActivity, DeepLinkIntentFactory deepLinkIntentFactory) {
        notificationCenterLandingMainActivity.deepLinkIntentFactory = deepLinkIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.notification_center.landing.main.NotificationCenterLandingMainActivity.presenter")
    public static void injectPresenter(NotificationCenterLandingMainActivity notificationCenterLandingMainActivity, NotificationCenterLandingMainPresenter notificationCenterLandingMainPresenter) {
        notificationCenterLandingMainActivity.presenter = notificationCenterLandingMainPresenter;
    }

    public void injectMembers(NotificationCenterLandingMainActivity notificationCenterLandingMainActivity) {
        injectDeepLinkIntentFactory(notificationCenterLandingMainActivity, this.a.get());
        injectPresenter(notificationCenterLandingMainActivity, this.b.get());
        injectAnalytics(notificationCenterLandingMainActivity, this.c.get());
    }
}
