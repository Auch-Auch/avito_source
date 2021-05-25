package com.yandex.metrica.impl.ob;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class md implements mc {
    private final String a;
    private final HashMap<String, List<String>> b;

    public md(@NonNull String str, @NonNull HashMap<String, List<String>> hashMap) {
        this.a = str;
        this.b = hashMap;
    }

    @Override // com.yandex.metrica.impl.ob.mc
    public boolean a(SQLiteDatabase sQLiteDatabase) {
        boolean z = true;
        try {
            for (Map.Entry<String, List<String>> entry : this.b.entrySet()) {
                Cursor cursor = null;
                try {
                    cursor = sQLiteDatabase.query(entry.getKey(), null, null, null, null, null, null);
                    if (cursor == null) {
                        dl.a(cursor);
                        return false;
                    }
                    z &= a(cursor, entry.getKey(), entry.getValue());
                } finally {
                    dl.a(cursor);
                }
            }
            return z;
        } catch (Throwable unused) {
            return false;
        }
    }

    @VisibleForTesting
    public boolean a(@NonNull Cursor cursor, @NonNull String str, @NonNull List<String> list) {
        List asList = Arrays.asList(cursor.getColumnNames());
        Collections.sort(asList);
        return list.equals(asList);
    }
}
