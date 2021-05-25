package com.avito.android.messenger.conversation.mvi.sync;

import com.avito.android.Features;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.messenger.MessengerEntityConverter;
import com.avito.android.messenger.channels.mvi.data.UserRepo;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
import ru.avito.messenger.MessengerClient;
import ru.avito.messenger.api.AvitoMessengerApi;
public final class MissingUsersSyncAgentImpl_Factory implements Factory<MissingUsersSyncAgentImpl> {
    public final Provider<MessengerClient<AvitoMessengerApi>> a;
    public final Provider<MessengerEntityConverter> b;
    public final Provider<UserRepo> c;
    public final Provider<AccountStateProvider> d;
    public final Provider<Features> e;
    public final Provider<SchedulersFactory> f;

    public MissingUsersSyncAgentImpl_Factory(Provider<MessengerClient<AvitoMessengerApi>> provider, Provider<MessengerEntityConverter> provider2, Provider<UserRepo> provider3, Provider<AccountStateProvider> provider4, Provider<Features> provider5, Provider<SchedulersFactory> provider6) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
    }

    public static MissingUsersSyncAgentImpl_Factory create(Provider<MessengerClient<AvitoMessengerApi>> provider, Provider<MessengerEntityConverter> provider2, Provider<UserRepo> provider3, Provider<AccountStateProvider> provider4, Provider<Features> provider5, Provider<SchedulersFactory> provider6) {
        return new MissingUsersSyncAgentImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static MissingUsersSyncAgentImpl newInstance(MessengerClient<AvitoMessengerApi> messengerClient, MessengerEntityConverter messengerEntityConverter, UserRepo userRepo, AccountStateProvider accountStateProvider, Features features, SchedulersFactory schedulersFactory) {
        return new MissingUsersSyncAgentImpl(messengerClient, messengerEntityConverter, userRepo, accountStateProvider, features, schedulersFactory);
    }

    @Override // javax.inject.Provider
    public MissingUsersSyncAgentImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get());
    }
}
