package com.avito.android.brandspace.items.adverts;

import com.avito.android.connection_quality.connectivity.ConnectivityProvider;
import com.avito.android.serp.adapter.SerpItemAbViewConfig;
import com.avito.android.server_time.TimeSource;
import dagger.internal.Factory;
import java.util.Locale;
import javax.inject.Provider;
public final class AdvertItemBlueprint_Factory implements Factory<AdvertItemBlueprint> {
    public final Provider<AdvertItemPresenter> a;
    public final Provider<TimeSource> b;
    public final Provider<Locale> c;
    public final Provider<SerpItemAbViewConfig> d;
    public final Provider<ConnectivityProvider> e;

    public AdvertItemBlueprint_Factory(Provider<AdvertItemPresenter> provider, Provider<TimeSource> provider2, Provider<Locale> provider3, Provider<SerpItemAbViewConfig> provider4, Provider<ConnectivityProvider> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static AdvertItemBlueprint_Factory create(Provider<AdvertItemPresenter> provider, Provider<TimeSource> provider2, Provider<Locale> provider3, Provider<SerpItemAbViewConfig> provider4, Provider<ConnectivityProvider> provider5) {
        return new AdvertItemBlueprint_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static AdvertItemBlueprint newInstance(AdvertItemPresenter advertItemPresenter, TimeSource timeSource, Locale locale, SerpItemAbViewConfig serpItemAbViewConfig, ConnectivityProvider connectivityProvider) {
        return new AdvertItemBlueprint(advertItemPresenter, timeSource, locale, serpItemAbViewConfig, connectivityProvider);
    }

    @Override // javax.inject.Provider
    public AdvertItemBlueprint get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
