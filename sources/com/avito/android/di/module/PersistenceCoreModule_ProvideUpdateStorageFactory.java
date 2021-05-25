package com.avito.android.di.module;

import com.avito.android.preferences.PrefVersionStorage;
import com.avito.android.preferences.UpdateStorage;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PersistenceCoreModule_ProvideUpdateStorageFactory implements Factory<UpdateStorage> {
    public final PersistenceCoreModule a;
    public final Provider<PrefVersionStorage> b;

    public PersistenceCoreModule_ProvideUpdateStorageFactory(PersistenceCoreModule persistenceCoreModule, Provider<PrefVersionStorage> provider) {
        this.a = persistenceCoreModule;
        this.b = provider;
    }

    public static PersistenceCoreModule_ProvideUpdateStorageFactory create(PersistenceCoreModule persistenceCoreModule, Provider<PrefVersionStorage> provider) {
        return new PersistenceCoreModule_ProvideUpdateStorageFactory(persistenceCoreModule, provider);
    }

    public static UpdateStorage provideUpdateStorage(PersistenceCoreModule persistenceCoreModule, PrefVersionStorage prefVersionStorage) {
        return (UpdateStorage) Preconditions.checkNotNullFromProvides(persistenceCoreModule.provideUpdateStorage(prefVersionStorage));
    }

    @Override // javax.inject.Provider
    public UpdateStorage get() {
        return provideUpdateStorage(this.a, this.b.get());
    }
}
