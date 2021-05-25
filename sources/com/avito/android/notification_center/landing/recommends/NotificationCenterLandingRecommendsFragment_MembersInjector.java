package com.avito.android.notification_center.landing.recommends;

import com.avito.android.advert.viewed.ViewedAdvertsPresenter;
import com.avito.android.analytics.Analytics;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class NotificationCenterLandingRecommendsFragment_MembersInjector implements MembersInjector<NotificationCenterLandingRecommendsFragment> {
    public final Provider<AdapterPresenter> a;
    public final Provider<ItemBinder> b;
    public final Provider<NotificationCenterLandingRecommendsPresenter> c;
    public final Provider<ViewedAdvertsPresenter> d;
    public final Provider<Analytics> e;

    public NotificationCenterLandingRecommendsFragment_MembersInjector(Provider<AdapterPresenter> provider, Provider<ItemBinder> provider2, Provider<NotificationCenterLandingRecommendsPresenter> provider3, Provider<ViewedAdvertsPresenter> provider4, Provider<Analytics> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static MembersInjector<NotificationCenterLandingRecommendsFragment> create(Provider<AdapterPresenter> provider, Provider<ItemBinder> provider2, Provider<NotificationCenterLandingRecommendsPresenter> provider3, Provider<ViewedAdvertsPresenter> provider4, Provider<Analytics> provider5) {
        return new NotificationCenterLandingRecommendsFragment_MembersInjector(provider, provider2, provider3, provider4, provider5);
    }

    @InjectedFieldSignature("com.avito.android.notification_center.landing.recommends.NotificationCenterLandingRecommendsFragment.adapterPresenter")
    public static void injectAdapterPresenter(NotificationCenterLandingRecommendsFragment notificationCenterLandingRecommendsFragment, AdapterPresenter adapterPresenter) {
        notificationCenterLandingRecommendsFragment.adapterPresenter = adapterPresenter;
    }

    @InjectedFieldSignature("com.avito.android.notification_center.landing.recommends.NotificationCenterLandingRecommendsFragment.analytics")
    public static void injectAnalytics(NotificationCenterLandingRecommendsFragment notificationCenterLandingRecommendsFragment, Analytics analytics) {
        notificationCenterLandingRecommendsFragment.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.notification_center.landing.recommends.NotificationCenterLandingRecommendsFragment.itemBinder")
    public static void injectItemBinder(NotificationCenterLandingRecommendsFragment notificationCenterLandingRecommendsFragment, ItemBinder itemBinder) {
        notificationCenterLandingRecommendsFragment.itemBinder = itemBinder;
    }

    @InjectedFieldSignature("com.avito.android.notification_center.landing.recommends.NotificationCenterLandingRecommendsFragment.presenter")
    public static void injectPresenter(NotificationCenterLandingRecommendsFragment notificationCenterLandingRecommendsFragment, NotificationCenterLandingRecommendsPresenter notificationCenterLandingRecommendsPresenter) {
        notificationCenterLandingRecommendsFragment.presenter = notificationCenterLandingRecommendsPresenter;
    }

    @InjectedFieldSignature("com.avito.android.notification_center.landing.recommends.NotificationCenterLandingRecommendsFragment.viewedAdvertsPresenter")
    public static void injectViewedAdvertsPresenter(NotificationCenterLandingRecommendsFragment notificationCenterLandingRecommendsFragment, ViewedAdvertsPresenter viewedAdvertsPresenter) {
        notificationCenterLandingRecommendsFragment.viewedAdvertsPresenter = viewedAdvertsPresenter;
    }

    public void injectMembers(NotificationCenterLandingRecommendsFragment notificationCenterLandingRecommendsFragment) {
        injectAdapterPresenter(notificationCenterLandingRecommendsFragment, this.a.get());
        injectItemBinder(notificationCenterLandingRecommendsFragment, this.b.get());
        injectPresenter(notificationCenterLandingRecommendsFragment, this.c.get());
        injectViewedAdvertsPresenter(notificationCenterLandingRecommendsFragment, this.d.get());
        injectAnalytics(notificationCenterLandingRecommendsFragment, this.e.get());
    }
}
