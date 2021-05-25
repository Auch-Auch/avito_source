package com.avito.android.di.module;

import android.content.Context;
import com.avito.android.analytics.features.AvitoAnalyticFeatures;
import com.avito.android.enabler.TogglesStorage;
import com.avito.android.util.AvitoBuildInfo;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class AnalyticFeaturesModule_ProvideAnalyticFeaturesFactory implements Factory<AvitoAnalyticFeatures> {
    public final Provider<Context> a;
    public final Provider<AvitoBuildInfo> b;
    public final Provider<TogglesStorage> c;

    public AnalyticFeaturesModule_ProvideAnalyticFeaturesFactory(Provider<Context> provider, Provider<AvitoBuildInfo> provider2, Provider<TogglesStorage> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static AnalyticFeaturesModule_ProvideAnalyticFeaturesFactory create(Provider<Context> provider, Provider<AvitoBuildInfo> provider2, Provider<TogglesStorage> provider3) {
        return new AnalyticFeaturesModule_ProvideAnalyticFeaturesFactory(provider, provider2, provider3);
    }

    public static AvitoAnalyticFeatures provideAnalyticFeatures(Context context, AvitoBuildInfo avitoBuildInfo, TogglesStorage togglesStorage) {
        return (AvitoAnalyticFeatures) Preconditions.checkNotNullFromProvides(AnalyticFeaturesModule.provideAnalyticFeatures(context, avitoBuildInfo, togglesStorage));
    }

    @Override // javax.inject.Provider
    public AvitoAnalyticFeatures get() {
        return provideAnalyticFeatures(this.a.get(), this.b.get(), this.c.get());
    }
}
