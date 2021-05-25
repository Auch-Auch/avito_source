package com.avito.android.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.event.NonFatalError;
import com.avito.android.db.AdvertsContract;
import com.avito.android.db.FavoritesContract;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.AdvertPrice;
import com.avito.android.remote.model.ExtendedImagesKt;
import com.avito.android.remote.model.Item;
import com.avito.android.remote.model.Video;
import com.avito.android.util.DeviceMetrics;
import com.avito.android.util.Formatter;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B'\u0012\u0006\u0010<\u001a\u00020;\u0012\u0006\u0010+\u001a\u00020*\u0012\u0006\u00102\u001a\u000200\u0012\u0006\u0010:\u001a\u000207¢\u0006\u0004\b=\u0010>J\u001f\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0007\u0010\u000bJ-\u0010\u0007\u001a\u00020\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\u000eJ%\u0010\u0013\u001a\u00020\u00052\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0012\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\u0017\u001a\u00020\u00162\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0013\u0010\u001aJ\u0017\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0016H\u0016¢\u0006\u0004\b \u0010!J\u0017\u0010#\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020\u0005H\u0016¢\u0006\u0004\b#\u0010$J\u0017\u0010%\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0010H\u0002¢\u0006\u0004\b%\u0010\u001cJ\u0017\u0010&\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0010H\u0002¢\u0006\u0004\b&\u0010\u001cJ-\u0010-\u001a\u00020,2\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010)\u001a\b\u0012\u0004\u0012\u00020(0'2\u0006\u0010+\u001a\u00020*H\u0002¢\u0006\u0004\b-\u0010.R\u0016\u0010+\u001a\u00020*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010/R\u0016\u00102\u001a\u0002008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u00101R\u0016\u00106\u001a\u0002038V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b4\u00105R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b8\u00109¨\u0006?"}, d2 = {"Lcom/avito/android/db/FavoriteDaoImpl;", "Lcom/avito/android/db/BaseDao;", "Lcom/avito/android/db/FavoriteDao;", "Lcom/avito/android/remote/model/Item;", "item", "", "forceSynced", "save", "(Lcom/avito/android/remote/model/Item;Z)Z", "", "updateTimestamp", "(Lcom/avito/android/remote/model/Item;ZJ)Z", "", "items", "(Ljava/util/List;ZZ)Z", "", "", "ids", "forceDelete", "removeById", "(Ljava/util/Collection;Z)Z", "itemsIds", "", "markSynced", "(Ljava/util/Collection;)V", "itemId", "(Ljava/lang/String;Z)Z", "isItemFavorite", "(Ljava/lang/String;)Z", "Landroid/database/Cursor;", "selectActiveItems", "()Landroid/database/Cursor;", "wipe", "()V", "onlyInactive", "deleteItems", "(Z)V", "c", AuthSource.SEND_ABUSE, "Lcom/avito/android/util/Formatter;", "Lcom/avito/android/remote/model/AdvertPrice;", "priceFormatter", "Lcom/avito/android/util/DeviceMetrics;", "deviceMetrics", "Landroid/content/ContentValues;", AuthSource.BOOKING_ORDER, "(Lcom/avito/android/remote/model/Item;Lcom/avito/android/util/Formatter;Lcom/avito/android/util/DeviceMetrics;)Landroid/content/ContentValues;", "Lcom/avito/android/util/DeviceMetrics;", "Lcom/avito/android/analytics/Analytics;", "Lcom/avito/android/analytics/Analytics;", "analytics", "", "getFavoritesCount", "()I", "favoritesCount", "Ljava/util/Locale;", "d", "Ljava/util/Locale;", "locale", "Lcom/avito/android/db/DbHelper;", "dbHelper", "<init>", "(Lcom/avito/android/db/DbHelper;Lcom/avito/android/util/DeviceMetrics;Lcom/avito/android/analytics/Analytics;Ljava/util/Locale;)V", "favorite_release"}, k = 1, mv = {1, 4, 2})
public final class FavoriteDaoImpl extends BaseDao implements FavoriteDao {
    public final DeviceMetrics b;
    public final Analytics c;
    public final Locale d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FavoriteDaoImpl(@NotNull DbHelper dbHelper, @NotNull DeviceMetrics deviceMetrics, @NotNull Analytics analytics, @NotNull Locale locale) {
        super(dbHelper);
        Intrinsics.checkNotNullParameter(dbHelper, "dbHelper");
        Intrinsics.checkNotNullParameter(deviceMetrics, "deviceMetrics");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(locale, "locale");
        this.b = deviceMetrics;
        this.c = analytics;
        this.d = locale;
    }

