package com.avito.android.messenger.map.search;

import com.avito.android.analytics.Analytics;
import com.avito.android.messenger.map.search.GeoSearchPresenter;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
import ru.avito.messenger.MessengerClient;
import ru.avito.messenger.api.AvitoMessengerApi;
public final class GeoSearchPresenterImpl_Factory implements Factory<GeoSearchPresenterImpl> {
    public final Provider<SchedulersFactory> a;
    public final Provider<GeoSearchInteractor> b;
    public final Provider<String> c;
    public final Provider<String> d;
    public final Provider<Analytics> e;
    public final Provider<String> f;
    public final Provider<GeoSearchPresenter.State> g;
    public final Provider<MessengerClient<AvitoMessengerApi>> h;

    public GeoSearchPresenterImpl_Factory(Provider<SchedulersFactory> provider, Provider<GeoSearchInteractor> provider2, Provider<String> provider3, Provider<String> provider4, Provider<Analytics> provider5, Provider<String> provider6, Provider<GeoSearchPresenter.State> provider7, Provider<MessengerClient<AvitoMessengerApi>> provider8) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
        this.h = provider8;
    }

    public static GeoSearchPresenterImpl_Factory create(Provider<SchedulersFactory> provider, Provider<GeoSearchInteractor> provider2, Provider<String> provider3, Provider<String> provider4, Provider<Analytics> provider5, Provider<String> provider6, Provider<GeoSearchPresenter.State> provider7, Provider<MessengerClient<AvitoMessengerApi>> provider8) {
        return new GeoSearchPresenterImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    public static GeoSearchPresenterImpl newInstance(SchedulersFactory schedulersFactory, GeoSearchInteractor geoSearchInteractor, String str, String str2, Analytics analytics, String str3, GeoSearchPresenter.State state, MessengerClient<AvitoMessengerApi> messengerClient) {
        return new GeoSearchPresenterImpl(schedulersFactory, geoSearchInteractor, str, str2, analytics, str3, state, messengerClient);
    }

    @Override // javax.inject.Provider
    public GeoSearchPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get());
    }
}
