package com.avito.android.theme_settings.viewmodel;

import com.avito.android.theme_settings.utils.ThemeSettingsResourceProvider;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ThemeSettingsConverterImpl_Factory implements Factory<ThemeSettingsConverterImpl> {
    public final Provider<ThemeSettingsResourceProvider> a;

    public ThemeSettingsConverterImpl_Factory(Provider<ThemeSettingsResourceProvider> provider) {
        this.a = provider;
    }

    public static ThemeSettingsConverterImpl_Factory create(Provider<ThemeSettingsResourceProvider> provider) {
        return new ThemeSettingsConverterImpl_Factory(provider);
    }

    public static ThemeSettingsConverterImpl newInstance(ThemeSettingsResourceProvider themeSettingsResourceProvider) {
        return new ThemeSettingsConverterImpl(themeSettingsResourceProvider);
    }

    @Override // javax.inject.Provider
    public ThemeSettingsConverterImpl get() {
        return newInstance(this.a.get());
    }
}
