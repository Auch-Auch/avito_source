package com.yandex.metrica.impl.ob;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
public class lp {
    @NonNull
    private final me a;
    @NonNull
    private final String b;

    public lp(@NonNull me meVar, @NonNull String str) {
        this.a = meVar;
        this.b = str;
    }

    public void a(@NonNull String str, @NonNull byte[] bArr) {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            SQLiteDatabase a3 = this.a.a();
            if (a3 != null) {
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("data_key", str);
                    contentValues.put("value", bArr);
                    a3.insertWithOnConflict(this.b, null, contentValues, 5);
                } catch (Throwable unused) {
                    sQLiteDatabase = a3;
                }
            }
            this.a.a(a3);
        } catch (Throwable unused2) {
            this.a.a(sQLiteDatabase);
        }
    }

    public byte[] a(@NonNull String str) {
        Cursor cursor;
        SQLiteDatabase sQLiteDatabase;
        try {
            sQLiteDatabase = this.a.a();
            if (sQLiteDatabase != null) {
                try {
                    cursor = sQLiteDatabase.query(this.b, null, "data_key = ?", new String[]{str}, null, null, null);
                    if (cursor != null) {
                        try {
                            if (cursor.getCount() == 1 && cursor.moveToFirst()) {
                                byte[] blob = cursor.getBlob(cursor.getColumnIndex("value"));
                                dl.a(cursor);
                                this.a.a(sQLiteDatabase);
                                return blob;
                            }
                        } catch (Throwable unused) {
                        }
                    }
                    dl.b(cursor);
                } catch (Throwable unused2) {
                }
                dl.a(cursor);
                this.a.a(sQLiteDatabase);
                return null;
            }
            cursor = null;
        } catch (Throwable unused3) {
            cursor = null;
            sQLiteDatabase = null;
        }
        dl.a(cursor);
        this.a.a(sQLiteDatabase);
        return null;
    }
}
