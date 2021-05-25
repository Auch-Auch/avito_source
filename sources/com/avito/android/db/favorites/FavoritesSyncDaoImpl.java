package com.avito.android.db.favorites;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.avito.android.db.BaseDao;
import com.avito.android.db.CachingCursor;
import com.avito.android.db.DbHelper;
import com.avito.android.db.DbLock;
import com.avito.android.db.DbUtils;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Logs;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import t6.n.r;
import t6.v.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u00102\u001a\u000201\u0012\u0006\u00100\u001a\u00020-¢\u0006\u0004\b3\u00104J\u001f\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ)\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u000b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\tH\u0016¢\u0006\u0004\b\f\u0010\rJ%\u0010\u0010\u001a\u00020\u000f2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\u0006\u0010\u000e\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0010\u0010\u0013J\u001d\u0010\u0014\u001a\u00020\u000f2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\tH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J%\u0010\u0016\u001a\u00020\u000f2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\u0006\u0010\u000e\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0016\u0010\u0011J\u001f\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0018\u0010\u0013J\u001d\u0010\u0019\u001a\u00020\u000f2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\tH\u0016¢\u0006\u0004\b\u0019\u0010\u0015J\u0015\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030\tH\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00030\tH\u0016¢\u0006\u0004\b\u001c\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0015\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00030\tH\u0016¢\u0006\u0004\b\u001f\u0010\u001bJ\u000f\u0010 \u001a\u00020\u000fH\u0016¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\"\u0010!J)\u0010#\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u0005H\u0002¢\u0006\u0004\b#\u0010$J)\u0010'\u001a\u00020%2\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010&\u001a\u00020%H\u0002¢\u0006\u0004\b'\u0010(R\u0016\u0010,\u001a\u00020)8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/¨\u00065"}, d2 = {"Lcom/avito/android/db/favorites/FavoritesSyncDaoImpl;", "Lcom/avito/android/db/BaseDao;", "Lcom/avito/android/db/favorites/FavoritesSyncDao;", "", "id", "", "isFavoriteOnBack", "isFavorite", "(Ljava/lang/String;Z)Z", "", "ids", "", "getSavedFavoriteStatuses", "(Ljava/util/List;)Ljava/util/Map;", "isSynced", "", "save", "(Ljava/util/List;Z)V", "itemId", "(Ljava/lang/String;Z)V", ProductAction.ACTION_REMOVE, "(Ljava/util/List;)V", "markForRemove", "(Ljava/lang/String;)V", "clearMarkForRemove", "markSynced", "getAddedToFavoritesIds", "()Ljava/util/List;", "getMarkedForRemoveIds", "isMarkedForRemove", "(Ljava/lang/String;)Z", "getActiveIds", "wipe", "()V", "wipeSynced", "c", "(Ljava/lang/String;ZZ)V", "Landroid/content/ContentValues;", "contentValues", AuthSource.SEND_ABUSE, "(Ljava/lang/String;ZLandroid/content/ContentValues;)Landroid/content/ContentValues;", "", "getCount", "()I", "count", "Lcom/avito/android/db/DbLock;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/db/DbLock;", "lock", "Lcom/avito/android/db/DbHelper;", "dbHelper", "<init>", "(Lcom/avito/android/db/DbHelper;Lcom/avito/android/db/DbLock;)V", "favorite_release"}, k = 1, mv = {1, 4, 2})
public final class FavoritesSyncDaoImpl extends BaseDao implements FavoritesSyncDao {
    public final DbLock b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FavoritesSyncDaoImpl(@NotNull DbHelper dbHelper, @NotNull DbLock dbLock) {
        super(dbHelper);
        Intrinsics.checkNotNullParameter(dbHelper, "dbHelper");
        Intrinsics.checkNotNullParameter(dbLock, "lock");
        this.b = dbLock;
    }

    public static final void access$markSynced(FavoritesSyncDaoImpl favoritesSyncDaoImpl, String str) {
        Objects.requireNonNull(favoritesSyncDaoImpl);
        synchronized (favoritesSyncDaoImpl.b) {
            SQLiteDatabase writableDatabase = favoritesSyncDaoImpl.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(FavoritesSyncDaoKt.a.getSYNC_STATUS(), Integer.valueOf(FavoritesSyncDaoKt.a.getSYNC_DONE()));
            writableDatabase.update(FavoritesSyncDaoKt.a.getTABLE_NAME(), contentValues, FavoritesSyncDaoKt.b, new String[]{str});
        }
    }

