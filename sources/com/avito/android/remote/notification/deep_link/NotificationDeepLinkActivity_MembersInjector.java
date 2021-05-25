package com.avito.android.remote.notification.deep_link;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class NotificationDeepLinkActivity_MembersInjector implements MembersInjector<NotificationDeepLinkActivity> {
    public final Provider<ActivityIntentFactory> a;
    public final Provider<Analytics> b;
    public final Provider<DeepLinkIntentFactory> c;
    public final Provider<NotificationDeepLinkPresenter> d;

    public NotificationDeepLinkActivity_MembersInjector(Provider<ActivityIntentFactory> provider, Provider<Analytics> provider2, Provider<DeepLinkIntentFactory> provider3, Provider<NotificationDeepLinkPresenter> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static MembersInjector<NotificationDeepLinkActivity> create(Provider<ActivityIntentFactory> provider, Provider<Analytics> provider2, Provider<DeepLinkIntentFactory> provider3, Provider<NotificationDeepLinkPresenter> provider4) {
        return new NotificationDeepLinkActivity_MembersInjector(provider, provider2, provider3, provider4);
    }

    @InjectedFieldSignature("com.avito.android.remote.notification.deep_link.NotificationDeepLinkActivity.activityIntentFactory")
    public static void injectActivityIntentFactory(NotificationDeepLinkActivity notificationDeepLinkActivity, ActivityIntentFactory activityIntentFactory) {
        notificationDeepLinkActivity.activityIntentFactory = activityIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.remote.notification.deep_link.NotificationDeepLinkActivity.analytics")
    public static void injectAnalytics(NotificationDeepLinkActivity notificationDeepLinkActivity, Analytics analytics) {
        notificationDeepLinkActivity.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.remote.notification.deep_link.NotificationDeepLinkActivity.deepLinkIntentFactory")
    public static void injectDeepLinkIntentFactory(NotificationDeepLinkActivity notificationDeepLinkActivity, DeepLinkIntentFactory deepLinkIntentFactory) {
        notificationDeepLinkActivity.deepLinkIntentFactory = deepLinkIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.remote.notification.deep_link.NotificationDeepLinkActivity.presenter")
    public static void injectPresenter(NotificationDeepLinkActivity notificationDeepLinkActivity, NotificationDeepLinkPresenter notificationDeepLinkPresenter) {
        notificationDeepLinkActivity.presenter = notificationDeepLinkPresenter;
    }

    public void injectMembers(NotificationDeepLinkActivity notificationDeepLinkActivity) {
        injectActivityIntentFactory(notificationDeepLinkActivity, this.a.get());
        injectAnalytics(notificationDeepLinkActivity, this.b.get());
        injectDeepLinkIntentFactory(notificationDeepLinkActivity, this.c.get());
        injectPresenter(notificationDeepLinkActivity, this.d.get());
    }
}
