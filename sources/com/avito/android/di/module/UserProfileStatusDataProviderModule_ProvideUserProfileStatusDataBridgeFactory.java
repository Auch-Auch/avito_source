package com.avito.android.di.module;

import android.content.Context;
import com.avito.android.Features;
import com.avito.android.account.AccountStorageInteractor;
import com.avito.android.common.CounterInteractor;
import com.avito.android.notification_center.counter.NotificationCenterCounterInteractor;
import com.avito.android.remote.notification.UnreadNotificationsInteractor;
import com.avito.android.search.subscriptions.sync.SearchSubscriptionSyncRunner;
import com.avito.android.ui.UserProfileStatusDataProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class UserProfileStatusDataProviderModule_ProvideUserProfileStatusDataBridgeFactory implements Factory<UserProfileStatusDataProvider> {
    public final Provider<AccountStorageInteractor> a;
    public final Provider<UnreadNotificationsInteractor> b;
    public final Provider<NotificationCenterCounterInteractor> c;
    public final Provider<CounterInteractor> d;
    public final Provider<CounterInteractor> e;
    public final Provider<SearchSubscriptionSyncRunner> f;
    public final Provider<Context> g;
    public final Provider<Features> h;

    public UserProfileStatusDataProviderModule_ProvideUserProfileStatusDataBridgeFactory(Provider<AccountStorageInteractor> provider, Provider<UnreadNotificationsInteractor> provider2, Provider<NotificationCenterCounterInteractor> provider3, Provider<CounterInteractor> provider4, Provider<CounterInteractor> provider5, Provider<SearchSubscriptionSyncRunner> provider6, Provider<Context> provider7, Provider<Features> provider8) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
        this.h = provider8;
    }

    public static UserProfileStatusDataProviderModule_ProvideUserProfileStatusDataBridgeFactory create(Provider<AccountStorageInteractor> provider, Provider<UnreadNotificationsInteractor> provider2, Provider<NotificationCenterCounterInteractor> provider3, Provider<CounterInteractor> provider4, Provider<CounterInteractor> provider5, Provider<SearchSubscriptionSyncRunner> provider6, Provider<Context> provider7, Provider<Features> provider8) {
        return new UserProfileStatusDataProviderModule_ProvideUserProfileStatusDataBridgeFactory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    public static UserProfileStatusDataProvider provideUserProfileStatusDataBridge(AccountStorageInteractor accountStorageInteractor, UnreadNotificationsInteractor unreadNotificationsInteractor, NotificationCenterCounterInteractor notificationCenterCounterInteractor, CounterInteractor counterInteractor, CounterInteractor counterInteractor2, SearchSubscriptionSyncRunner searchSubscriptionSyncRunner, Context context, Features features) {
        return (UserProfileStatusDataProvider) Preconditions.checkNotNullFromProvides(UserProfileStatusDataProviderModule.provideUserProfileStatusDataBridge(accountStorageInteractor, unreadNotificationsInteractor, notificationCenterCounterInteractor, counterInteractor, counterInteractor2, searchSubscriptionSyncRunner, context, features));
    }

    @Override // javax.inject.Provider
    public UserProfileStatusDataProvider get() {
        return provideUserProfileStatusDataBridge(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get());
    }
}
