package com.avito.android.messenger.service;

import com.avito.android.account.AccountStateProvider;
import com.avito.android.analytics.Analytics;
import com.avito.android.messenger.conversation.mvi.data.MessageRepoReader;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class OpenErrorTrackerImpl_Factory implements Factory<OpenErrorTrackerImpl> {
    public final Provider<AccountStateProvider> a;
    public final Provider<MessageRepoReader> b;
    public final Provider<Analytics> c;

    public OpenErrorTrackerImpl_Factory(Provider<AccountStateProvider> provider, Provider<MessageRepoReader> provider2, Provider<Analytics> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static OpenErrorTrackerImpl_Factory create(Provider<AccountStateProvider> provider, Provider<MessageRepoReader> provider2, Provider<Analytics> provider3) {
        return new OpenErrorTrackerImpl_Factory(provider, provider2, provider3);
    }

    public static OpenErrorTrackerImpl newInstance(AccountStateProvider accountStateProvider, MessageRepoReader messageRepoReader, Analytics analytics) {
        return new OpenErrorTrackerImpl(accountStateProvider, messageRepoReader, analytics);
    }

    @Override // javax.inject.Provider
    public OpenErrorTrackerImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
