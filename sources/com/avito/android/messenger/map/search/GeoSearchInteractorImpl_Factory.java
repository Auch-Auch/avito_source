package com.avito.android.messenger.map.search;

import com.avito.android.account.AccountStateProvider;
import com.avito.android.remote.model.messenger.geo.GeoPoint;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
import ru.avito.messenger.MessengerClient;
import ru.avito.messenger.api.AvitoMessengerApi;
public final class GeoSearchInteractorImpl_Factory implements Factory<GeoSearchInteractorImpl> {
    public final Provider<AccountStateProvider> a;
    public final Provider<String> b;
    public final Provider<GeoPoint> c;
    public final Provider<GeoPoint> d;
    public final Provider<MessengerClient<AvitoMessengerApi>> e;
    public final Provider<SchedulersFactory> f;

    public GeoSearchInteractorImpl_Factory(Provider<AccountStateProvider> provider, Provider<String> provider2, Provider<GeoPoint> provider3, Provider<GeoPoint> provider4, Provider<MessengerClient<AvitoMessengerApi>> provider5, Provider<SchedulersFactory> provider6) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
    }

    public static GeoSearchInteractorImpl_Factory create(Provider<AccountStateProvider> provider, Provider<String> provider2, Provider<GeoPoint> provider3, Provider<GeoPoint> provider4, Provider<MessengerClient<AvitoMessengerApi>> provider5, Provider<SchedulersFactory> provider6) {
        return new GeoSearchInteractorImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static GeoSearchInteractorImpl newInstance(AccountStateProvider accountStateProvider, String str, GeoPoint geoPoint, GeoPoint geoPoint2, MessengerClient<AvitoMessengerApi> messengerClient, SchedulersFactory schedulersFactory) {
        return new GeoSearchInteractorImpl(accountStateProvider, str, geoPoint, geoPoint2, messengerClient, schedulersFactory);
    }

    @Override // javax.inject.Provider
    public GeoSearchInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get());
    }
}
