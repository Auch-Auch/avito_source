package com.avito.android.di;

import com.avito.android.account.AccountStateProvider;
import com.avito.android.common.CounterInteractor;
import com.avito.android.common.CounterLoader;
import com.avito.android.notification_manager_provider.NotificationManagerProvider;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class FavoriteSellersCoreModule_ProvideFavoritesCounterInteractorFactory implements Factory<CounterInteractor> {
    public final Provider<SchedulersFactory3> a;
    public final Provider<CounterLoader> b;
    public final Provider<AccountStateProvider> c;
    public final Provider<NotificationManagerProvider> d;

    public FavoriteSellersCoreModule_ProvideFavoritesCounterInteractorFactory(Provider<SchedulersFactory3> provider, Provider<CounterLoader> provider2, Provider<AccountStateProvider> provider3, Provider<NotificationManagerProvider> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static FavoriteSellersCoreModule_ProvideFavoritesCounterInteractorFactory create(Provider<SchedulersFactory3> provider, Provider<CounterLoader> provider2, Provider<AccountStateProvider> provider3, Provider<NotificationManagerProvider> provider4) {
        return new FavoriteSellersCoreModule_ProvideFavoritesCounterInteractorFactory(provider, provider2, provider3, provider4);
    }

    public static CounterInteractor provideFavoritesCounterInteractor(SchedulersFactory3 schedulersFactory3, CounterLoader counterLoader, AccountStateProvider accountStateProvider, NotificationManagerProvider notificationManagerProvider) {
        return (CounterInteractor) Preconditions.checkNotNullFromProvides(FavoriteSellersCoreModule.provideFavoritesCounterInteractor(schedulersFactory3, counterLoader, accountStateProvider, notificationManagerProvider));
    }

    @Override // javax.inject.Provider
    public CounterInteractor get() {
        return provideFavoritesCounterInteractor(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
