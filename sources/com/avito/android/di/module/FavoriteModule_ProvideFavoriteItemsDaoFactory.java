package com.avito.android.di.module;

import com.avito.android.db.DbHelper;
import com.avito.android.db.favorites.FavoriteItemsDao;
import com.avito.android.deep_linking.DeepLinkFactory;
import com.google.gson.Gson;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class FavoriteModule_ProvideFavoriteItemsDaoFactory implements Factory<FavoriteItemsDao> {
    public final Provider<DbHelper> a;
    public final Provider<Gson> b;
    public final Provider<DeepLinkFactory> c;

    public FavoriteModule_ProvideFavoriteItemsDaoFactory(Provider<DbHelper> provider, Provider<Gson> provider2, Provider<DeepLinkFactory> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static FavoriteModule_ProvideFavoriteItemsDaoFactory create(Provider<DbHelper> provider, Provider<Gson> provider2, Provider<DeepLinkFactory> provider3) {
        return new FavoriteModule_ProvideFavoriteItemsDaoFactory(provider, provider2, provider3);
    }

    public static FavoriteItemsDao provideFavoriteItemsDao(DbHelper dbHelper, Gson gson, DeepLinkFactory deepLinkFactory) {
        return (FavoriteItemsDao) Preconditions.checkNotNullFromProvides(FavoriteModule.provideFavoriteItemsDao(dbHelper, gson, deepLinkFactory));
    }

    @Override // javax.inject.Provider
    public FavoriteItemsDao get() {
        return provideFavoriteItemsDao(this.a.get(), this.b.get(), this.c.get());
    }
}
