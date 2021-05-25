package com.avito.android.favorites;

import dagger.internal.Factory;
public final class FavoritesListStorageImpl_Factory implements Factory<FavoritesListStorageImpl> {

    public static final class a {
        public static final FavoritesListStorageImpl_Factory a = new FavoritesListStorageImpl_Factory();
    }

    public static FavoritesListStorageImpl_Factory create() {
        return a.a;
    }

    public static FavoritesListStorageImpl newInstance() {
        return new FavoritesListStorageImpl();
    }

    @Override // javax.inject.Provider
    public FavoritesListStorageImpl get() {
        return newInstance();
    }
}
