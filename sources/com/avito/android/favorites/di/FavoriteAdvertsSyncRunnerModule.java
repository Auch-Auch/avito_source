package com.avito.android.favorites.di;

import com.avito.android.favorites.FavoriteAdvertsSyncRunner;
import com.avito.android.favorites.FavoriteAdvertsSyncRunnerImpl;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/favorites/di/FavoriteAdvertsSyncRunnerModule;", "", "Lcom/avito/android/favorites/FavoriteAdvertsSyncRunner;", "provideFavoriteAdvertsSyncRunner", "()Lcom/avito/android/favorites/FavoriteAdvertsSyncRunner;", "<init>", "()V", "favorite-core_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class FavoriteAdvertsSyncRunnerModule {
    @NotNull
    public static final FavoriteAdvertsSyncRunnerModule INSTANCE = new FavoriteAdvertsSyncRunnerModule();

    @Provides
    @JvmStatic
    @NotNull
    public static final FavoriteAdvertsSyncRunner provideFavoriteAdvertsSyncRunner() {
        return new FavoriteAdvertsSyncRunnerImpl();
    }
}
