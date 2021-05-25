package com.avito.android.di.module;

import android.content.Context;
import com.avito.android.Features;
import com.avito.android.analytics.features.AvitoAnalyticFeatures;
import com.avito.android.util.AvitoBuildInfo;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class BuildVariantFeaturesModule_ProvideFeaturesFactory implements Factory<Features> {
    public final BuildVariantFeaturesModule a;
    public final Provider<Context> b;
    public final Provider<AvitoBuildInfo> c;
    public final Provider<AvitoAnalyticFeatures> d;

    public BuildVariantFeaturesModule_ProvideFeaturesFactory(BuildVariantFeaturesModule buildVariantFeaturesModule, Provider<Context> provider, Provider<AvitoBuildInfo> provider2, Provider<AvitoAnalyticFeatures> provider3) {
        this.a = buildVariantFeaturesModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
    }

    public static BuildVariantFeaturesModule_ProvideFeaturesFactory create(BuildVariantFeaturesModule buildVariantFeaturesModule, Provider<Context> provider, Provider<AvitoBuildInfo> provider2, Provider<AvitoAnalyticFeatures> provider3) {
        return new BuildVariantFeaturesModule_ProvideFeaturesFactory(buildVariantFeaturesModule, provider, provider2, provider3);
    }

    public static Features provideFeatures(BuildVariantFeaturesModule buildVariantFeaturesModule, Context context, AvitoBuildInfo avitoBuildInfo, AvitoAnalyticFeatures avitoAnalyticFeatures) {
        return (Features) Preconditions.checkNotNullFromProvides(buildVariantFeaturesModule.provideFeatures(context, avitoBuildInfo, avitoAnalyticFeatures));
    }

    @Override // javax.inject.Provider
    public Features get() {
        return provideFeatures(this.a, this.b.get(), this.c.get(), this.d.get());
    }
}
