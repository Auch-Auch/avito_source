package com.avito.android.common;

import com.avito.android.account.AccountStateProvider;
import com.avito.android.notification_manager_provider.NotificationManagerProvider;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class CounterInteractorImpl_Factory implements Factory<CounterInteractorImpl> {
    public final Provider<SchedulersFactory3> a;
    public final Provider<CounterLoader> b;
    public final Provider<AccountStateProvider> c;
    public final Provider<NotificationManagerProvider> d;

    public CounterInteractorImpl_Factory(Provider<SchedulersFactory3> provider, Provider<CounterLoader> provider2, Provider<AccountStateProvider> provider3, Provider<NotificationManagerProvider> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static CounterInteractorImpl_Factory create(Provider<SchedulersFactory3> provider, Provider<CounterLoader> provider2, Provider<AccountStateProvider> provider3, Provider<NotificationManagerProvider> provider4) {
        return new CounterInteractorImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static CounterInteractorImpl newInstance(SchedulersFactory3 schedulersFactory3, CounterLoader counterLoader, AccountStateProvider accountStateProvider, NotificationManagerProvider notificationManagerProvider) {
        return new CounterInteractorImpl(schedulersFactory3, counterLoader, accountStateProvider, notificationManagerProvider);
    }

    @Override // javax.inject.Provider
    public CounterInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
