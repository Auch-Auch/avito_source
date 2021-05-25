package com.avito.android.di.module;

import com.avito.android.connection_quality.connectivity.ConnectivityProvider;
import com.avito.android.serp.adapter.AdvertItemListBlueprint;
import com.avito.android.serp.adapter.AdvertListItemPresenter;
import com.avito.android.serp.adapter.SerpItemAbViewConfig;
import com.avito.android.server_time.TimeSource;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Locale;
import javax.inject.Provider;
public final class AdvertItemModule_ProvideAdvertItemListBlueprintFactory implements Factory<AdvertItemListBlueprint> {
    public final Provider<AdvertListItemPresenter> a;
    public final Provider<TimeSource> b;
    public final Provider<Locale> c;
    public final Provider<SerpItemAbViewConfig> d;
    public final Provider<ConnectivityProvider> e;

    public AdvertItemModule_ProvideAdvertItemListBlueprintFactory(Provider<AdvertListItemPresenter> provider, Provider<TimeSource> provider2, Provider<Locale> provider3, Provider<SerpItemAbViewConfig> provider4, Provider<ConnectivityProvider> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static AdvertItemModule_ProvideAdvertItemListBlueprintFactory create(Provider<AdvertListItemPresenter> provider, Provider<TimeSource> provider2, Provider<Locale> provider3, Provider<SerpItemAbViewConfig> provider4, Provider<ConnectivityProvider> provider5) {
        return new AdvertItemModule_ProvideAdvertItemListBlueprintFactory(provider, provider2, provider3, provider4, provider5);
    }

    public static AdvertItemListBlueprint provideAdvertItemListBlueprint(AdvertListItemPresenter advertListItemPresenter, TimeSource timeSource, Locale locale, SerpItemAbViewConfig serpItemAbViewConfig, ConnectivityProvider connectivityProvider) {
        return (AdvertItemListBlueprint) Preconditions.checkNotNullFromProvides(AdvertItemModule.INSTANCE.provideAdvertItemListBlueprint(advertListItemPresenter, timeSource, locale, serpItemAbViewConfig, connectivityProvider));
    }

    @Override // javax.inject.Provider
    public AdvertItemListBlueprint get() {
        return provideAdvertItemListBlueprint(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
