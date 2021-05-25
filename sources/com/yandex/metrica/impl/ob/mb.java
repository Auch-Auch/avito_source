package com.yandex.metrica.impl.ob;

import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import android.util.SparseArray;
public class mb {
    private final String a;
    private final mj b;
    private final mj c;
    private final SparseArray<mj> d;
    private final mc e;

    public static class a {
        public mb a(@NonNull String str, @NonNull mj mjVar, @NonNull mj mjVar2, @NonNull SparseArray<mj> sparseArray, @NonNull mc mcVar) {
            return new mb(str, mjVar, mjVar2, sparseArray, mcVar);
        }
    }

    public void a(SQLiteDatabase sQLiteDatabase) {
        try {
            mc mcVar = this.e;
            if (mcVar != null && !mcVar.a(sQLiteDatabase)) {
                c(sQLiteDatabase);
            }
        } catch (Throwable unused) {
        }
    }

    public void b(SQLiteDatabase sQLiteDatabase) {
        a(this.b, sQLiteDatabase);
    }

    @VisibleForTesting
    public void c(SQLiteDatabase sQLiteDatabase) {
        b(this.c, sQLiteDatabase);
        a(this.b, sQLiteDatabase);
    }

    private mb(String str, mj mjVar, mj mjVar2, SparseArray<mj> sparseArray, mc mcVar) {
        this.a = str;
        this.b = mjVar;
        this.c = mjVar2;
        this.d = sparseArray;
        this.e = mcVar;
    }

    private void b(mj mjVar, SQLiteDatabase sQLiteDatabase) {
        try {
            mjVar.a(sQLiteDatabase);
        } catch (Throwable unused) {
        }
    }

    @VisibleForTesting
    public void a(mj mjVar, SQLiteDatabase sQLiteDatabase) {
        try {
            mjVar.a(sQLiteDatabase);
        } catch (Throwable unused) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0022  */
    /* JADX WARNING: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.database.sqlite.SQLiteDatabase r4, int r5, int r6) {
        /*
            r3 = this;
            r0 = 1
            if (r6 <= r5) goto L_0x0017
            r1 = 0
            int r5 = r5 + r0
        L_0x0005:
            if (r5 > r6) goto L_0x0018
            android.util.SparseArray<com.yandex.metrica.impl.ob.mj> r2 = r3.d     // Catch:{ all -> 0x0017 }
            java.lang.Object r2 = r2.get(r5)     // Catch:{ all -> 0x0017 }
            com.yandex.metrica.impl.ob.mj r2 = (com.yandex.metrica.impl.ob.mj) r2     // Catch:{ all -> 0x0017 }
            if (r2 == 0) goto L_0x0014
            r2.a(r4)     // Catch:{ all -> 0x0017 }
        L_0x0014:
            int r5 = r5 + 1
            goto L_0x0005
        L_0x0017:
            r1 = 1
        L_0x0018:
            com.yandex.metrica.impl.ob.mc r5 = r3.e
            boolean r5 = r5.a(r4)
            r5 = r5 ^ r0
            r5 = r5 | r1
            if (r5 == 0) goto L_0x0025
            r3.c(r4)
        L_0x0025:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yandex.metrica.impl.ob.mb.a(android.database.sqlite.SQLiteDatabase, int, int):void");
    }
}
