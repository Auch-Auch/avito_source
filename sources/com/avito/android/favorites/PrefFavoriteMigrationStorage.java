package com.avito.android.favorites;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.preferences.FavoritesContract;
import com.avito.android.util.preferences.Preferences;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/avito/android/favorites/PrefFavoriteMigrationStorage;", "Lcom/avito/android/favorites/FavoriteMigrationStorage;", "", "setFavoritesMigrated", "()V", "", "isFavoritesMigrated", "()Z", "Lcom/avito/android/util/preferences/Preferences;", AuthSource.SEND_ABUSE, "Lcom/avito/android/util/preferences/Preferences;", "prefUtils", "<init>", "(Lcom/avito/android/util/preferences/Preferences;)V", "favorites_release"}, k = 1, mv = {1, 4, 2})
public final class PrefFavoriteMigrationStorage implements FavoriteMigrationStorage {
    public final Preferences a;

    public PrefFavoriteMigrationStorage(@NotNull Preferences preferences) {
        Intrinsics.checkNotNullParameter(preferences, "prefUtils");
        this.a = preferences;
    }

    @Override // com.avito.android.favorites.FavoriteMigrationStorage
    public boolean isFavoritesMigrated() {
        return this.a.getBoolean(FavoritesContract.INSTANCE.getFAVORITE_TABLE_MIGRATED(), false);
    }

    @Override // com.avito.android.favorites.FavoriteMigrationStorage
    public void setFavoritesMigrated() {
        this.a.putBoolean(FavoritesContract.INSTANCE.getFAVORITE_TABLE_MIGRATED(), true);
    }
}
