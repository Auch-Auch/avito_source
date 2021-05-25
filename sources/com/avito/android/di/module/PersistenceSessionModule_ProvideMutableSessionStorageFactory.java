package com.avito.android.di.module;

import com.avito.android.preferences.MutableSessionStorage;
import com.avito.android.util.preferences.Preferences;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PersistenceSessionModule_ProvideMutableSessionStorageFactory implements Factory<MutableSessionStorage> {
    public final PersistenceSessionModule a;
    public final Provider<Preferences> b;

    public PersistenceSessionModule_ProvideMutableSessionStorageFactory(PersistenceSessionModule persistenceSessionModule, Provider<Preferences> provider) {
        this.a = persistenceSessionModule;
        this.b = provider;
    }

    public static PersistenceSessionModule_ProvideMutableSessionStorageFactory create(PersistenceSessionModule persistenceSessionModule, Provider<Preferences> provider) {
        return new PersistenceSessionModule_ProvideMutableSessionStorageFactory(persistenceSessionModule, provider);
    }

    public static MutableSessionStorage provideMutableSessionStorage(PersistenceSessionModule persistenceSessionModule, Preferences preferences) {
        return (MutableSessionStorage) Preconditions.checkNotNullFromProvides(persistenceSessionModule.provideMutableSessionStorage(preferences));
    }

    @Override // javax.inject.Provider
    public MutableSessionStorage get() {
        return provideMutableSessionStorage(this.a, this.b.get());
    }
}
