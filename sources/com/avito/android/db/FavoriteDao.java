package com.avito.android.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.avito.android.remote.model.Item;
import java.util.Collection;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Deprecated(message = "Use FavoritesSyncDao")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0006\u0010\u0007J'\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\u0006\u0010\nJ-\u0010\u0006\u001a\u00020\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H&¢\u0006\u0004\b\u0006\u0010\rJ%\u0010\u0012\u001a\u00020\u00042\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0011\u001a\u00020\u0004H&¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0004H&¢\u0006\u0004\b\u0012\u0010\u0015J\u0017\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u000fH&¢\u0006\u0004\b\u0016\u0010\u0017J\u001d\u0010\u001a\u001a\u00020\u00192\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH&¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001d\u001a\u00020\u001cH&¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0019H&¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010\"\u001a\u00020\u00192\u0006\u0010!\u001a\u00020\u0004H&¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u0019H&¢\u0006\u0004\b$\u0010 R\u0016\u0010(\u001a\u00020%8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+R\u0016\u0010.\u001a\u00020)8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b-\u0010+¨\u0006/"}, d2 = {"Lcom/avito/android/db/FavoriteDao;", "", "Lcom/avito/android/remote/model/Item;", "item", "", "forceSynced", "save", "(Lcom/avito/android/remote/model/Item;Z)Z", "", "updateTimestamp", "(Lcom/avito/android/remote/model/Item;ZJ)Z", "", "items", "(Ljava/util/List;ZZ)Z", "", "", "ids", "forceDelete", "removeById", "(Ljava/util/Collection;Z)Z", "itemId", "(Ljava/lang/String;Z)Z", "isItemFavorite", "(Ljava/lang/String;)Z", "itemsIds", "", "markSynced", "(Ljava/util/Collection;)V", "Landroid/database/Cursor;", "selectActiveItems", "()Landroid/database/Cursor;", "wipe", "()V", "onlyInactive", "deleteItems", "(Z)V", "close", "", "getFavoritesCount", "()I", "favoritesCount", "Landroid/database/sqlite/SQLiteDatabase;", "getReadableDatabase", "()Landroid/database/sqlite/SQLiteDatabase;", "readableDatabase", "getWritableDatabase", "writableDatabase", "favorite_release"}, k = 1, mv = {1, 4, 2})
public interface FavoriteDao {
    void close();

    void deleteItems(boolean z);

    int getFavoritesCount();

    @NotNull
    SQLiteDatabase getReadableDatabase();

    @NotNull
    SQLiteDatabase getWritableDatabase();

    boolean isItemFavorite(@NotNull String str);

    void markSynced(@NotNull Collection<String> collection);

    boolean removeById(@NotNull String str, boolean z);

    boolean removeById(@NotNull Collection<String> collection, boolean z);

    boolean save(@NotNull Item item, boolean z);

    boolean save(@NotNull Item item, boolean z, long j);

    boolean save(@NotNull List<? extends Item> list, boolean z, boolean z2);

    @NotNull
    Cursor selectActiveItems();

    void wipe();
}
