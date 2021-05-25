package com.avito.android.section.item;

import com.avito.android.connection_quality.connectivity.ConnectivityProvider;
import com.avito.android.serp.adapter.RdsAdvertItemPresenter;
import com.avito.android.serp.adapter.SerpItemAbViewConfig;
import com.avito.android.server_time.TimeSource;
import dagger.internal.Factory;
import java.util.Locale;
import javax.inject.Provider;
public final class ComplementaryAdvertItemBlueprintImpl_Factory implements Factory<ComplementaryAdvertItemBlueprintImpl> {
    public final Provider<RdsAdvertItemPresenter> a;
    public final Provider<TimeSource> b;
    public final Provider<Locale> c;
    public final Provider<SectionItemWidthProvider> d;
    public final Provider<SerpItemAbViewConfig> e;
    public final Provider<ConnectivityProvider> f;

    public ComplementaryAdvertItemBlueprintImpl_Factory(Provider<RdsAdvertItemPresenter> provider, Provider<TimeSource> provider2, Provider<Locale> provider3, Provider<SectionItemWidthProvider> provider4, Provider<SerpItemAbViewConfig> provider5, Provider<ConnectivityProvider> provider6) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
    }

    public static ComplementaryAdvertItemBlueprintImpl_Factory create(Provider<RdsAdvertItemPresenter> provider, Provider<TimeSource> provider2, Provider<Locale> provider3, Provider<SectionItemWidthProvider> provider4, Provider<SerpItemAbViewConfig> provider5, Provider<ConnectivityProvider> provider6) {
        return new ComplementaryAdvertItemBlueprintImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static ComplementaryAdvertItemBlueprintImpl newInstance(RdsAdvertItemPresenter rdsAdvertItemPresenter, TimeSource timeSource, Locale locale, SectionItemWidthProvider sectionItemWidthProvider, SerpItemAbViewConfig serpItemAbViewConfig, ConnectivityProvider connectivityProvider) {
        return new ComplementaryAdvertItemBlueprintImpl(rdsAdvertItemPresenter, timeSource, locale, sectionItemWidthProvider, serpItemAbViewConfig, connectivityProvider);
    }

    @Override // javax.inject.Provider
    public ComplementaryAdvertItemBlueprintImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get());
    }
}
