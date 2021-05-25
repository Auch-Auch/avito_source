package com.avito.android.db;

import a2.b.a.a.a;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
public final class DbUtils {
    public static final String[] EMPTY_COLUMNS = null;
    public static final String EMPTY_GROUP_BY = null;
    public static final String EMPTY_HAVING = null;
    public static final String EMPTY_ORDER_BY = null;
    public static final String EMPTY_SELECTION = null;
    public static final String[] EMPTY_SELECTION_ARGS = null;

    public static void close(@Nullable Cursor cursor) {
        if (cursor != null) {
            cursor.close();
        }
    }

    public static void deleteTable(@NonNull SQLiteDatabase sQLiteDatabase, @NonNull String str) {
        sQLiteDatabase.delete(str, null, null);
    }

    public static void dropTable(@NonNull SQLiteDatabase sQLiteDatabase, @NonNull String str) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + str);
    }

    public static int getCount(@NonNull SQLiteDatabase sQLiteDatabase, @NonNull String str) {
        return getCount(sQLiteDatabase, str, null, null);
    }

    public static int getCount(@NonNull SQLiteDatabase sQLiteDatabase, @NonNull String str, @Nullable String str2, @Nullable String[] strArr) {
        return (int) DatabaseUtils.longForQuery(sQLiteDatabase, a.e3("select count(*) from ", str, !TextUtils.isEmpty(str2) ? a.c3(" where ", str2) : ""), strArr);
    }
}
