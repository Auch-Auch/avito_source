package com.yandex.metrica.impl.ob;

import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.Nullable;
public class mh implements me {
    private final lu a;

    public mh(lu luVar) {
        this.a = luVar;
    }

    @Override // com.yandex.metrica.impl.ob.me
    @Nullable
    public SQLiteDatabase a() {
        try {
            return this.a.getWritableDatabase();
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.yandex.metrica.impl.ob.me
    public void a(@Nullable SQLiteDatabase sQLiteDatabase) {
    }
}
