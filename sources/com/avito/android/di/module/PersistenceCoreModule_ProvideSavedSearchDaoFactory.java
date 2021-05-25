package com.avito.android.di.module;

import com.avito.android.db.DbHelper;
import com.avito.android.db.SavedSearchDao;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PersistenceCoreModule_ProvideSavedSearchDaoFactory implements Factory<SavedSearchDao> {
    public final PersistenceCoreModule a;
    public final Provider<DbHelper> b;

    public PersistenceCoreModule_ProvideSavedSearchDaoFactory(PersistenceCoreModule persistenceCoreModule, Provider<DbHelper> provider) {
        this.a = persistenceCoreModule;
        this.b = provider;
    }

    public static PersistenceCoreModule_ProvideSavedSearchDaoFactory create(PersistenceCoreModule persistenceCoreModule, Provider<DbHelper> provider) {
        return new PersistenceCoreModule_ProvideSavedSearchDaoFactory(persistenceCoreModule, provider);
    }

    public static SavedSearchDao provideSavedSearchDao(PersistenceCoreModule persistenceCoreModule, DbHelper dbHelper) {
        return (SavedSearchDao) Preconditions.checkNotNullFromProvides(persistenceCoreModule.provideSavedSearchDao(dbHelper));
    }

    @Override // javax.inject.Provider
    public SavedSearchDao get() {
        return provideSavedSearchDao(this.a, this.b.get());
    }
}
