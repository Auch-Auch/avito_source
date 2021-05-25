package com.avito.android.di.module;

import com.avito.android.db.DbHelper;
import com.avito.android.db.favorites.FavoritesSyncDao;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class FavoriteModule_ProvideFavoritesSyncDaoFactory implements Factory<FavoritesSyncDao> {
    public final Provider<DbHelper> a;

    public FavoriteModule_ProvideFavoritesSyncDaoFactory(Provider<DbHelper> provider) {
        this.a = provider;
    }

    public static FavoriteModule_ProvideFavoritesSyncDaoFactory create(Provider<DbHelper> provider) {
        return new FavoriteModule_ProvideFavoritesSyncDaoFactory(provider);
    }

    public static FavoritesSyncDao provideFavoritesSyncDao(DbHelper dbHelper) {
        return (FavoritesSyncDao) Preconditions.checkNotNullFromProvides(FavoriteModule.provideFavoritesSyncDao(dbHelper));
    }

    @Override // javax.inject.Provider
    public FavoritesSyncDao get() {
        return provideFavoritesSyncDao(this.a.get());
    }
}
