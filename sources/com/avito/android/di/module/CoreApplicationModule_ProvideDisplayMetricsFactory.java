package com.avito.android.di.module;

import android.app.Application;
import android.util.DisplayMetrics;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class CoreApplicationModule_ProvideDisplayMetricsFactory implements Factory<DisplayMetrics> {
    public final CoreApplicationModule a;
    public final Provider<Application> b;

    public CoreApplicationModule_ProvideDisplayMetricsFactory(CoreApplicationModule coreApplicationModule, Provider<Application> provider) {
        this.a = coreApplicationModule;
        this.b = provider;
    }

    public static CoreApplicationModule_ProvideDisplayMetricsFactory create(CoreApplicationModule coreApplicationModule, Provider<Application> provider) {
        return new CoreApplicationModule_ProvideDisplayMetricsFactory(coreApplicationModule, provider);
    }

    public static DisplayMetrics provideDisplayMetrics(CoreApplicationModule coreApplicationModule, Application application) {
        return (DisplayMetrics) Preconditions.checkNotNullFromProvides(coreApplicationModule.provideDisplayMetrics(application));
    }

    @Override // javax.inject.Provider
    public DisplayMetrics get() {
        return provideDisplayMetrics(this.a, this.b.get());
    }
}