    public final boolean a(String str) {
        Throwable th;
        Cursor cursor;
        synchronized (FavoriteDaoKt.a) {
            try {
                cursor = getReadableDatabase().query(FavoritesContract.TABLE_NAME, new String[]{FavoritesContract.FavoriteAdvertColumns.SYNC_FLAG, FavoritesContract.FavoriteAdvertColumns.MARKED_FOR_REMOVE_FLAG}, "server_id =?", new String[]{str}, null, null, null, "1");
                if (cursor != null) {
                    while (true) {
                        boolean z = false;
                        while (cursor.moveToNext()) {
                            try {
                                boolean z2 = cursor.getInt(cursor.getColumnIndex(FavoritesContract.FavoriteAdvertColumns.SYNC_FLAG)) != 0;
                                boolean z3 = cursor.getInt(cursor.getColumnIndex(FavoritesContract.FavoriteAdvertColumns.MARKED_FOR_REMOVE_FLAG)) > 0;
                                if (!z2 || (z2 && z3)) {
                                    z = true;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                BaseDao.Companion.close(cursor);
                                throw th;
                            }
                        }
                        BaseDao.Companion.close(cursor);
                        return z;
                    }
                }
                BaseDao.Companion.close(null);
                return false;
            } catch (Throwable th3) {
                cursor = null;
                th = th3;
                BaseDao.Companion.close(cursor);
                throw th;
            }
        }
    }

    public final ContentValues b(Item item, Formatter<AdvertPrice> formatter, DeviceMetrics deviceMetrics) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("category_id", item.categoryId);
        contentValues.put("title", item.title);
        AdvertPrice advertPrice = item.price;
        if (advertPrice != null) {
            contentValues.put("price", formatter.format(advertPrice));
        }
        contentValues.put("location_name", item.getLocationName());
        if (!TextUtils.isEmpty(item.metroId)) {
            contentValues.put(AdvertsContract.AdvertColumns.METRO_NAME, item.getMetroName());
        }
        String str = null;
        int densityDpi = deviceMetrics.getDensityDpi();
        if (!item.images.isEmpty()) {
            str = ExtendedImagesKt.getListSizeIcon(item.images.get(0).getImage(), densityDpi);
        }
        Video video = item.getVideo();
        if (str == null && video != null && video.hasPreviewImage()) {
            str = ExtendedImagesKt.getListSizeIcon(video.getPreviewImage(), densityDpi);
        }
        if (str != null) {
            contentValues.put("image_url", str);
        }
        String str2 = item.status;
        if (str2 != null) {
            contentValues.put("status", str2);
        }
        contentValues.put("time", Long.valueOf(item.time));
        return contentValues;
    }

    public final boolean c(String str) {
        Throwable th;
        Cursor cursor;
        synchronized (FavoriteDaoKt.a) {
            boolean z = true;
            try {
                cursor = getReadableDatabase().query(FavoritesContract.TABLE_NAME, new String[]{AdvertsContract.AdvertColumns.SERVER_ID}, "server_id=?", new String[]{str}, null, null, null, "1");
                if (cursor != null) {
                    try {
                        if (cursor.getCount() <= 0) {
                            z = false;
                        }
                        BaseDao.Companion.close(cursor);
                        return z;
                    } catch (Throwable th2) {
                        th = th2;
                        BaseDao.Companion.close(cursor);
                        throw th;
                    }
                } else {
                    BaseDao.Companion.close(null);
                    return false;
                }
            } catch (Throwable th3) {
                cursor = null;
                th = th3;
                BaseDao.Companion.close(cursor);
                throw th;
            }
        }
    }

