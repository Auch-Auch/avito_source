package com.avito.android.di.module;

import com.avito.android.preferences.PrefVersionStorage;
import com.avito.android.preferences.VersionStorage;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PersistenceCoreModule_ProvideVersionStorageFactory implements Factory<VersionStorage> {
    public final PersistenceCoreModule a;
    public final Provider<PrefVersionStorage> b;

    public PersistenceCoreModule_ProvideVersionStorageFactory(PersistenceCoreModule persistenceCoreModule, Provider<PrefVersionStorage> provider) {
        this.a = persistenceCoreModule;
        this.b = provider;
    }

    public static PersistenceCoreModule_ProvideVersionStorageFactory create(PersistenceCoreModule persistenceCoreModule, Provider<PrefVersionStorage> provider) {
        return new PersistenceCoreModule_ProvideVersionStorageFactory(persistenceCoreModule, provider);
    }

    public static VersionStorage provideVersionStorage(PersistenceCoreModule persistenceCoreModule, PrefVersionStorage prefVersionStorage) {
        return (VersionStorage) Preconditions.checkNotNullFromProvides(persistenceCoreModule.provideVersionStorage(prefVersionStorage));
    }

    @Override // javax.inject.Provider
    public VersionStorage get() {
        return provideVersionStorage(this.a, this.b.get());
    }
}
