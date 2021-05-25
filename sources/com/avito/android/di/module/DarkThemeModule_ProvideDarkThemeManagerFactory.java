package com.avito.android.di.module;

import com.avito.android.lib.util.DarkThemeManager;
import com.avito.android.lib.util.DarkThemeManagerImpl;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class DarkThemeModule_ProvideDarkThemeManagerFactory implements Factory<DarkThemeManager> {
    public final Provider<DarkThemeManagerImpl.Storage> a;

    public DarkThemeModule_ProvideDarkThemeManagerFactory(Provider<DarkThemeManagerImpl.Storage> provider) {
        this.a = provider;
    }

    public static DarkThemeModule_ProvideDarkThemeManagerFactory create(Provider<DarkThemeManagerImpl.Storage> provider) {
        return new DarkThemeModule_ProvideDarkThemeManagerFactory(provider);
    }

    public static DarkThemeManager provideDarkThemeManager(DarkThemeManagerImpl.Storage storage) {
        return (DarkThemeManager) Preconditions.checkNotNullFromProvides(DarkThemeModule.provideDarkThemeManager(storage));
    }

    @Override // javax.inject.Provider
    public DarkThemeManager get() {
        return provideDarkThemeManager(this.a.get());
    }
}
