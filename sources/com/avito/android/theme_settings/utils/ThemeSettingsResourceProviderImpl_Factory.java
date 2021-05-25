package com.avito.android.theme_settings.utils;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ThemeSettingsResourceProviderImpl_Factory implements Factory<ThemeSettingsResourceProviderImpl> {
    public final Provider<Context> a;

    public ThemeSettingsResourceProviderImpl_Factory(Provider<Context> provider) {
        this.a = provider;
    }

    public static ThemeSettingsResourceProviderImpl_Factory create(Provider<Context> provider) {
        return new ThemeSettingsResourceProviderImpl_Factory(provider);
    }

    public static ThemeSettingsResourceProviderImpl newInstance(Context context) {
        return new ThemeSettingsResourceProviderImpl(context);
    }

    @Override // javax.inject.Provider
    public ThemeSettingsResourceProviderImpl get() {
        return newInstance(this.a.get());
    }
}
