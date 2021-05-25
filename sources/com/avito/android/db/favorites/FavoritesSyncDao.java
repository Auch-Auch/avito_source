package com.avito.android.db.favorites;

import com.google.android.gms.analytics.ecommerce.ProductAction;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0006\u0010\u0007J)\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\n2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\bH&¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u0004H&¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\u0010\u001a\u00020\u000f2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\u0004H&¢\u0006\u0004\b\u0010\u0010\u0012J\u001d\u0010\u0013\u001a\u00020\u000f2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\bH&¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0015\u0010\u0016J'\u0010\u0015\u001a\u00020\u000f2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\u0004H&¢\u0006\u0004\b\u0015\u0010\u0012J!\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u0004H&¢\u0006\u0004\b\u0017\u0010\u0011J\u001d\u0010\u0018\u001a\u00020\u000f2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\bH&¢\u0006\u0004\b\u0018\u0010\u0014J\u0015\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\bH&¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00020\bH&¢\u0006\u0004\b\u001b\u0010\u001aJ\u0017\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00020\bH&¢\u0006\u0004\b\u001e\u0010\u001aJ\u000f\u0010\u001f\u001a\u00020\u000fH&¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u000fH&¢\u0006\u0004\b!\u0010 R\u0016\u0010%\u001a\u00020\"8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$¨\u0006&"}, d2 = {"Lcom/avito/android/db/favorites/FavoritesSyncDao;", "", "", "id", "", "isFavoriteOnBack", "isFavorite", "(Ljava/lang/String;Z)Z", "", "ids", "", "getSavedFavoriteStatuses", "(Ljava/util/List;)Ljava/util/Map;", "itemId", "isSynced", "", "save", "(Ljava/lang/String;Z)V", "(Ljava/util/List;Z)V", ProductAction.ACTION_REMOVE, "(Ljava/util/List;)V", "markForRemove", "(Ljava/lang/String;)V", "clearMarkForRemove", "markSynced", "getAddedToFavoritesIds", "()Ljava/util/List;", "getMarkedForRemoveIds", "isMarkedForRemove", "(Ljava/lang/String;)Z", "getActiveIds", "wipe", "()V", "wipeSynced", "", "getCount", "()I", "count", "favorite_release"}, k = 1, mv = {1, 4, 2})
public interface FavoritesSyncDao {
    void clearMarkForRemove(@NotNull String str, boolean z);

    @NotNull
    List<String> getActiveIds();

    @NotNull
    List<String> getAddedToFavoritesIds();

    int getCount();

    @NotNull
    List<String> getMarkedForRemoveIds();

    @NotNull
    Map<String, Boolean> getSavedFavoriteStatuses(@NotNull List<String> list);

    boolean isFavorite(@NotNull String str, boolean z);

    boolean isMarkedForRemove(@NotNull String str);

    void markForRemove(@NotNull String str);

    void markForRemove(@NotNull List<String> list, boolean z);

    void markSynced(@NotNull List<String> list);

    void remove(@NotNull List<String> list);

    void save(@NotNull String str, boolean z);

    void save(@NotNull List<String> list, boolean z);

    void wipe();

    void wipeSynced();

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ void clearMarkForRemove$default(FavoritesSyncDao favoritesSyncDao, String str, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    z = false;
                }
                favoritesSyncDao.clearMarkForRemove(str, z);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: clearMarkForRemove");
        }

        public static /* synthetic */ void markForRemove$default(FavoritesSyncDao favoritesSyncDao, List list, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    z = false;
                }
                favoritesSyncDao.markForRemove(list, z);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: markForRemove");
        }

        public static /* synthetic */ void save$default(FavoritesSyncDao favoritesSyncDao, String str, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    z = false;
                }
                favoritesSyncDao.save(str, z);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: save");
        }

        public static /* synthetic */ void save$default(FavoritesSyncDao favoritesSyncDao, List list, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    z = false;
                }
                favoritesSyncDao.save(list, z);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: save");
        }
    }
}
