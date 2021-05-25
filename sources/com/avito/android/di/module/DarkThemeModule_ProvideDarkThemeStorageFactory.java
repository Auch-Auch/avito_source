package com.avito.android.di.module;

import com.avito.android.lib.util.DarkThemeManagerImpl;
import com.avito.android.util.preferences.Preferences;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class DarkThemeModule_ProvideDarkThemeStorageFactory implements Factory<DarkThemeManagerImpl.Storage> {
    public final Provider<Preferences> a;

    public DarkThemeModule_ProvideDarkThemeStorageFactory(Provider<Preferences> provider) {
        this.a = provider;
    }

    public static DarkThemeModule_ProvideDarkThemeStorageFactory create(Provider<Preferences> provider) {
        return new DarkThemeModule_ProvideDarkThemeStorageFactory(provider);
    }

    public static DarkThemeManagerImpl.Storage provideDarkThemeStorage(Preferences preferences) {
        return (DarkThemeManagerImpl.Storage) Preconditions.checkNotNullFromProvides(DarkThemeModule.provideDarkThemeStorage(preferences));
    }

    @Override // javax.inject.Provider
    public DarkThemeManagerImpl.Storage get() {
        return provideDarkThemeStorage(this.a.get());
    }
}