    @Override // com.avito.android.db.FavoriteDao
    public void deleteItems(boolean z) {
        String str;
        String[] strArr;
        String[] strArr2;
        String str2;
        synchronized (FavoriteDaoKt.a) {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (z) {
                strArr = new String[]{"1", "active"};
                str = "sync_flag<> ? AND status <> ?";
            } else {
                strArr = new String[]{"1"};
                str = "sync_flag<> ?";
            }
            writableDatabase.delete(FavoritesContract.TABLE_NAME, str, strArr);
            if (z) {
                strArr2 = new String[]{"1", "active"};
                str2 = "sync_flag= ? AND status <> ?";
            } else {
                strArr2 = new String[]{"1"};
                str2 = "sync_flag= ?";
            }
            ContentValues contentValues = new ContentValues(1);
            contentValues.put(FavoritesContract.FavoriteAdvertColumns.MARKED_FOR_REMOVE_FLAG, (Integer) 1);
            writableDatabase.update(FavoritesContract.TABLE_NAME, contentValues, str2, strArr2);
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.avito.android.db.FavoriteDao
    public int getFavoritesCount() {
        int count;
        synchronized (FavoriteDaoKt.a) {
            count = DbUtils.getCount(getReadableDatabase(), FavoritesContract.TABLE_NAME);
        }
        return count;
    }

    @Override // com.avito.android.db.FavoriteDao
    public boolean isItemFavorite(@NotNull String str) {
        Throwable th;
        Cursor cursor;
        Intrinsics.checkNotNullParameter(str, "itemId");
        synchronized (FavoriteDaoKt.a) {
            boolean z = false;
            try {
                cursor = getReadableDatabase().query(FavoritesContract.TABLE_NAME, new String[]{AdvertsContract.AdvertColumns.SERVER_ID}, "server_id=? AND marked_for_remove=?", new String[]{str, "0"}, null, null, null, "1");
                if (cursor != null) {
                    try {
                        if (cursor.getCount() > 0) {
                            z = true;
                        }
                        BaseDao.Companion.close(cursor);
                        return z;
                    } catch (Throwable th2) {
                        th = th2;
                        BaseDao.Companion.close(cursor);
                        throw th;
                    }
                } else {
                    BaseDao.Companion.close(null);
                    return false;
                }
            } catch (Throwable th3) {
                cursor = null;
                th = th3;
                BaseDao.Companion.close(cursor);
                throw th;
            }
        }
    }

    /* JADX INFO: finally extract failed */
    @Override // com.avito.android.db.FavoriteDao
    public void markSynced(@NotNull Collection<String> collection) {
        Intrinsics.checkNotNullParameter(collection, "itemsIds");
        synchronized (FavoriteDaoKt.a) {
            if (!collection.isEmpty()) {
                ContentValues contentValues = new ContentValues();
                contentValues.put(FavoritesContract.FavoriteAdvertColumns.SYNC_FLAG, (Integer) 1);
                SQLiteDatabase writableDatabase = getWritableDatabase();
                writableDatabase.beginTransaction();
                try {
                    Iterator<String> it = collection.iterator();
                    while (it.hasNext()) {
                        writableDatabase.update(FavoritesContract.TABLE_NAME, contentValues, "server_id=?", new String[]{it.next()});
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
    }

    /* JADX INFO: finally extract failed */
    @Override // com.avito.android.db.FavoriteDao
    public boolean removeById(@NotNull Collection<String> collection, boolean z) {
        Intrinsics.checkNotNullParameter(collection, "ids");
        synchronized (FavoriteDaoKt.a) {
            boolean z2 = true;
            if (collection.isEmpty()) {
                return true;
            }
            SQLiteDatabase writableDatabase = getWritableDatabase();
            try {
                writableDatabase.beginTransaction();
                int i = 0;
                for (String str : collection) {
                    if (removeById(str, z)) {
                        i++;
                    }
                }
                writableDatabase.setTransactionSuccessful();
                writableDatabase.endTransaction();
                if (i != collection.size()) {
                    z2 = false;
                }
                if (!z2) {
                    Analytics analytics = this.c;
                    analytics.track(new NonFatalError("Remove from favorites error", new DbException("error: " + i + " out of " + collection.size()), null, 4, null));
                }
                return z2;
            } catch (Throwable th) {
                writableDatabase.endTransaction();
                throw th;
            }
        }
    }

    @Override // com.avito.android.db.FavoriteDao
    public boolean save(@NotNull Item item, boolean z) {
        boolean save;
        Intrinsics.checkNotNullParameter(item, "item");
        synchronized (FavoriteDaoKt.a) {
            save = save(item, z, -1);
        }
        return save;
    }

    @Override // com.avito.android.db.FavoriteDao
    @NotNull
    public Cursor selectActiveItems() {
        Cursor query;
        synchronized (FavoriteDaoKt.a) {
            query = getReadableDatabase().query(FavoritesContract.TABLE_NAME, null, "marked_for_remove <> ?", new String[]{"1"}, null, null, AdvertsContract.TIMESTAMP_DESC);
            Intrinsics.checkNotNullExpressionValue(query, "db.query(\n              …ESTAMP_DESC\n            )");
        }
        return query;
    }

    @Override // com.avito.android.db.FavoriteDao
    public void wipe() {
        synchronized (FavoriteDaoKt.a) {
            DbUtils.deleteTable(getWritableDatabase(), FavoritesContract.TABLE_NAME);
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0085, code lost:
        if (r1.insert(com.avito.android.db.FavoritesContract.TABLE_NAME, null, r2) != -1) goto L_0x0087;
     */
    @Override // com.avito.android.db.FavoriteDao
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean save(@org.jetbrains.annotations.NotNull com.avito.android.remote.model.Item r9, boolean r10, long r11) {
        /*
            r8 = this;
            java.lang.String r0 = "item"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.Object r0 = com.avito.android.db.FavoriteDaoKt.access$getLock$p()
            monitor-enter(r0)
            android.database.sqlite.SQLiteDatabase r1 = r8.getWritableDatabase()     // Catch:{ all -> 0x0089 }
            com.avito.android.util.AdvertPriceFormatter r2 = new com.avito.android.util.AdvertPriceFormatter     // Catch:{ all -> 0x0089 }
            java.util.Locale r3 = r8.d     // Catch:{ all -> 0x0089 }
            r2.<init>(r3)     // Catch:{ all -> 0x0089 }
            com.avito.android.util.DeviceMetrics r3 = r8.b     // Catch:{ all -> 0x0089 }
            android.content.ContentValues r2 = r8.b(r9, r2, r3)     // Catch:{ all -> 0x0089 }
            java.lang.String r3 = r9.id     // Catch:{ all -> 0x0089 }
            java.lang.String r4 = "item.id"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)     // Catch:{ all -> 0x0089 }
            boolean r3 = r8.c(r3)     // Catch:{ all -> 0x0089 }
            r4 = 1
            r5 = 0
            if (r3 == 0) goto L_0x0058
            java.lang.String r10 = "marked_for_remove"
            java.lang.Integer r3 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0089 }
            r2.put(r10, r3)     // Catch:{ all -> 0x0089 }
            r6 = 0
            int r10 = (r11 > r6 ? 1 : (r11 == r6 ? 0 : -1))
            if (r10 <= 0) goto L_0x0042
            java.lang.String r10 = "timestamp"
            java.lang.Long r11 = java.lang.Long.valueOf(r11)     // Catch:{ all -> 0x0089 }
            r2.put(r10, r11)     // Catch:{ all -> 0x0089 }
        L_0x0042:
            java.lang.String r10 = "favorites"
            java.lang.String r11 = "server_id=?"
            java.lang.String[] r12 = new java.lang.String[r4]     // Catch:{ all -> 0x0089 }
            java.lang.String r9 = r9.id     // Catch:{ all -> 0x0089 }
            r12[r5] = r9     // Catch:{ all -> 0x0089 }
            int r9 = r1.update(r10, r2, r11, r12)     // Catch:{ all -> 0x0089 }
            long r9 = (long) r9     // Catch:{ all -> 0x0089 }
            int r11 = (r9 > r6 ? 1 : (r9 == r6 ? 0 : -1))
            if (r11 <= 0) goto L_0x0056
            goto L_0x0087
        L_0x0056:
            r4 = 0
            goto L_0x0087
        L_0x0058:
            java.lang.String r11 = "server_id"
            java.lang.String r9 = r9.id     // Catch:{ all -> 0x0089 }
            r2.put(r11, r9)     // Catch:{ all -> 0x0089 }
            java.lang.String r9 = "sync_flag"
            if (r10 == 0) goto L_0x0065
            r10 = 1
            goto L_0x0066
        L_0x0065:
            r10 = 0
        L_0x0066:
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ all -> 0x0089 }
            r2.put(r9, r10)     // Catch:{ all -> 0x0089 }
            java.lang.String r9 = "timestamp"
            long r10 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0089 }
            java.lang.Long r10 = java.lang.Long.valueOf(r10)     // Catch:{ all -> 0x0089 }
            r2.put(r9, r10)     // Catch:{ all -> 0x0089 }
            java.lang.String r9 = "favorites"
            r10 = 0
            long r9 = r1.insert(r9, r10, r2)     // Catch:{ all -> 0x0089 }
            r11 = -1
            int r1 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r1 == 0) goto L_0x0056
        L_0x0087:
            monitor-exit(r0)
            return r4
        L_0x0089:
            r9 = move-exception
            monitor-exit(r0)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.db.FavoriteDaoImpl.save(com.avito.android.remote.model.Item, boolean, long):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x003d  */
    @Override // com.avito.android.db.FavoriteDao
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean removeById(@org.jetbrains.annotations.NotNull java.lang.String r8, boolean r9) {
        /*
            r7 = this;
            java.lang.String r0 = "itemId"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.Object r0 = com.avito.android.db.FavoriteDaoKt.access$getLock$p()
            monitor-enter(r0)
            android.database.sqlite.SQLiteDatabase r1 = r7.getWritableDatabase()     // Catch:{ all -> 0x0040 }
            java.lang.String r2 = "server_id=?"
            r3 = 1
            java.lang.String[] r4 = new java.lang.String[r3]     // Catch:{ all -> 0x0040 }
            r5 = 0
            r4[r5] = r8     // Catch:{ all -> 0x0040 }
            if (r9 != 0) goto L_0x0034
            boolean r8 = r7.a(r8)     // Catch:{ all -> 0x0040 }
            if (r8 == 0) goto L_0x001f
            goto L_0x0034
        L_0x001f:
            android.content.ContentValues r8 = new android.content.ContentValues     // Catch:{ all -> 0x0040 }
            r8.<init>()     // Catch:{ all -> 0x0040 }
            java.lang.String r9 = "marked_for_remove"
            java.lang.Integer r6 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0040 }
            r8.put(r9, r6)     // Catch:{ all -> 0x0040 }
            java.lang.String r9 = "favorites"
            int r8 = r1.update(r9, r8, r2, r4)     // Catch:{ all -> 0x0040 }
            goto L_0x003a
        L_0x0034:
            java.lang.String r8 = "favorites"
            int r8 = r1.delete(r8, r2, r4)     // Catch:{ all -> 0x0040 }
        L_0x003a:
            if (r8 <= 0) goto L_0x003d
            goto L_0x003e
        L_0x003d:
            r3 = 0
        L_0x003e:
            monitor-exit(r0)
            return r3
        L_0x0040:
            r8 = move-exception
            monitor-exit(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.db.FavoriteDaoImpl.removeById(java.lang.String, boolean):boolean");
    }

    /* JADX INFO: finally extract failed */
    @Override // com.avito.android.db.FavoriteDao
    public boolean save(@NotNull List<? extends Item> list, boolean z, boolean z2) {
        long j;
        boolean z3;
        Intrinsics.checkNotNullParameter(list, "items");
        synchronized (FavoriteDaoKt.a) {
            boolean z4 = true;
            if (list.isEmpty()) {
                return true;
            }
            long j2 = 0;
            SQLiteDatabase writableDatabase = getWritableDatabase();
            writableDatabase.beginTransaction();
            try {
                long currentTimeMillis = System.currentTimeMillis();
                for (Item item : list) {
                    if (z2) {
                        j = 1 + currentTimeMillis;
                        z3 = save(item, z, currentTimeMillis);
                    } else {
                        j = currentTimeMillis;
                        z3 = save(item, z);
                    }
                    j2 += z3 ? 1 : 0;
                    currentTimeMillis = j;
                }
                writableDatabase.setTransactionSuccessful();
                writableDatabase.endTransaction();
                if (j2 != ((long) list.size())) {
                    z4 = false;
                }
                if (!z4) {
                    Analytics analytics = this.c;
                    analytics.track(new NonFatalError("save favorites error: ", new DbException("error: " + j2 + " out of " + list.size()), null, 4, null));
                }
                return z4;
            } catch (Throwable th) {
                writableDatabase.endTransaction();
                throw th;
            }
        }
    }
}
