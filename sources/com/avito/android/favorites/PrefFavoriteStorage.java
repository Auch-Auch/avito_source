package com.avito.android.favorites;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.preferences.Preference;
import com.avito.android.util.preferences.Preferences;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u00020\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/favorites/PrefFavoriteStorage;", "Lcom/avito/android/favorites/MutableFavoriteStorage;", "", "time", "", "saveFavoritesLastUpdateDate", "(J)V", "Lcom/avito/android/util/preferences/Preferences;", AuthSource.SEND_ABUSE, "Lcom/avito/android/util/preferences/Preferences;", "preferences", "getFavoritesLastUpdateDate", "()J", "favoritesLastUpdateDate", "<init>", "(Lcom/avito/android/util/preferences/Preferences;)V", "favorite-core_release"}, k = 1, mv = {1, 4, 2})
public final class PrefFavoriteStorage implements MutableFavoriteStorage {
    public final Preferences a;

    @Inject
    public PrefFavoriteStorage(@NotNull Preferences preferences) {
        Intrinsics.checkNotNullParameter(preferences, "preferences");
        this.a = preferences;
    }

    @Override // com.avito.android.favorites.FavoriteStorage
    public long getFavoritesLastUpdateDate() {
        return this.a.getLong(Preference.FAVORITES_LAST_UPDATE_DATE, 0);
    }

    @Override // com.avito.android.favorites.MutableFavoriteStorage
    public void saveFavoritesLastUpdateDate(long j) {
        this.a.putLong(Preference.FAVORITES_LAST_UPDATE_DATE, j);
    }
}
