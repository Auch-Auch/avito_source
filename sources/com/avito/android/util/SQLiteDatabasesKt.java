package com.avito.android.util;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.avito.android.publish.residential_complex_search.di.ResidentialComplexModuleKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a#\u0010\u0005\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a2\u0010\u000b\u001a\u00020\b*\u00020\u00002\u0019\b\u0004\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\b\tH\bø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a!\u0010\u0011\u001a\u00020\u0010*\u00020\u00002\u0006\u0010\r\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0011\u0010\u0012\u001ay\u0010\u001d\u001a\u00020\u001c*\u00020\u00002\u0006\u0010\r\u001a\u00020\u00012\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00132\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00012\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00132\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\b\u001d\u0010\u001e\u0002\u0007\n\u0005\b20\u0001¨\u0006\u001f"}, d2 = {"Landroid/database/sqlite/SQLiteDatabase;", "", "tableName", "columnName", "", "hasColumn", "(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;)Z", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "block", "inTransaction", "(Landroid/database/sqlite/SQLiteDatabase;Lkotlin/jvm/functions/Function1;)V", "table", "Landroid/content/ContentValues;", ResidentialComplexModuleKt.VALUES, "", "insert", "(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Landroid/content/ContentValues;)J", "", "columns", "selection", "selectionArgs", "groupBy", "having", "orderBy", "", "limit", "Landroid/database/Cursor;", "query", "(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Landroid/database/Cursor;", "android_release"}, k = 2, mv = {1, 4, 2})
public final class SQLiteDatabasesKt {
    @SuppressLint({"Recycle"})
    public static final boolean hasColumn(@NotNull SQLiteDatabase sQLiteDatabase, @NotNull String str, @NotNull String str2) {
        Throwable th;
        Intrinsics.checkNotNullParameter(sQLiteDatabase, "$this$hasColumn");
        Intrinsics.checkNotNullParameter(str, "tableName");
        Intrinsics.checkNotNullParameter(str2, "columnName");
        Cursor rawQuery = sQLiteDatabase.rawQuery("select * from " + str + " LIMIT 0", null);
        boolean z = true;
        boolean z2 = false;
        try {
            if (rawQuery.getColumnIndex(str2) == -1) {
                z = false;
            }
            rawQuery.close();
            return z;
        } catch (Exception e) {
            try {
                rawQuery.close();
            } catch (Exception unused) {
            }
            throw e;
        } catch (Throwable th2) {
            th = th2;
            z2 = true;
        }
        if (!z2) {
            rawQuery.close();
        }
        throw th;
    }

    public static final void inTransaction(@NotNull SQLiteDatabase sQLiteDatabase, @NotNull Function1<? super SQLiteDatabase, Unit> function1) {
        Intrinsics.checkNotNullParameter(sQLiteDatabase, "$this$inTransaction");
        Intrinsics.checkNotNullParameter(function1, "block");
        sQLiteDatabase.beginTransaction();
        int i = 1;
        try {
            function1.invoke(sQLiteDatabase);
            sQLiteDatabase.setTransactionSuccessful();
        } finally {
            InlineMarker.finallyStart(i);
            sQLiteDatabase.endTransaction();
            InlineMarker.finallyEnd(i);
        }
    }

    public static final long insert(@NotNull SQLiteDatabase sQLiteDatabase, @NotNull String str, @NotNull ContentValues contentValues) {
        Intrinsics.checkNotNullParameter(sQLiteDatabase, "$this$insert");
        Intrinsics.checkNotNullParameter(str, "table");
        Intrinsics.checkNotNullParameter(contentValues, ResidentialComplexModuleKt.VALUES);
        return sQLiteDatabase.insert(str, null, contentValues);
    }

    @NotNull
    public static final Cursor query(@NotNull SQLiteDatabase sQLiteDatabase, @NotNull String str, @Nullable String[] strArr, @Nullable String str2, @Nullable String[] strArr2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(sQLiteDatabase, "$this$query");
        Intrinsics.checkNotNullParameter(str, "table");
        Cursor query = sQLiteDatabase.query(str, strArr, str2, strArr2, str3, str4, str5, num != null ? String.valueOf(num.intValue()) : null);
        Intrinsics.checkNotNullExpressionValue(query, "query(table, columns, se…derBy, limit?.toString())");
        return query;
    }

    public static /* synthetic */ Cursor query$default(SQLiteDatabase sQLiteDatabase, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, Integer num, int i, Object obj) {
        Integer num2 = null;
        String[] strArr3 = (i & 2) != 0 ? null : strArr;
        String str6 = (i & 4) != 0 ? null : str2;
        String[] strArr4 = (i & 8) != 0 ? null : strArr2;
        String str7 = (i & 16) != 0 ? null : str3;
        String str8 = (i & 32) != 0 ? null : str4;
        String str9 = (i & 64) != 0 ? null : str5;
        if ((i & 128) == 0) {
            num2 = num;
        }
        return query(sQLiteDatabase, str, strArr3, str6, strArr4, str7, str8, str9, num2);
    }
}
