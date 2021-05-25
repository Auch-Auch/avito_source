package com.avito.android.di.module;

import com.avito.android.app.task.ApplicationBlockingStartupTask;
import com.avito.android.app.task.FavoritesMigrationTask;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.List;
import javax.inject.Provider;
public final class FavoritesTasksModule_ProvideFavoritesTasksFactory implements Factory<List<ApplicationBlockingStartupTask>> {
    public final Provider<FavoritesMigrationTask> a;

    public FavoritesTasksModule_ProvideFavoritesTasksFactory(Provider<FavoritesMigrationTask> provider) {
        this.a = provider;
    }

    public static FavoritesTasksModule_ProvideFavoritesTasksFactory create(Provider<FavoritesMigrationTask> provider) {
        return new FavoritesTasksModule_ProvideFavoritesTasksFactory(provider);
    }

    public static List<ApplicationBlockingStartupTask> provideFavoritesTasks(FavoritesMigrationTask favoritesMigrationTask) {
        return (List) Preconditions.checkNotNullFromProvides(FavoritesTasksModule.INSTANCE.provideFavoritesTasks(favoritesMigrationTask));
    }

    @Override // javax.inject.Provider
    public List<ApplicationBlockingStartupTask> get() {
        return provideFavoritesTasks(this.a.get());
    }
}
