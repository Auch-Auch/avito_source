package com.avito.android.location.di.module;

import com.avito.android.location.SavedLocationMigrationHelper;
import com.avito.android.util.preferences.Preferences;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PersistenceUserLocationModule_ProvideSavedLocationMigrationHelperFactory implements Factory<SavedLocationMigrationHelper> {
    public final PersistenceUserLocationModule a;
    public final Provider<Preferences> b;

    public PersistenceUserLocationModule_ProvideSavedLocationMigrationHelperFactory(PersistenceUserLocationModule persistenceUserLocationModule, Provider<Preferences> provider) {
        this.a = persistenceUserLocationModule;
        this.b = provider;
    }

    public static PersistenceUserLocationModule_ProvideSavedLocationMigrationHelperFactory create(PersistenceUserLocationModule persistenceUserLocationModule, Provider<Preferences> provider) {
        return new PersistenceUserLocationModule_ProvideSavedLocationMigrationHelperFactory(persistenceUserLocationModule, provider);
    }

    public static SavedLocationMigrationHelper provideSavedLocationMigrationHelper(PersistenceUserLocationModule persistenceUserLocationModule, Preferences preferences) {
        return (SavedLocationMigrationHelper) Preconditions.checkNotNullFromProvides(persistenceUserLocationModule.provideSavedLocationMigrationHelper(preferences));
    }

    @Override // javax.inject.Provider
    public SavedLocationMigrationHelper get() {
        return provideSavedLocationMigrationHelper(this.a, this.b.get());
    }
}
