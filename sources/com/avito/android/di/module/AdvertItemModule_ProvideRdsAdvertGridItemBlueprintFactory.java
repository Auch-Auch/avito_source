package com.avito.android.di.module;

import com.avito.android.connection_quality.connectivity.ConnectivityProvider;
import com.avito.android.serp.adapter.RdsAdvertGridItemBlueprint;
import com.avito.android.serp.adapter.RdsAdvertItemPresenter;
import com.avito.android.serp.adapter.SerpItemAbViewConfig;
import com.avito.android.server_time.TimeSource;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Locale;
import javax.inject.Provider;
public final class AdvertItemModule_ProvideRdsAdvertGridItemBlueprintFactory implements Factory<RdsAdvertGridItemBlueprint> {
    public final Provider<RdsAdvertItemPresenter> a;
    public final Provider<TimeSource> b;
    public final Provider<Locale> c;
    public final Provider<SerpItemAbViewConfig> d;
    public final Provider<ConnectivityProvider> e;

    public AdvertItemModule_ProvideRdsAdvertGridItemBlueprintFactory(Provider<RdsAdvertItemPresenter> provider, Provider<TimeSource> provider2, Provider<Locale> provider3, Provider<SerpItemAbViewConfig> provider4, Provider<ConnectivityProvider> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static AdvertItemModule_ProvideRdsAdvertGridItemBlueprintFactory create(Provider<RdsAdvertItemPresenter> provider, Provider<TimeSource> provider2, Provider<Locale> provider3, Provider<SerpItemAbViewConfig> provider4, Provider<ConnectivityProvider> provider5) {
        return new AdvertItemModule_ProvideRdsAdvertGridItemBlueprintFactory(provider, provider2, provider3, provider4, provider5);
    }

    public static RdsAdvertGridItemBlueprint provideRdsAdvertGridItemBlueprint(RdsAdvertItemPresenter rdsAdvertItemPresenter, TimeSource timeSource, Locale locale, SerpItemAbViewConfig serpItemAbViewConfig, ConnectivityProvider connectivityProvider) {
        return (RdsAdvertGridItemBlueprint) Preconditions.checkNotNullFromProvides(AdvertItemModule.provideRdsAdvertGridItemBlueprint(rdsAdvertItemPresenter, timeSource, locale, serpItemAbViewConfig, connectivityProvider));
    }

    @Override // javax.inject.Provider
    public RdsAdvertGridItemBlueprint get() {
        return provideRdsAdvertGridItemBlueprint(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
