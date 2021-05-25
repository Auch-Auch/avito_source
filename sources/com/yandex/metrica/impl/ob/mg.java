package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.support.annotation.WorkerThread;
import java.io.Closeable;
public class mg implements me {
    private final Context a;
    private final String b;
    @NonNull
    private final ls c;
    @NonNull
    private final mf d;
    private lu e;

    public mg(Context context, String str) {
        this(context, str, new mf(context, str), mi.a());
    }

    @Override // com.yandex.metrica.impl.ob.me
    @WorkerThread
    @Nullable
    public synchronized SQLiteDatabase a() {
        lu luVar;
        try {
            this.d.a();
            luVar = new lu(this.a, this.b, this.c.c());
            this.e = luVar;
        } catch (Throwable unused) {
            return null;
        }
        return luVar.getWritableDatabase();
    }

    @VisibleForTesting
    public mg(@NonNull Context context, @NonNull String str, @NonNull mf mfVar, @NonNull ls lsVar) {
        this.a = context;
        this.b = str;
        this.d = mfVar;
        this.c = lsVar;
    }

    @Override // com.yandex.metrica.impl.ob.me
    @WorkerThread
    public synchronized void a(@Nullable SQLiteDatabase sQLiteDatabase) {
        dl.b(sQLiteDatabase);
        dl.a((Closeable) this.e);
        this.d.b();
        this.e = null;
    }
}
