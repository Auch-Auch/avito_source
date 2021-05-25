package com.avito.android.di.module;

import com.avito.android.preferences.TokenStorage;
import com.avito.android.util.preferences.Preferences;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PersistenceCoreModule_ProvideGcmTokenStorageFactory implements Factory<TokenStorage> {
    public final PersistenceCoreModule a;
    public final Provider<Preferences> b;

    public PersistenceCoreModule_ProvideGcmTokenStorageFactory(PersistenceCoreModule persistenceCoreModule, Provider<Preferences> provider) {
        this.a = persistenceCoreModule;
        this.b = provider;
    }

    public static PersistenceCoreModule_ProvideGcmTokenStorageFactory create(PersistenceCoreModule persistenceCoreModule, Provider<Preferences> provider) {
        return new PersistenceCoreModule_ProvideGcmTokenStorageFactory(persistenceCoreModule, provider);
    }

    public static TokenStorage provideGcmTokenStorage(PersistenceCoreModule persistenceCoreModule, Preferences preferences) {
        return (TokenStorage) Preconditions.checkNotNullFromProvides(persistenceCoreModule.provideGcmTokenStorage(preferences));
    }

    @Override // javax.inject.Provider
    public TokenStorage get() {
        return provideGcmTokenStorage(this.a, this.b.get());
    }
}
