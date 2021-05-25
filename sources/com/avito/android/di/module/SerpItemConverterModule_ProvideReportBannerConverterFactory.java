package com.avito.android.di.module;

import android.content.res.Resources;
import com.avito.android.Features;
import com.avito.android.serp.adapter.promo_card.ReportBannerConverter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class SerpItemConverterModule_ProvideReportBannerConverterFactory implements Factory<ReportBannerConverter> {
    public final Provider<Resources> a;
    public final Provider<Features> b;

    public SerpItemConverterModule_ProvideReportBannerConverterFactory(Provider<Resources> provider, Provider<Features> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static SerpItemConverterModule_ProvideReportBannerConverterFactory create(Provider<Resources> provider, Provider<Features> provider2) {
        return new SerpItemConverterModule_ProvideReportBannerConverterFactory(provider, provider2);
    }

    public static ReportBannerConverter provideReportBannerConverter(Resources resources, Features features) {
        return (ReportBannerConverter) Preconditions.checkNotNullFromProvides(SerpItemConverterModule.provideReportBannerConverter(resources, features));
    }

    @Override // javax.inject.Provider
    public ReportBannerConverter get() {
        return provideReportBannerConverter(this.a.get(), this.b.get());
    }
}
