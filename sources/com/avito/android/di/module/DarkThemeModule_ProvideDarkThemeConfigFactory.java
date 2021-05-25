package com.avito.android.di.module;

import com.avito.android.Features;
import com.avito.android.lib.util.DarkThemeConfig;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class DarkThemeModule_ProvideDarkThemeConfigFactory implements Factory<DarkThemeConfig> {
    public final Provider<Features> a;

    public DarkThemeModule_ProvideDarkThemeConfigFactory(Provider<Features> provider) {
        this.a = provider;
    }

    public static DarkThemeModule_ProvideDarkThemeConfigFactory create(Provider<Features> provider) {
        return new DarkThemeModule_ProvideDarkThemeConfigFactory(provider);
    }

    public static DarkThemeConfig provideDarkThemeConfig(Features features) {
        return (DarkThemeConfig) Preconditions.checkNotNullFromProvides(DarkThemeModule.provideDarkThemeConfig(features));
    }

    @Override // javax.inject.Provider
    public DarkThemeConfig get() {
        return provideDarkThemeConfig(this.a.get());
    }
}
