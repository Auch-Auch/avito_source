package com.avito.android.notification_center.landing.unified;

import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class NotificationCenterLandingUnifiedActivity_MembersInjector implements MembersInjector<NotificationCenterLandingUnifiedActivity> {
    public final Provider<DeepLinkIntentFactory> a;
    public final Provider<NotificationCenterLandingUnifiedPresenter> b;
    public final Provider<ItemBinder> c;
    public final Provider<AdapterPresenter> d;
    public final Provider<Analytics> e;

    public NotificationCenterLandingUnifiedActivity_MembersInjector(Provider<DeepLinkIntentFactory> provider, Provider<NotificationCenterLandingUnifiedPresenter> provider2, Provider<ItemBinder> provider3, Provider<AdapterPresenter> provider4, Provider<Analytics> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static MembersInjector<NotificationCenterLandingUnifiedActivity> create(Provider<DeepLinkIntentFactory> provider, Provider<NotificationCenterLandingUnifiedPresenter> provider2, Provider<ItemBinder> provider3, Provider<AdapterPresenter> provider4, Provider<Analytics> provider5) {
        return new NotificationCenterLandingUnifiedActivity_MembersInjector(provider, provider2, provider3, provider4, provider5);
    }

    @InjectedFieldSignature("com.avito.android.notification_center.landing.unified.NotificationCenterLandingUnifiedActivity.adapterPresenter")
    public static void injectAdapterPresenter(NotificationCenterLandingUnifiedActivity notificationCenterLandingUnifiedActivity, AdapterPresenter adapterPresenter) {
        notificationCenterLandingUnifiedActivity.adapterPresenter = adapterPresenter;
    }

    @InjectedFieldSignature("com.avito.android.notification_center.landing.unified.NotificationCenterLandingUnifiedActivity.analytics")
    public static void injectAnalytics(NotificationCenterLandingUnifiedActivity notificationCenterLandingUnifiedActivity, Analytics analytics) {
        notificationCenterLandingUnifiedActivity.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.notification_center.landing.unified.NotificationCenterLandingUnifiedActivity.deepLinkIntentFactory")
    public static void injectDeepLinkIntentFactory(NotificationCenterLandingUnifiedActivity notificationCenterLandingUnifiedActivity, DeepLinkIntentFactory deepLinkIntentFactory) {
        notificationCenterLandingUnifiedActivity.deepLinkIntentFactory = deepLinkIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.notification_center.landing.unified.NotificationCenterLandingUnifiedActivity.itemBinder")
    public static void injectItemBinder(NotificationCenterLandingUnifiedActivity notificationCenterLandingUnifiedActivity, ItemBinder itemBinder) {
        notificationCenterLandingUnifiedActivity.itemBinder = itemBinder;
    }

    @InjectedFieldSignature("com.avito.android.notification_center.landing.unified.NotificationCenterLandingUnifiedActivity.presenter")
    public static void injectPresenter(NotificationCenterLandingUnifiedActivity notificationCenterLandingUnifiedActivity, NotificationCenterLandingUnifiedPresenter notificationCenterLandingUnifiedPresenter) {
        notificationCenterLandingUnifiedActivity.presenter = notificationCenterLandingUnifiedPresenter;
    }

    public void injectMembers(NotificationCenterLandingUnifiedActivity notificationCenterLandingUnifiedActivity) {
        injectDeepLinkIntentFactory(notificationCenterLandingUnifiedActivity, this.a.get());
        injectPresenter(notificationCenterLandingUnifiedActivity, this.b.get());
        injectItemBinder(notificationCenterLandingUnifiedActivity, this.c.get());
        injectAdapterPresenter(notificationCenterLandingUnifiedActivity, this.d.get());
        injectAnalytics(notificationCenterLandingUnifiedActivity, this.e.get());
    }
}
