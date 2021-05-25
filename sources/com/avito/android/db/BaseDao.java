package com.avito.android.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0011\b\u0004\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0013\u0010\f\u001a\u00020\t8F@\u0006¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u000e\u001a\u00020\t8F@\u0006¢\u0006\u0006\u001a\u0004\b\r\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/avito/android/db/BaseDao;", "", "", "close", "()V", "Lcom/avito/android/db/DbHelper;", AuthSource.SEND_ABUSE, "Lcom/avito/android/db/DbHelper;", "dbHelper", "Landroid/database/sqlite/SQLiteDatabase;", "getReadableDatabase", "()Landroid/database/sqlite/SQLiteDatabase;", "readableDatabase", "getWritableDatabase", "writableDatabase", "<init>", "(Lcom/avito/android/db/DbHelper;)V", "Companion", "core_release"}, k = 1, mv = {1, 4, 2})
public class BaseDao {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public final DbHelper a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/db/BaseDao$Companion;", "", "Landroid/database/Cursor;", "cursor", "", "close", "(Landroid/database/Cursor;)V", "<init>", "()V", "core_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @JvmStatic
        public final void close(@Nullable Cursor cursor) {
            if (cursor != null) {
                cursor.close();
            }
        }

        public Companion(j jVar) {
        }
    }

    public BaseDao(@NotNull DbHelper dbHelper) {
        Intrinsics.checkNotNullParameter(dbHelper, "dbHelper");
        this.a = dbHelper;
    }

    @JvmStatic
    public static final void close(@Nullable Cursor cursor) {
        Companion.close(cursor);
    }

    public final void close() {
        this.a.close();
    }

    @NotNull
    public final SQLiteDatabase getReadableDatabase() {
        return this.a.getReadableDatabase();
    }

    @NotNull
    public final SQLiteDatabase getWritableDatabase() {
        return this.a.getWritableDatabase();
    }
}
