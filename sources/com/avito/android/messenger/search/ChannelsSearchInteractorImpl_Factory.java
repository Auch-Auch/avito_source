package com.avito.android.messenger.search;

import com.avito.android.account.AccountStateProvider;
import com.avito.android.analytics.Analytics;
import com.avito.android.messenger.MessengerEntityConverter;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
import ru.avito.messenger.MessengerClient;
import ru.avito.messenger.api.AvitoMessengerApi;
public final class ChannelsSearchInteractorImpl_Factory implements Factory<ChannelsSearchInteractorImpl> {
    public final Provider<AccountStateProvider> a;
    public final Provider<MessengerClient<AvitoMessengerApi>> b;
    public final Provider<MessengerEntityConverter> c;
    public final Provider<Analytics> d;
    public final Provider<SchedulersFactory> e;

    public ChannelsSearchInteractorImpl_Factory(Provider<AccountStateProvider> provider, Provider<MessengerClient<AvitoMessengerApi>> provider2, Provider<MessengerEntityConverter> provider3, Provider<Analytics> provider4, Provider<SchedulersFactory> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static ChannelsSearchInteractorImpl_Factory create(Provider<AccountStateProvider> provider, Provider<MessengerClient<AvitoMessengerApi>> provider2, Provider<MessengerEntityConverter> provider3, Provider<Analytics> provider4, Provider<SchedulersFactory> provider5) {
        return new ChannelsSearchInteractorImpl_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static ChannelsSearchInteractorImpl newInstance(AccountStateProvider accountStateProvider, MessengerClient<AvitoMessengerApi> messengerClient, MessengerEntityConverter messengerEntityConverter, Analytics analytics, SchedulersFactory schedulersFactory) {
        return new ChannelsSearchInteractorImpl(accountStateProvider, messengerClient, messengerEntityConverter, analytics, schedulersFactory);
    }

    @Override // javax.inject.Provider
    public ChannelsSearchInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
