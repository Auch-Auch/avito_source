package com.avito.android.similar_adverts.adapter;

import com.avito.android.connection_quality.connectivity.ConnectivityProvider;
import com.avito.android.serp.adapter.RdsAdvertItemPresenter;
import com.avito.android.serp.adapter.SerpItemAbViewConfig;
import com.avito.android.server_time.TimeSource;
import dagger.internal.Factory;
import java.util.Locale;
import javax.inject.Provider;
public final class SimilarAdvertBlueprintImpl_Factory implements Factory<SimilarAdvertBlueprintImpl> {
    public final Provider<RdsAdvertItemPresenter> a;
    public final Provider<TimeSource> b;
    public final Provider<Locale> c;
    public final Provider<SerpItemAbViewConfig> d;
    public final Provider<ConnectivityProvider> e;

    public SimilarAdvertBlueprintImpl_Factory(Provider<RdsAdvertItemPresenter> provider, Provider<TimeSource> provider2, Provider<Locale> provider3, Provider<SerpItemAbViewConfig> provider4, Provider<ConnectivityProvider> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static SimilarAdvertBlueprintImpl_Factory create(Provider<RdsAdvertItemPresenter> provider, Provider<TimeSource> provider2, Provider<Locale> provider3, Provider<SerpItemAbViewConfig> provider4, Provider<ConnectivityProvider> provider5) {
        return new SimilarAdvertBlueprintImpl_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static SimilarAdvertBlueprintImpl newInstance(RdsAdvertItemPresenter rdsAdvertItemPresenter, TimeSource timeSource, Locale locale, SerpItemAbViewConfig serpItemAbViewConfig, ConnectivityProvider connectivityProvider) {
        return new SimilarAdvertBlueprintImpl(rdsAdvertItemPresenter, timeSource, locale, serpItemAbViewConfig, connectivityProvider);
    }

    @Override // javax.inject.Provider
    public SimilarAdvertBlueprintImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
