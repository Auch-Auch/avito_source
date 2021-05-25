package com.avito.android.theme_settings.viewmodel;

import com.avito.android.analytics.Analytics;
import com.avito.android.lib.util.DarkThemeManager;
import com.avito.android.theme_settings.utils.ThemeSettingsResourceProvider;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ThemeSettingsViewModelFactory_Factory implements Factory<ThemeSettingsViewModelFactory> {
    public final Provider<DarkThemeManager> a;
    public final Provider<ThemeSettingsConverter> b;
    public final Provider<ThemeSettingsResourceProvider> c;
    public final Provider<Analytics> d;

    public ThemeSettingsViewModelFactory_Factory(Provider<DarkThemeManager> provider, Provider<ThemeSettingsConverter> provider2, Provider<ThemeSettingsResourceProvider> provider3, Provider<Analytics> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static ThemeSettingsViewModelFactory_Factory create(Provider<DarkThemeManager> provider, Provider<ThemeSettingsConverter> provider2, Provider<ThemeSettingsResourceProvider> provider3, Provider<Analytics> provider4) {
        return new ThemeSettingsViewModelFactory_Factory(provider, provider2, provider3, provider4);
    }

    public static ThemeSettingsViewModelFactory newInstance(DarkThemeManager darkThemeManager, ThemeSettingsConverter themeSettingsConverter, ThemeSettingsResourceProvider themeSettingsResourceProvider, Analytics analytics) {
        return new ThemeSettingsViewModelFactory(darkThemeManager, themeSettingsConverter, themeSettingsResourceProvider, analytics);
    }

    @Override // javax.inject.Provider
    public ThemeSettingsViewModelFactory get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
