package com.avito.android.messenger.channels.mvi.interactor;

import com.avito.android.account.AccountStateProvider;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ChannelsErrorInteractorImpl_Factory implements Factory<ChannelsErrorInteractorImpl> {
    public final Provider<AccountStateProvider> a;
    public final Provider<SchedulersFactory> b;

    public ChannelsErrorInteractorImpl_Factory(Provider<AccountStateProvider> provider, Provider<SchedulersFactory> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static ChannelsErrorInteractorImpl_Factory create(Provider<AccountStateProvider> provider, Provider<SchedulersFactory> provider2) {
        return new ChannelsErrorInteractorImpl_Factory(provider, provider2);
    }

    public static ChannelsErrorInteractorImpl newInstance(AccountStateProvider accountStateProvider, SchedulersFactory schedulersFactory) {
        return new ChannelsErrorInteractorImpl(accountStateProvider, schedulersFactory);
    }

    @Override // javax.inject.Provider
    public ChannelsErrorInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
