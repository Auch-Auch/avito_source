package com.avito.android.messenger.blacklist.mvi;

import com.avito.android.Features;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
import ru.avito.messenger.MessengerClient;
import ru.avito.messenger.api.AvitoMessengerApi;
public final class BlacklistInteractorImpl_Factory implements Factory<BlacklistInteractorImpl> {
    public final Provider<SchedulersFactory> a;
    public final Provider<Features> b;
    public final Provider<AccountStateProvider> c;
    public final Provider<MessengerClient<AvitoMessengerApi>> d;

    public BlacklistInteractorImpl_Factory(Provider<SchedulersFactory> provider, Provider<Features> provider2, Provider<AccountStateProvider> provider3, Provider<MessengerClient<AvitoMessengerApi>> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static BlacklistInteractorImpl_Factory create(Provider<SchedulersFactory> provider, Provider<Features> provider2, Provider<AccountStateProvider> provider3, Provider<MessengerClient<AvitoMessengerApi>> provider4) {
        return new BlacklistInteractorImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static BlacklistInteractorImpl newInstance(SchedulersFactory schedulersFactory, Features features, AccountStateProvider accountStateProvider, MessengerClient<AvitoMessengerApi> messengerClient) {
        return new BlacklistInteractorImpl(schedulersFactory, features, accountStateProvider, messengerClient);
    }

    @Override // javax.inject.Provider
    public BlacklistInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
