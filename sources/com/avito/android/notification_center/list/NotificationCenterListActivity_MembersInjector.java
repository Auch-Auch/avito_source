package com.avito.android.notification_center.list;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.notification_center.list.NotificationCenterListView;
import com.avito.android.ui.adapter.AppendingListener;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class NotificationCenterListActivity_MembersInjector implements MembersInjector<NotificationCenterListActivity> {
    public final Provider<ActivityIntentFactory> a;
    public final Provider<AdapterPresenter> b;
    public final Provider<AppendingListener> c;
    public final Provider<Analytics> d;
    public final Provider<NotificationCenterListView.Callback> e;
    public final Provider<DeepLinkIntentFactory> f;
    public final Provider<ItemBinder> g;
    public final Provider<NotificationCenterListPresenter> h;

    public NotificationCenterListActivity_MembersInjector(Provider<ActivityIntentFactory> provider, Provider<AdapterPresenter> provider2, Provider<AppendingListener> provider3, Provider<Analytics> provider4, Provider<NotificationCenterListView.Callback> provider5, Provider<DeepLinkIntentFactory> provider6, Provider<ItemBinder> provider7, Provider<NotificationCenterListPresenter> provider8) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
        this.h = provider8;
    }

    public static MembersInjector<NotificationCenterListActivity> create(Provider<ActivityIntentFactory> provider, Provider<AdapterPresenter> provider2, Provider<AppendingListener> provider3, Provider<Analytics> provider4, Provider<NotificationCenterListView.Callback> provider5, Provider<DeepLinkIntentFactory> provider6, Provider<ItemBinder> provider7, Provider<NotificationCenterListPresenter> provider8) {
        return new NotificationCenterListActivity_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    @InjectedFieldSignature("com.avito.android.notification_center.list.NotificationCenterListActivity.activityIntentFactory")
    public static void injectActivityIntentFactory(NotificationCenterListActivity notificationCenterListActivity, ActivityIntentFactory activityIntentFactory) {
        notificationCenterListActivity.activityIntentFactory = activityIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.notification_center.list.NotificationCenterListActivity.adapterPresenter")
    public static void injectAdapterPresenter(NotificationCenterListActivity notificationCenterListActivity, AdapterPresenter adapterPresenter) {
        notificationCenterListActivity.adapterPresenter = adapterPresenter;
    }

    @InjectedFieldSignature("com.avito.android.notification_center.list.NotificationCenterListActivity.analytics")
    public static void injectAnalytics(NotificationCenterListActivity notificationCenterListActivity, Analytics analytics) {
        notificationCenterListActivity.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.notification_center.list.NotificationCenterListActivity.appendingListener")
    public static void injectAppendingListener(NotificationCenterListActivity notificationCenterListActivity, AppendingListener appendingListener) {
        notificationCenterListActivity.appendingListener = appendingListener;
    }

    @InjectedFieldSignature("com.avito.android.notification_center.list.NotificationCenterListActivity.callback")
    public static void injectCallback(NotificationCenterListActivity notificationCenterListActivity, NotificationCenterListView.Callback callback) {
        notificationCenterListActivity.callback = callback;
    }

    @InjectedFieldSignature("com.avito.android.notification_center.list.NotificationCenterListActivity.deepLinkIntentFactory")
    public static void injectDeepLinkIntentFactory(NotificationCenterListActivity notificationCenterListActivity, DeepLinkIntentFactory deepLinkIntentFactory) {
        notificationCenterListActivity.deepLinkIntentFactory = deepLinkIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.notification_center.list.NotificationCenterListActivity.itemBinder")
    public static void injectItemBinder(NotificationCenterListActivity notificationCenterListActivity, ItemBinder itemBinder) {
        notificationCenterListActivity.itemBinder = itemBinder;
    }

    @InjectedFieldSignature("com.avito.android.notification_center.list.NotificationCenterListActivity.presenter")
    public static void injectPresenter(NotificationCenterListActivity notificationCenterListActivity, NotificationCenterListPresenter notificationCenterListPresenter) {
        notificationCenterListActivity.presenter = notificationCenterListPresenter;
    }

    public void injectMembers(NotificationCenterListActivity notificationCenterListActivity) {
        injectActivityIntentFactory(notificationCenterListActivity, this.a.get());
        injectAdapterPresenter(notificationCenterListActivity, this.b.get());
        injectAppendingListener(notificationCenterListActivity, this.c.get());
        injectAnalytics(notificationCenterListActivity, this.d.get());
        injectCallback(notificationCenterListActivity, this.e.get());
        injectDeepLinkIntentFactory(notificationCenterListActivity, this.f.get());
        injectItemBinder(notificationCenterListActivity, this.g.get());
        injectPresenter(notificationCenterListActivity, this.h.get());
    }
}
