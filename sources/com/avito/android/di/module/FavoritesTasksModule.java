package com.avito.android.di.module;

import com.avito.android.app.task.ApplicationBlockingStartupTask;
import com.avito.android.app.task.FavoritesMigrationTask;
import com.avito.android.db.FavoriteDao;
import com.avito.android.db.favorites.FavoritesSyncDao;
import com.avito.android.favorites.FavoriteMigrationStorage;
import dagger.Module;
import dagger.Provides;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.d;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0007J'\u0010\u0010\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0001¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/avito/android/di/module/FavoritesTasksModule;", "", "Lcom/avito/android/app/task/FavoritesMigrationTask;", "favoritesMigrationTask", "", "Lcom/avito/android/app/task/ApplicationBlockingStartupTask;", "provideFavoritesTasks", "(Lcom/avito/android/app/task/FavoritesMigrationTask;)Ljava/util/List;", "Lcom/avito/android/db/FavoriteDao;", "favoriteDao", "Lcom/avito/android/db/favorites/FavoritesSyncDao;", "favoritesSyncDao", "Lcom/avito/android/favorites/FavoriteMigrationStorage;", "migrationStorage", "provideFavoritesMigrationTask$favorites_release", "(Lcom/avito/android/db/FavoriteDao;Lcom/avito/android/db/favorites/FavoritesSyncDao;Lcom/avito/android/favorites/FavoriteMigrationStorage;)Lcom/avito/android/app/task/FavoritesMigrationTask;", "provideFavoritesMigrationTask", "<init>", "()V", "favorites_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {FavoriteMigrationStorageModule.class})
public final class FavoritesTasksModule {
    @NotNull
    public static final FavoritesTasksModule INSTANCE = new FavoritesTasksModule();

    @Provides
    @NotNull
    public final FavoritesMigrationTask provideFavoritesMigrationTask$favorites_release(@NotNull FavoriteDao favoriteDao, @NotNull FavoritesSyncDao favoritesSyncDao, @NotNull FavoriteMigrationStorage favoriteMigrationStorage) {
        Intrinsics.checkNotNullParameter(favoriteDao, "favoriteDao");
        Intrinsics.checkNotNullParameter(favoritesSyncDao, "favoritesSyncDao");
        Intrinsics.checkNotNullParameter(favoriteMigrationStorage, "migrationStorage");
        return new FavoritesMigrationTask(favoriteDao, favoritesSyncDao, favoriteMigrationStorage);
    }

    @Provides
    @NotNull
    @FavoritesTasks
    public final List<ApplicationBlockingStartupTask> provideFavoritesTasks(@NotNull FavoritesMigrationTask favoritesMigrationTask) {
        Intrinsics.checkNotNullParameter(favoritesMigrationTask, "favoritesMigrationTask");
        return d.listOf(favoritesMigrationTask);
    }
}
