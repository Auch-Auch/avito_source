package com.avito.android.location.di.module;

import com.avito.android.location.LocationInfoProvider;
import com.avito.android.location.SavedLocationMigrationHelper;
import com.avito.android.location.SavedLocationStorage;
import com.avito.android.util.preferences.Preferences;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PersistenceUserLocationModule_ProvideSavedLocationStorageFactory implements Factory<SavedLocationStorage> {
    public final PersistenceUserLocationModule a;
    public final Provider<Preferences> b;
    public final Provider<SavedLocationMigrationHelper> c;
    public final Provider<LocationInfoProvider> d;

    public PersistenceUserLocationModule_ProvideSavedLocationStorageFactory(PersistenceUserLocationModule persistenceUserLocationModule, Provider<Preferences> provider, Provider<SavedLocationMigrationHelper> provider2, Provider<LocationInfoProvider> provider3) {
        this.a = persistenceUserLocationModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
    }

    public static PersistenceUserLocationModule_ProvideSavedLocationStorageFactory create(PersistenceUserLocationModule persistenceUserLocationModule, Provider<Preferences> provider, Provider<SavedLocationMigrationHelper> provider2, Provider<LocationInfoProvider> provider3) {
        return new PersistenceUserLocationModule_ProvideSavedLocationStorageFactory(persistenceUserLocationModule, provider, provider2, provider3);
    }

    public static SavedLocationStorage provideSavedLocationStorage(PersistenceUserLocationModule persistenceUserLocationModule, Preferences preferences, SavedLocationMigrationHelper savedLocationMigrationHelper, LocationInfoProvider locationInfoProvider) {
        return (SavedLocationStorage) Preconditions.checkNotNullFromProvides(persistenceUserLocationModule.provideSavedLocationStorage(preferences, savedLocationMigrationHelper, locationInfoProvider));
    }

    @Override // javax.inject.Provider
    public SavedLocationStorage get() {
        return provideSavedLocationStorage(this.a, this.b.get(), this.c.get(), this.d.get());
    }
}
