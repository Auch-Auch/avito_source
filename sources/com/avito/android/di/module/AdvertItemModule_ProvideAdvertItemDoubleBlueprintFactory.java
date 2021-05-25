package com.avito.android.di.module;

import com.avito.android.connection_quality.connectivity.ConnectivityProvider;
import com.avito.android.serp.adapter.AdvertGridItemPresenter;
import com.avito.android.serp.adapter.AdvertItemDoubleBlueprint;
import com.avito.android.serp.adapter.SerpItemAbViewConfig;
import com.avito.android.server_time.TimeSource;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Locale;
import javax.inject.Provider;
public final class AdvertItemModule_ProvideAdvertItemDoubleBlueprintFactory implements Factory<AdvertItemDoubleBlueprint> {
    public final Provider<AdvertGridItemPresenter> a;
    public final Provider<TimeSource> b;
    public final Provider<Locale> c;
    public final Provider<SerpItemAbViewConfig> d;
    public final Provider<ConnectivityProvider> e;

    public AdvertItemModule_ProvideAdvertItemDoubleBlueprintFactory(Provider<AdvertGridItemPresenter> provider, Provider<TimeSource> provider2, Provider<Locale> provider3, Provider<SerpItemAbViewConfig> provider4, Provider<ConnectivityProvider> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static AdvertItemModule_ProvideAdvertItemDoubleBlueprintFactory create(Provider<AdvertGridItemPresenter> provider, Provider<TimeSource> provider2, Provider<Locale> provider3, Provider<SerpItemAbViewConfig> provider4, Provider<ConnectivityProvider> provider5) {
        return new AdvertItemModule_ProvideAdvertItemDoubleBlueprintFactory(provider, provider2, provider3, provider4, provider5);
    }

    public static AdvertItemDoubleBlueprint provideAdvertItemDoubleBlueprint(AdvertGridItemPresenter advertGridItemPresenter, TimeSource timeSource, Locale locale, SerpItemAbViewConfig serpItemAbViewConfig, ConnectivityProvider connectivityProvider) {
        return (AdvertItemDoubleBlueprint) Preconditions.checkNotNullFromProvides(AdvertItemModule.provideAdvertItemDoubleBlueprint(advertGridItemPresenter, timeSource, locale, serpItemAbViewConfig, connectivityProvider));
    }

    @Override // javax.inject.Provider
    public AdvertItemDoubleBlueprint get() {
        return provideAdvertItemDoubleBlueprint(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
