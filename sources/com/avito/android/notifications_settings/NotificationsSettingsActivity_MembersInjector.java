package com.avito.android.notifications_settings;

import com.avito.android.analytics.Analytics;
import com.avito.android.notification_manager_provider.NotificationManagerProvider;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.jakewharton.rxrelay2.Relay;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
import kotlin.Unit;
public final class NotificationsSettingsActivity_MembersInjector implements MembersInjector<NotificationsSettingsActivity> {
    public final Provider<AdapterPresenter> a;
    public final Provider<Analytics> b;
    public final Provider<Relay<Unit>> c;
    public final Provider<ImplicitIntentFactory> d;
    public final Provider<ItemBinder> e;
    public final Provider<NotificationManagerProvider> f;
    public final Provider<NotificationsSettingsPresenter> g;

    public NotificationsSettingsActivity_MembersInjector(Provider<AdapterPresenter> provider, Provider<Analytics> provider2, Provider<Relay<Unit>> provider3, Provider<ImplicitIntentFactory> provider4, Provider<ItemBinder> provider5, Provider<NotificationManagerProvider> provider6, Provider<NotificationsSettingsPresenter> provider7) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
    }

    public static MembersInjector<NotificationsSettingsActivity> create(Provider<AdapterPresenter> provider, Provider<Analytics> provider2, Provider<Relay<Unit>> provider3, Provider<ImplicitIntentFactory> provider4, Provider<ItemBinder> provider5, Provider<NotificationManagerProvider> provider6, Provider<NotificationsSettingsPresenter> provider7) {
        return new NotificationsSettingsActivity_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    @InjectedFieldSignature("com.avito.android.notifications_settings.NotificationsSettingsActivity.adapterPresenter")
    public static void injectAdapterPresenter(NotificationsSettingsActivity notificationsSettingsActivity, AdapterPresenter adapterPresenter) {
        notificationsSettingsActivity.adapterPresenter = adapterPresenter;
    }

    @InjectedFieldSignature("com.avito.android.notifications_settings.NotificationsSettingsActivity.analytics")
    public static void injectAnalytics(NotificationsSettingsActivity notificationsSettingsActivity, Analytics analytics) {
        notificationsSettingsActivity.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.notifications_settings.NotificationsSettingsActivity.consumer")
    public static void injectConsumer(NotificationsSettingsActivity notificationsSettingsActivity, Relay<Unit> relay) {
        notificationsSettingsActivity.consumer = relay;
    }

    @InjectedFieldSignature("com.avito.android.notifications_settings.NotificationsSettingsActivity.implicitIntentFactory")
    public static void injectImplicitIntentFactory(NotificationsSettingsActivity notificationsSettingsActivity, ImplicitIntentFactory implicitIntentFactory) {
        notificationsSettingsActivity.implicitIntentFactory = implicitIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.notifications_settings.NotificationsSettingsActivity.itemBinder")
    public static void injectItemBinder(NotificationsSettingsActivity notificationsSettingsActivity, ItemBinder itemBinder) {
        notificationsSettingsActivity.itemBinder = itemBinder;
    }

    @InjectedFieldSignature("com.avito.android.notifications_settings.NotificationsSettingsActivity.notificationManagerProvider")
    public static void injectNotificationManagerProvider(NotificationsSettingsActivity notificationsSettingsActivity, NotificationManagerProvider notificationManagerProvider) {
        notificationsSettingsActivity.notificationManagerProvider = notificationManagerProvider;
    }

    @InjectedFieldSignature("com.avito.android.notifications_settings.NotificationsSettingsActivity.presenter")
    public static void injectPresenter(NotificationsSettingsActivity notificationsSettingsActivity, NotificationsSettingsPresenter notificationsSettingsPresenter) {
        notificationsSettingsActivity.presenter = notificationsSettingsPresenter;
    }

    public void injectMembers(NotificationsSettingsActivity notificationsSettingsActivity) {
        injectAdapterPresenter(notificationsSettingsActivity, this.a.get());
        injectAnalytics(notificationsSettingsActivity, this.b.get());
        injectConsumer(notificationsSettingsActivity, this.c.get());
        injectImplicitIntentFactory(notificationsSettingsActivity, this.d.get());
        injectItemBinder(notificationsSettingsActivity, this.e.get());
        injectNotificationManagerProvider(notificationsSettingsActivity, this.f.get());
        injectPresenter(notificationsSettingsActivity, this.g.get());
    }
}
