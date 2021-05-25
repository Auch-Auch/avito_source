package com.avito.android.di.module;

import com.avito.android.profile.MutableProfileInfoStorage;
import com.avito.android.util.preferences.Preferences;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PersistenceProfileInfoModule_ProvideMutableProfileInfoStorageFactory implements Factory<MutableProfileInfoStorage> {
    public final PersistenceProfileInfoModule a;
    public final Provider<Preferences> b;

    public PersistenceProfileInfoModule_ProvideMutableProfileInfoStorageFactory(PersistenceProfileInfoModule persistenceProfileInfoModule, Provider<Preferences> provider) {
        this.a = persistenceProfileInfoModule;
        this.b = provider;
    }

    public static PersistenceProfileInfoModule_ProvideMutableProfileInfoStorageFactory create(PersistenceProfileInfoModule persistenceProfileInfoModule, Provider<Preferences> provider) {
        return new PersistenceProfileInfoModule_ProvideMutableProfileInfoStorageFactory(persistenceProfileInfoModule, provider);
    }

    public static MutableProfileInfoStorage provideMutableProfileInfoStorage(PersistenceProfileInfoModule persistenceProfileInfoModule, Preferences preferences) {
        return (MutableProfileInfoStorage) Preconditions.checkNotNullFromProvides(persistenceProfileInfoModule.provideMutableProfileInfoStorage(preferences));
    }

    @Override // javax.inject.Provider
    public MutableProfileInfoStorage get() {
        return provideMutableProfileInfoStorage(this.a, this.b.get());
    }
}
