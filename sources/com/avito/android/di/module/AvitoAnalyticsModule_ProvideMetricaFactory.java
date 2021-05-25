package com.avito.android.di.module;

import android.app.Application;
import com.avito.android.analytics.provider.metrica.Metrica;
import com.avito.android.util.BuildInfo;
import com.avito.android.version_conflict.ConfigStorage;
import dagger.internal.Factory;
import javax.inject.Provider;
import org.jetbrains.annotations.Nullable;
public final class AvitoAnalyticsModule_ProvideMetricaFactory implements Factory<Metrica> {
    public final AvitoAnalyticsModule a;
    public final Provider<Application> b;
    public final Provider<ConfigStorage> c;
    public final Provider<BuildInfo> d;

    public AvitoAnalyticsModule_ProvideMetricaFactory(AvitoAnalyticsModule avitoAnalyticsModule, Provider<Application> provider, Provider<ConfigStorage> provider2, Provider<BuildInfo> provider3) {
        this.a = avitoAnalyticsModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
    }

    public static AvitoAnalyticsModule_ProvideMetricaFactory create(AvitoAnalyticsModule avitoAnalyticsModule, Provider<Application> provider, Provider<ConfigStorage> provider2, Provider<BuildInfo> provider3) {
        return new AvitoAnalyticsModule_ProvideMetricaFactory(avitoAnalyticsModule, provider, provider2, provider3);
    }

    @Nullable
    public static Metrica provideMetrica(AvitoAnalyticsModule avitoAnalyticsModule, Application application, ConfigStorage configStorage, BuildInfo buildInfo) {
        return avitoAnalyticsModule.provideMetrica(application, configStorage, buildInfo);
    }

    @Override // javax.inject.Provider
    @Nullable
    public Metrica get() {
        return provideMetrica(this.a, this.b.get(), this.c.get(), this.d.get());
    }
}
