package com.avito.android.di.module;

import com.avito.android.preferences.FingerprintStorage;
import com.avito.android.util.preferences.Preferences;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PersistenceFingerprintModule_ProvideFingerprintStorageFactory implements Factory<FingerprintStorage> {
    public final PersistenceFingerprintModule a;
    public final Provider<Preferences> b;

    public PersistenceFingerprintModule_ProvideFingerprintStorageFactory(PersistenceFingerprintModule persistenceFingerprintModule, Provider<Preferences> provider) {
        this.a = persistenceFingerprintModule;
        this.b = provider;
    }

    public static PersistenceFingerprintModule_ProvideFingerprintStorageFactory create(PersistenceFingerprintModule persistenceFingerprintModule, Provider<Preferences> provider) {
        return new PersistenceFingerprintModule_ProvideFingerprintStorageFactory(persistenceFingerprintModule, provider);
    }

    public static FingerprintStorage provideFingerprintStorage(PersistenceFingerprintModule persistenceFingerprintModule, Preferences preferences) {
        return (FingerprintStorage) Preconditions.checkNotNullFromProvides(persistenceFingerprintModule.provideFingerprintStorage(preferences));
    }

    @Override // javax.inject.Provider
    public FingerprintStorage get() {
        return provideFingerprintStorage(this.a, this.b.get());
    }
}
