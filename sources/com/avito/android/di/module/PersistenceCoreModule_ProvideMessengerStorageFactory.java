package com.avito.android.di.module;

import com.avito.android.preferences.MessengerStorage;
import com.avito.android.util.preferences.Preferences;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PersistenceCoreModule_ProvideMessengerStorageFactory implements Factory<MessengerStorage> {
    public final PersistenceCoreModule a;
    public final Provider<Preferences> b;

    public PersistenceCoreModule_ProvideMessengerStorageFactory(PersistenceCoreModule persistenceCoreModule, Provider<Preferences> provider) {
        this.a = persistenceCoreModule;
        this.b = provider;
    }

    public static PersistenceCoreModule_ProvideMessengerStorageFactory create(PersistenceCoreModule persistenceCoreModule, Provider<Preferences> provider) {
        return new PersistenceCoreModule_ProvideMessengerStorageFactory(persistenceCoreModule, provider);
    }

    public static MessengerStorage provideMessengerStorage(PersistenceCoreModule persistenceCoreModule, Preferences preferences) {
        return (MessengerStorage) Preconditions.checkNotNullFromProvides(persistenceCoreModule.provideMessengerStorage(preferences));
    }

    @Override // javax.inject.Provider
    public MessengerStorage get() {
        return provideMessengerStorage(this.a, this.b.get());
    }
}
