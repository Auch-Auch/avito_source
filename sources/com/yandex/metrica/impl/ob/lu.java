package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import java.io.Closeable;
public class lu extends SQLiteOpenHelper implements Closeable {
    public final mb a;
    @NonNull
    private final String b;
    private final abl c;

    public lu(Context context, @NonNull String str, mb mbVar) {
        this(context, str, mbVar, abd.a());
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    @Nullable
    public SQLiteDatabase getReadableDatabase() {
        try {
            return super.getReadableDatabase();
        } catch (Throwable th) {
            this.c.a(th, "", new Object[0]);
            this.c.c("Could not get readable database %s due to an exception. AppMetrica SDK may behave unexpectedly.", this.b);
            xa.a().reportError("db_read_error", th);
            return null;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    @Nullable
    public SQLiteDatabase getWritableDatabase() {
        try {
            return super.getWritableDatabase();
        } catch (Throwable th) {
            this.c.a(th, "", new Object[0]);
            this.c.c("Could not get writable database %s due to an exception. AppMetrica SDK may behave unexpectedly.", this.b);
            xa.a().reportError("db_write_error", th);
            return null;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        this.a.b(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        super.onOpen(sQLiteDatabase);
        this.a.a(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        this.a.a(sQLiteDatabase, i, i2);
    }

    @VisibleForTesting
    public lu(Context context, @NonNull String str, mb mbVar, @NonNull abl abl) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, mi.b);
        this.a = mbVar;
        this.b = str;
        this.c = abl;
    }
}
