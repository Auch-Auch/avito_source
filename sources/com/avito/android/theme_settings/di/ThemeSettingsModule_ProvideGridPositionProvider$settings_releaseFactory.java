package com.avito.android.theme_settings.di;

import com.avito.android.serp.adapter.SpannedGridPositionProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class ThemeSettingsModule_ProvideGridPositionProvider$settings_releaseFactory implements Factory<SpannedGridPositionProvider> {

    public static final class a {
        public static final ThemeSettingsModule_ProvideGridPositionProvider$settings_releaseFactory a = new ThemeSettingsModule_ProvideGridPositionProvider$settings_releaseFactory();
    }

    public static ThemeSettingsModule_ProvideGridPositionProvider$settings_releaseFactory create() {
        return a.a;
    }

    public static SpannedGridPositionProvider provideGridPositionProvider$settings_release() {
        return (SpannedGridPositionProvider) Preconditions.checkNotNullFromProvides(ThemeSettingsModule.provideGridPositionProvider$settings_release());
    }

    @Override // javax.inject.Provider
    public SpannedGridPositionProvider get() {
        return provideGridPositionProvider$settings_release();
    }
}
