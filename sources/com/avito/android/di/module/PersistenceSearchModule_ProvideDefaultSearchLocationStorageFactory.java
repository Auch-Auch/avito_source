package com.avito.android.di.module;

import com.avito.android.home.default_search_location.DefaultSearchLocationStorage;
import com.avito.android.util.preferences.Preferences;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PersistenceSearchModule_ProvideDefaultSearchLocationStorageFactory implements Factory<DefaultSearchLocationStorage> {
    public final Provider<Preferences> a;

    public PersistenceSearchModule_ProvideDefaultSearchLocationStorageFactory(Provider<Preferences> provider) {
        this.a = provider;
    }

    public static PersistenceSearchModule_ProvideDefaultSearchLocationStorageFactory create(Provider<Preferences> provider) {
        return new PersistenceSearchModule_ProvideDefaultSearchLocationStorageFactory(provider);
    }

    public static DefaultSearchLocationStorage provideDefaultSearchLocationStorage(Preferences preferences) {
        return (DefaultSearchLocationStorage) Preconditions.checkNotNullFromProvides(PersistenceSearchModule.provideDefaultSearchLocationStorage(preferences));
    }

    @Override // javax.inject.Provider
    public DefaultSearchLocationStorage get() {
        return provideDefaultSearchLocationStorage(this.a.get());
    }
}
