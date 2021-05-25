package com.avito.android.di.module;

import com.avito.android.preferences.PrefVersionStorage;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.preferences.Preferences;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PersistenceCoreModule_ProvidePrefVersionStorageFactory implements Factory<PrefVersionStorage> {
    public final PersistenceCoreModule a;
    public final Provider<Preferences> b;
    public final Provider<BuildInfo> c;

    public PersistenceCoreModule_ProvidePrefVersionStorageFactory(PersistenceCoreModule persistenceCoreModule, Provider<Preferences> provider, Provider<BuildInfo> provider2) {
        this.a = persistenceCoreModule;
        this.b = provider;
        this.c = provider2;
    }

    public static PersistenceCoreModule_ProvidePrefVersionStorageFactory create(PersistenceCoreModule persistenceCoreModule, Provider<Preferences> provider, Provider<BuildInfo> provider2) {
        return new PersistenceCoreModule_ProvidePrefVersionStorageFactory(persistenceCoreModule, provider, provider2);
    }

    public static PrefVersionStorage providePrefVersionStorage(PersistenceCoreModule persistenceCoreModule, Preferences preferences, BuildInfo buildInfo) {
        return (PrefVersionStorage) Preconditions.checkNotNullFromProvides(persistenceCoreModule.providePrefVersionStorage(preferences, buildInfo));
    }

    @Override // javax.inject.Provider
    public PrefVersionStorage get() {
        return providePrefVersionStorage(this.a, this.b.get(), this.c.get());
    }
}
