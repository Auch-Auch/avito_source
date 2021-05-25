package com.avito.android.util;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.avito.android.db.CachingCursor;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Landroid/database/sqlite/SQLiteDatabase;", "", "", "tables", "(Landroid/database/sqlite/SQLiteDatabase;)Ljava/util/List;", "core_release"}, k = 2, mv = {1, 4, 2})
@JvmName(name = "Databases")
public final class Databases {
    @NotNull
    public static final List<String> tables(@NotNull SQLiteDatabase sQLiteDatabase) {
        CachingCursor cachingCursor;
        Throwable th;
        Intrinsics.checkNotNullParameter(sQLiteDatabase, "$this$tables");
        Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT name FROM sqlite_master WHERE type = 'table'", null);
        Intrinsics.checkNotNullExpressionValue(rawQuery, "rawQuery(\"SELECT name FR…RE type = 'table'\", null)");
        if (rawQuery instanceof CachingCursor) {
            cachingCursor = (CachingCursor) rawQuery;
        } else {
            cachingCursor = new CachingCursor(rawQuery);
        }
        boolean z = false;
        try {
            ArrayList arrayList = new ArrayList();
            while (cachingCursor.moveToNext()) {
                arrayList.add(cachingCursor.getString("name"));
            }
            cachingCursor.close();
            return arrayList;
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
        if (!z) {
            cachingCursor.close();
        }
        throw th;
    }
}
