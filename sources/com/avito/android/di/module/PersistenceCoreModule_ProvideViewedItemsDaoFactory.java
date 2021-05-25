package com.avito.android.di.module;

import com.avito.android.db.DbHelper;
import com.avito.android.db.viewed.ViewedAdvertsDao;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PersistenceCoreModule_ProvideViewedItemsDaoFactory implements Factory<ViewedAdvertsDao> {
    public final PersistenceCoreModule a;
    public final Provider<DbHelper> b;

    public PersistenceCoreModule_ProvideViewedItemsDaoFactory(PersistenceCoreModule persistenceCoreModule, Provider<DbHelper> provider) {
        this.a = persistenceCoreModule;
        this.b = provider;
    }

    public static PersistenceCoreModule_ProvideViewedItemsDaoFactory create(PersistenceCoreModule persistenceCoreModule, Provider<DbHelper> provider) {
        return new PersistenceCoreModule_ProvideViewedItemsDaoFactory(persistenceCoreModule, provider);
    }

    public static ViewedAdvertsDao provideViewedItemsDao(PersistenceCoreModule persistenceCoreModule, DbHelper dbHelper) {
        return (ViewedAdvertsDao) Preconditions.checkNotNullFromProvides(persistenceCoreModule.provideViewedItemsDao(dbHelper));
    }

    @Override // javax.inject.Provider
    public ViewedAdvertsDao get() {
        return provideViewedItemsDao(this.a, this.b.get());
    }
}
