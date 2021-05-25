package com.avito.android.db.viewed;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.avito.android.db.BaseDao;
import com.avito.android.db.CachingCursor;
import com.avito.android.db.DbHelper;
import com.avito.android.db.DbUtils;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.server_time.TimeSource;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\r\u0010\u000eJ#\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u00112\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u000fH\u0016¢\u0006\u0004\b\r\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\t\u001a\u00020\b8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001d"}, d2 = {"Lcom/avito/android/db/viewed/ViewedAdvertsDaoImpl;", "Lcom/avito/android/db/viewed/ViewedAdvertsDao;", "Lcom/avito/android/db/BaseDao;", "", "id", "", "save", "(Ljava/lang/String;)V", "", "count", "removeLessPopularViewedAdverts", "(I)V", "", "isViewed", "(Ljava/lang/String;)Z", "", "ids", "", "(Ljava/util/List;)Ljava/util/Set;", "Lcom/avito/android/server_time/TimeSource;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/server_time/TimeSource;", "timeSource", "getCount", "()I", "Lcom/avito/android/db/DbHelper;", "dbHelper", "<init>", "(Lcom/avito/android/server_time/TimeSource;Lcom/avito/android/db/DbHelper;)V", "core_release"}, k = 1, mv = {1, 4, 2})
public final class ViewedAdvertsDaoImpl extends BaseDao implements ViewedAdvertsDao {
    public final TimeSource b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ViewedAdvertsDaoImpl(@NotNull TimeSource timeSource, @NotNull DbHelper dbHelper) {
        super(dbHelper);
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        Intrinsics.checkNotNullParameter(dbHelper, "dbHelper");
        this.b = timeSource;
    }

    @Override // com.avito.android.db.viewed.ViewedAdvertsDao
    public int getCount() {
        int count;
        synchronized (ViewedAdvertsDaoKt.a) {
            count = DbUtils.getCount(getReadableDatabase(), ViewedAdvertsDaoKt.b.getTABLE_NAME());
        }
        return count;
    }

    @Override // com.avito.android.db.viewed.ViewedAdvertsDao
    public boolean isViewed(@NotNull String str) {
        boolean z;
        Intrinsics.checkNotNullParameter(str, "id");
        synchronized (ViewedAdvertsDaoKt.a) {
            SQLiteDatabase readableDatabase = getReadableDatabase();
            String table_name = ViewedAdvertsDaoKt.b.getTABLE_NAME();
            z = true;
            if (DbUtils.getCount(readableDatabase, table_name, ViewedAdvertsDaoKt.b.getADVERT_ID() + " = ?", new String[]{str}) <= 0) {
                z = false;
            }
        }
        return z;
    }

    @Override // com.avito.android.db.viewed.ViewedAdvertsDao
    public void removeLessPopularViewedAdverts(int i) {
        synchronized (ViewedAdvertsDaoKt.a) {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            writableDatabase.execSQL("\n                DELETE FROM " + ViewedAdvertsDaoKt.b.getTABLE_NAME() + " WHERE " + ViewedAdvertsDaoKt.b.getADVERT_ID() + " IN\n                (SELECT " + ViewedAdvertsDaoKt.b.getADVERT_ID() + " FROM " + ViewedAdvertsDaoKt.b.getTABLE_NAME() + "\n                ORDER BY " + ViewedAdvertsDaoKt.b.getADDED_TIME() + " ASC LIMIT " + i + ")\n            ");
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.avito.android.db.viewed.ViewedAdvertsDao
    public void save(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        synchronized (ViewedAdvertsDaoKt.a) {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            String table_name = ViewedAdvertsDaoKt.b.getTABLE_NAME();
            long now = this.b.now();
            ContentValues contentValues = new ContentValues();
            contentValues.put(ViewedAdvertsDaoKt.b.getADVERT_ID(), str);
            contentValues.put(ViewedAdvertsDaoKt.b.getADDED_TIME(), Long.valueOf(now));
            writableDatabase.insert(table_name, null, contentValues);
        }
    }

    @Override // com.avito.android.db.viewed.ViewedAdvertsDao
    @NotNull
    public Set<String> isViewed(@NotNull List<String> list) {
        LinkedHashSet linkedHashSet;
        CachingCursor cachingCursor;
        boolean z;
        Throwable th;
        Intrinsics.checkNotNullParameter(list, "ids");
        synchronized (ViewedAdvertsDaoKt.a) {
            SQLiteDatabase readableDatabase = getReadableDatabase();
            linkedHashSet = new LinkedHashSet();
            String table_name = ViewedAdvertsDaoKt.b.getTABLE_NAME();
            String[] strArr = {ViewedAdvertsDaoKt.b.getADVERT_ID()};
            Cursor query = readableDatabase.query(table_name, strArr, ViewedAdvertsDaoKt.b.getADVERT_ID() + " IN " + CollectionsKt___CollectionsKt.joinToString$default(list, ",", "(", ")", 0, null, null, 56, null), null, null, null, null);
            if (query instanceof CachingCursor) {
                cachingCursor = (CachingCursor) query;
            } else {
                cachingCursor = new CachingCursor(query);
            }
            while (query.moveToNext()) {
                try {
                    linkedHashSet.add(cachingCursor.getString(ViewedAdvertsDaoKt.b.getADVERT_ID()));
                } catch (Exception e) {
                    try {
                        cachingCursor.close();
                    } catch (Exception unused) {
                    }
                    throw e;
                } catch (Throwable th2) {
                    th = th2;
                    z = true;
                }
            }
            Unit unit = Unit.INSTANCE;
            cachingCursor.close();
        }
        return linkedHashSet;
        if (!z) {
            cachingCursor.close();
        }
        throw th;
    }
}
