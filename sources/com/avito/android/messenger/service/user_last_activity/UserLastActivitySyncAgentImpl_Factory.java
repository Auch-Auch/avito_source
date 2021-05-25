package com.avito.android.messenger.service.user_last_activity;

import com.avito.android.Features;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.messenger.channels.mvi.data.UserRepo;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
import ru.avito.messenger.MessengerClient;
import ru.avito.messenger.api.AvitoMessengerApi;
public final class UserLastActivitySyncAgentImpl_Factory implements Factory<UserLastActivitySyncAgentImpl> {
    public final Provider<AccountStateProvider> a;
    public final Provider<MessengerClient<AvitoMessengerApi>> b;
    public final Provider<UserRepo> c;
    public final Provider<TimeSource> d;
    public final Provider<Features> e;
    public final Provider<SchedulersFactory> f;

    public UserLastActivitySyncAgentImpl_Factory(Provider<AccountStateProvider> provider, Provider<MessengerClient<AvitoMessengerApi>> provider2, Provider<UserRepo> provider3, Provider<TimeSource> provider4, Provider<Features> provider5, Provider<SchedulersFactory> provider6) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
    }

    public static UserLastActivitySyncAgentImpl_Factory create(Provider<AccountStateProvider> provider, Provider<MessengerClient<AvitoMessengerApi>> provider2, Provider<UserRepo> provider3, Provider<TimeSource> provider4, Provider<Features> provider5, Provider<SchedulersFactory> provider6) {
        return new UserLastActivitySyncAgentImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static UserLastActivitySyncAgentImpl newInstance(AccountStateProvider accountStateProvider, MessengerClient<AvitoMessengerApi> messengerClient, UserRepo userRepo, TimeSource timeSource, Features features, SchedulersFactory schedulersFactory) {
        return new UserLastActivitySyncAgentImpl(accountStateProvider, messengerClient, userRepo, timeSource, features, schedulersFactory);
    }

    @Override // javax.inject.Provider
    public UserLastActivitySyncAgentImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get());
    }
}
