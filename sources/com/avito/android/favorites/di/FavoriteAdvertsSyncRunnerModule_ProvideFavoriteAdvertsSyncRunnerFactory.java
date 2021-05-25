package com.avito.android.favorites.di;

import com.avito.android.favorites.FavoriteAdvertsSyncRunner;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class FavoriteAdvertsSyncRunnerModule_ProvideFavoriteAdvertsSyncRunnerFactory implements Factory<FavoriteAdvertsSyncRunner> {

    public static final class a {
        public static final FavoriteAdvertsSyncRunnerModule_ProvideFavoriteAdvertsSyncRunnerFactory a = new FavoriteAdvertsSyncRunnerModule_ProvideFavoriteAdvertsSyncRunnerFactory();
    }

    public static FavoriteAdvertsSyncRunnerModule_ProvideFavoriteAdvertsSyncRunnerFactory create() {
        return a.a;
    }

    public static FavoriteAdvertsSyncRunner provideFavoriteAdvertsSyncRunner() {
        return (FavoriteAdvertsSyncRunner) Preconditions.checkNotNullFromProvides(FavoriteAdvertsSyncRunnerModule.provideFavoriteAdvertsSyncRunner());
    }

    @Override // javax.inject.Provider
    public FavoriteAdvertsSyncRunner get() {
        return provideFavoriteAdvertsSyncRunner();
    }
}
