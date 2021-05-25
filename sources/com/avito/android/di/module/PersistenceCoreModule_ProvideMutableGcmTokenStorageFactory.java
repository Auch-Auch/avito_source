package com.avito.android.di.module;

import com.avito.android.preferences.MutableTokenStorage;
import com.avito.android.util.preferences.Preferences;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PersistenceCoreModule_ProvideMutableGcmTokenStorageFactory implements Factory<MutableTokenStorage> {
    public final PersistenceCoreModule a;
    public final Provider<Preferences> b;

    public PersistenceCoreModule_ProvideMutableGcmTokenStorageFactory(PersistenceCoreModule persistenceCoreModule, Provider<Preferences> provider) {
        this.a = persistenceCoreModule;
        this.b = provider;
    }

    public static PersistenceCoreModule_ProvideMutableGcmTokenStorageFactory create(PersistenceCoreModule persistenceCoreModule, Provider<Preferences> provider) {
        return new PersistenceCoreModule_ProvideMutableGcmTokenStorageFactory(persistenceCoreModule, provider);
    }

    public static MutableTokenStorage provideMutableGcmTokenStorage(PersistenceCoreModule persistenceCoreModule, Preferences preferences) {
        return (MutableTokenStorage) Preconditions.checkNotNullFromProvides(persistenceCoreModule.provideMutableGcmTokenStorage(preferences));
    }

    @Override // javax.inject.Provider
    public MutableTokenStorage get() {
        return provideMutableGcmTokenStorage(this.a, this.b.get());
    }
}
