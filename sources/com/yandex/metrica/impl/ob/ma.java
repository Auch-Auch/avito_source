package com.yandex.metrica.impl.ob;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import java.util.ArrayList;
import java.util.List;
public class ma {
    @NonNull
    private final me a;
    @NonNull
    private String b;

    public ma(lu luVar, @NonNull String str) {
        this(new mh(luVar), str);
    }

    @Nullable
    public List<sr> a() {
        Cursor cursor;
        SQLiteDatabase sQLiteDatabase;
        try {
            sQLiteDatabase = this.a.a();
            if (sQLiteDatabase != null) {
                try {
                    cursor = sQLiteDatabase.query(this.b, null, null, null, null, null, null);
                    if (cursor != null) {
                        try {
                            if (cursor.moveToFirst()) {
                                ArrayList arrayList = new ArrayList();
                                do {
                                    arrayList.add(new sr(cursor.getString(cursor.getColumnIndex("name")), cursor.getLong(cursor.getColumnIndex("granted")) == 1));
                                } while (cursor.moveToNext());
                                this.a.a(sQLiteDatabase);
                                dl.a(cursor);
                                return arrayList;
                            }
                        } catch (Throwable unused) {
                        }
                    }
                } catch (Throwable unused2) {
                }
                this.a.a(sQLiteDatabase);
                dl.a(cursor);
                return null;
            }
            cursor = null;
        } catch (Throwable unused3) {
            sQLiteDatabase = null;
            cursor = null;
        }
        this.a.a(sQLiteDatabase);
        dl.a(cursor);
        return null;
    }

    public void b() {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            sQLiteDatabase = this.a.a();
            if (sQLiteDatabase != null) {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS permissions");
            }
        } catch (Throwable unused) {
        }
        this.a.a(sQLiteDatabase);
    }

    @VisibleForTesting
    public ma(@NonNull me meVar, @NonNull String str) {
        this.a = meVar;
        this.b = str;
    }
}
