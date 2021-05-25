package com.avito.android.advert_core.messenger;

import com.avito.android.account.AccountStateProvider;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
import ru.avito.messenger.api.AvitoMessengerApi;
public final class AdvertMessengerInteractorImpl_Factory implements Factory<AdvertMessengerInteractorImpl> {
    public final Provider<AvitoMessengerApi> a;
    public final Provider<AccountStateProvider> b;
    public final Provider<SchedulersFactory3> c;

    public AdvertMessengerInteractorImpl_Factory(Provider<AvitoMessengerApi> provider, Provider<AccountStateProvider> provider2, Provider<SchedulersFactory3> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static AdvertMessengerInteractorImpl_Factory create(Provider<AvitoMessengerApi> provider, Provider<AccountStateProvider> provider2, Provider<SchedulersFactory3> provider3) {
        return new AdvertMessengerInteractorImpl_Factory(provider, provider2, provider3);
    }

    public static AdvertMessengerInteractorImpl newInstance(AvitoMessengerApi avitoMessengerApi, AccountStateProvider accountStateProvider, SchedulersFactory3 schedulersFactory3) {
        return new AdvertMessengerInteractorImpl(avitoMessengerApi, accountStateProvider, schedulersFactory3);
    }

    @Override // javax.inject.Provider
    public AdvertMessengerInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