    public static final void access$remove(FavoritesSyncDaoImpl favoritesSyncDaoImpl, String str) {
        Objects.requireNonNull(favoritesSyncDaoImpl);
        synchronized (favoritesSyncDaoImpl.b) {
            favoritesSyncDaoImpl.getWritableDatabase().delete(FavoritesSyncDaoKt.a.getTABLE_NAME(), FavoritesSyncDaoKt.b, new String[]{str});
        }
    }

    public static final void access$saveInternal(FavoritesSyncDaoImpl favoritesSyncDaoImpl, SQLiteDatabase sQLiteDatabase, List list, boolean z) {
        Objects.requireNonNull(favoritesSyncDaoImpl);
        ContentValues contentValues = new ContentValues();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String table_name = FavoritesSyncDaoKt.a.getTABLE_NAME();
            favoritesSyncDaoImpl.a((String) it.next(), z, contentValues);
            sQLiteDatabase.insert(table_name, null, contentValues);
        }
    }

    public static List b(FavoritesSyncDaoImpl favoritesSyncDaoImpl, SQLiteDatabase sQLiteDatabase, String str, String[] strArr, String str2, int i) {
        CachingCursor cachingCursor;
        Throwable th;
        int i2 = i & 4;
        boolean z = true;
        Cursor query = sQLiteDatabase.query(FavoritesSyncDaoKt.a.getTABLE_NAME(), new String[]{FavoritesSyncDaoKt.a.getENTITY_ID()}, (i & 1) != 0 ? null : str, (i & 2) != 0 ? null : strArr, null, null, null);
        ArrayList arrayList = new ArrayList(query.getCount());
        if (query instanceof CachingCursor) {
            cachingCursor = (CachingCursor) query;
        } else {
            cachingCursor = new CachingCursor(query);
        }
        while (query.moveToNext()) {
            try {
                arrayList.add(cachingCursor.getString(FavoritesSyncDaoKt.a.getENTITY_ID()));
            } catch (Exception e) {
                try {
                    cachingCursor.close();
                } catch (Exception unused) {
                }
                throw e;
            } catch (Throwable th2) {
                th = th2;
            }
        }
        cachingCursor.close();
        return arrayList;
        if (!z) {
            cachingCursor.close();
        }
        throw th;
    }

    public final ContentValues a(String str, boolean z, ContentValues contentValues) {
        int i;
        contentValues.clear();
        contentValues.put(FavoritesSyncDaoKt.a.getENTITY_ID(), str);
        String sync_status = FavoritesSyncDaoKt.a.getSYNC_STATUS();
        if (z) {
            i = FavoritesSyncDaoKt.a.getSYNC_DONE();
        } else {
            i = FavoritesSyncDaoKt.a.getSYNC_PENDING();
        }
        contentValues.put(sync_status, Integer.valueOf(i));
        return contentValues;
    }

    public final void c(String str, boolean z, boolean z2) {
        synchronized (this.b) {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            a(str, z2, contentValues);
            contentValues.put(FavoritesSyncDaoKt.a.getMARKED_FOR_REMOVE(), Boolean.valueOf(z));
            writableDatabase.insert(FavoritesSyncDaoKt.a.getTABLE_NAME(), null, contentValues);
        }
    }

    @Override // com.avito.android.db.favorites.FavoritesSyncDao
    public void clearMarkForRemove(@NotNull String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "id");
        c(str, false, z);
    }

    @Override // com.avito.android.db.favorites.FavoritesSyncDao
    @NotNull
    public List<String> getActiveIds() {
        List<String> b2;
        synchronized (this.b) {
            SQLiteDatabase readableDatabase = getReadableDatabase();
            b2 = b(this, readableDatabase, FavoritesSyncDaoKt.a.getMARKED_FOR_REMOVE() + " = ?", new String[]{"0"}, null, 4);
        }
        return b2;
    }

    @Override // com.avito.android.db.favorites.FavoritesSyncDao
    @NotNull
    public List<String> getAddedToFavoritesIds() {
        List<String> b2;
        synchronized (this.b) {
            SQLiteDatabase readableDatabase = getReadableDatabase();
            b2 = b(this, readableDatabase, FavoritesSyncDaoKt.a.getSYNC_STATUS() + " = ? AND " + FavoritesSyncDaoKt.a.getMARKED_FOR_REMOVE() + " = ?", new String[]{String.valueOf(FavoritesSyncDaoKt.a.getSYNC_PENDING()), "0"}, null, 4);
        }
        return b2;
    }

    @Override // com.avito.android.db.favorites.FavoritesSyncDao
    public int getCount() {
        int count;
        synchronized (this.b) {
            SQLiteDatabase readableDatabase = getReadableDatabase();
            String table_name = FavoritesSyncDaoKt.a.getTABLE_NAME();
            count = DbUtils.getCount(readableDatabase, table_name, FavoritesSyncDaoKt.a.getMARKED_FOR_REMOVE() + " = ?", new String[]{"0"});
        }
        return count;
    }

    @Override // com.avito.android.db.favorites.FavoritesSyncDao
    @NotNull
    public List<String> getMarkedForRemoveIds() {
        List<String> b2;
        synchronized (this.b) {
            SQLiteDatabase readableDatabase = getReadableDatabase();
            b2 = b(this, readableDatabase, FavoritesSyncDaoKt.a.getSYNC_STATUS() + " = ? AND " + FavoritesSyncDaoKt.a.getMARKED_FOR_REMOVE() + " = ?", new String[]{String.valueOf(FavoritesSyncDaoKt.a.getSYNC_PENDING()), "1"}, null, 4);
        }
        return b2;
    }

    @Override // com.avito.android.db.favorites.FavoritesSyncDao
    @NotNull
    public Map<String, Boolean> getSavedFavoriteStatuses(@NotNull List<String> list) {
        boolean z;
        LinkedHashMap linkedHashMap;
        CachingCursor cachingCursor;
        Throwable th;
        Intrinsics.checkNotNullParameter(list, "ids");
        if (list.isEmpty()) {
            return r.emptyMap();
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (true) {
            z = true;
            if (!it.hasNext()) {
                break;
            }
            T next = it.next();
            if (next.length() <= 0) {
                z = false;
            }
            if (z) {
                arrayList.add(next);
            }
        }
        List distinct = CollectionsKt___CollectionsKt.distinct(arrayList);
        try {
            synchronized (this.b) {
                SQLiteDatabase readableDatabase = getReadableDatabase();
                linkedHashMap = new LinkedHashMap();
                Iterator it2 = new IntRange(0, distinct.size() / 200).iterator();
                while (it2.hasNext()) {
                    int nextInt = ((IntIterator) it2).nextInt();
                    List subList = distinct.subList(nextInt * 200, e.coerceAtMost((nextInt + 1) * 200, distinct.size()));
                    String table_name = FavoritesSyncDaoKt.a.getTABLE_NAME();
                    String[] strArr = {FavoritesSyncDaoKt.a.getENTITY_ID(), FavoritesSyncDaoKt.a.getMARKED_FOR_REMOVE()};
                    Cursor query = readableDatabase.query(table_name, strArr, FavoritesSyncDaoKt.a.getENTITY_ID() + " IN " + CollectionsKt___CollectionsKt.joinToString$default(subList, "','", "('", "')", 0, null, null, 56, null), null, null, null, null, null);
                    if (query instanceof CachingCursor) {
                        cachingCursor = (CachingCursor) query;
                    } else {
                        cachingCursor = new CachingCursor(query);
                    }
                    while (query.moveToNext()) {
                        try {
                            linkedHashMap.put(cachingCursor.getString(FavoritesSyncDaoKt.a.getENTITY_ID()), Boolean.valueOf(cachingCursor.getInt(FavoritesSyncDaoKt.a.getMARKED_FOR_REMOVE()) == 0));
                        } catch (Exception e) {
                            try {
                                cachingCursor.close();
                            } catch (Exception unused) {
                            }
                            throw e;
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    }
                    cachingCursor.close();
                }
            }
            return linkedHashMap;
        } catch (Exception e2) {
            Logs.error("FavoritesSyncDaoImpl - isFavorite", e2);
            return r.emptyMap();
        }
        if (!z) {
            cachingCursor.close();
        }
        throw th;
    }

    @Override // com.avito.android.db.favorites.FavoritesSyncDao
    public boolean isFavorite(@NotNull String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "id");
        synchronized (this.b) {
            SQLiteDatabase readableDatabase = getReadableDatabase();
            int i = z ? 1 : 0;
            String table_name = FavoritesSyncDaoKt.a.getTABLE_NAME();
            StringBuilder sb = new StringBuilder();
            sb.append(FavoritesSyncDaoKt.b);
            sb.append(" AND ");
            sb.append(FavoritesSyncDaoKt.a.getMARKED_FOR_REMOVE());
            sb.append(" = ?");
            if (DbUtils.getCount(readableDatabase, table_name, sb.toString(), new String[]{str, String.valueOf(i)}) > 0) {
                z = !z;
            }
        }
        return z;
    }

    @Override // com.avito.android.db.favorites.FavoritesSyncDao
    public boolean isMarkedForRemove(@NotNull String str) {
        boolean z;
        Intrinsics.checkNotNullParameter(str, "id");
        synchronized (this.b) {
            SQLiteDatabase readableDatabase = getReadableDatabase();
            String table_name = FavoritesSyncDaoKt.a.getTABLE_NAME();
            z = false;
            if (DbUtils.getCount(readableDatabase, table_name, FavoritesSyncDaoKt.b + " AND " + FavoritesSyncDaoKt.a.getMARKED_FOR_REMOVE() + " = ?", new String[]{str, "1"}) > 0) {
                z = true;
            }
        }
        return z;
    }

    @Override // com.avito.android.db.favorites.FavoritesSyncDao
    public void markForRemove(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        c(str, true, false);
    }

    /* JADX INFO: finally extract failed */
    @Override // com.avito.android.db.favorites.FavoritesSyncDao
    public void markSynced(@NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(list, "ids");
        synchronized (this.b) {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            writableDatabase.beginTransaction();
            try {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    access$markSynced(this, it.next());
                }
                writableDatabase.setTransactionSuccessful();
                writableDatabase.endTransaction();
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                writableDatabase.endTransaction();
                throw th;
            }
        }
    }

    /* JADX INFO: finally extract failed */
    @Override // com.avito.android.db.favorites.FavoritesSyncDao
    public void remove(@NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(list, "ids");
        synchronized (this.b) {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            writableDatabase.beginTransaction();
            try {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    access$remove(this, it.next());
                }
                writableDatabase.setTransactionSuccessful();
                writableDatabase.endTransaction();
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                writableDatabase.endTransaction();
                throw th;
            }
        }
    }

    /* JADX INFO: finally extract failed */
    @Override // com.avito.android.db.favorites.FavoritesSyncDao
    public void save(@NotNull List<String> list, boolean z) {
        Intrinsics.checkNotNullParameter(list, "ids");
        synchronized (this.b) {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            writableDatabase.beginTransaction();
            try {
                access$saveInternal(this, writableDatabase, list, z);
                writableDatabase.setTransactionSuccessful();
                writableDatabase.endTransaction();
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                writableDatabase.endTransaction();
                throw th;
            }
        }
    }

    @Override // com.avito.android.db.favorites.FavoritesSyncDao
    public void wipe() {
        synchronized (this.b) {
            DbUtils.deleteTable(getWritableDatabase(), FavoritesSyncDaoKt.a.getTABLE_NAME());
        }
    }

    @Override // com.avito.android.db.favorites.FavoritesSyncDao
    public void wipeSynced() {
        synchronized (this.b) {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            String table_name = FavoritesSyncDaoKt.a.getTABLE_NAME();
            writableDatabase.delete(table_name, FavoritesSyncDaoKt.a.getSYNC_STATUS() + " = ?", new String[]{String.valueOf(FavoritesSyncDaoKt.a.getSYNC_DONE())});
        }
    }

    /* JADX INFO: finally extract failed */
    @Override // com.avito.android.db.favorites.FavoritesSyncDao
    public void markForRemove(@NotNull List<String> list, boolean z) {
        Intrinsics.checkNotNullParameter(list, "ids");
        synchronized (this.b) {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            writableDatabase.beginTransaction();
            try {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    c(it.next(), true, z);
                }
                writableDatabase.setTransactionSuccessful();
                writableDatabase.endTransaction();
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                writableDatabase.endTransaction();
                throw th;
            }
        }
    }

    @Override // com.avito.android.db.favorites.FavoritesSyncDao
    public void save(@NotNull String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        synchronized (this.b) {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            String table_name = FavoritesSyncDaoKt.a.getTABLE_NAME();
            ContentValues contentValues = new ContentValues();
            a(str, z, contentValues);
            writableDatabase.insert(table_name, null, contentValues);
        }
    }
}
