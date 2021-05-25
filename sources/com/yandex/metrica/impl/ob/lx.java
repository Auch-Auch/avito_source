package com.yandex.metrica.impl.ob;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
public class lx {
    public static final String a = "lx";
    private final Map<String, Object> b;
    private final Map<String, Object> c;
    private final String d;
    private final a e;
    private volatile boolean f;
    private final me g;

    public class a extends acx {
        public a(String str) {
            super(str);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            HashMap hashMap;
            synchronized (lx.this.b) {
                lx.this.c();
                lx.this.f = true;
                lx.this.b.notifyAll();
            }
            while (c()) {
                synchronized (this) {
                    if (lx.this.c.size() == 0) {
                        try {
                            wait();
                        } catch (InterruptedException unused) {
                        }
                    }
                    hashMap = new HashMap(lx.this.c);
                    lx.this.c.clear();
                }
                if (hashMap.size() > 0) {
                    lx.this.a(hashMap);
                    hashMap.clear();
                }
            }
        }
    }

    public lx(lu luVar, String str) {
        this(str, new mh(luVar));
    }

    private void d() {
        if (!this.f) {
            try {
                this.b.wait();
            } catch (InterruptedException unused) {
            }
        }
    }

    public lx(String str, me meVar) {
        this.b = new HashMap();
        this.c = new HashMap();
        this.g = meVar;
        this.d = str;
        a aVar = new a(String.format(Locale.US, "YMM-DW-%s", Integer.valueOf(acy.b())));
        this.e = aVar;
        aVar.start();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x007c A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0021 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void c() {
        /*
            r13 = this;
            java.lang.String r0 = "type"
            java.lang.String r1 = "value"
            java.lang.String r2 = "key"
            r3 = 0
            com.yandex.metrica.impl.ob.me r4 = r13.g     // Catch:{ all -> 0x0084 }
            android.database.sqlite.SQLiteDatabase r4 = r4.a()     // Catch:{ all -> 0x0084 }
            if (r4 == 0) goto L_0x0085
            java.lang.String r6 = r13.a()     // Catch:{ all -> 0x0085 }
            java.lang.String[] r7 = new java.lang.String[]{r2, r1, r0}     // Catch:{ all -> 0x0085 }
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r5 = r4
            android.database.Cursor r5 = r5.query(r6, r7, r8, r9, r10, r11, r12)     // Catch:{ all -> 0x0085 }
        L_0x0021:
            boolean r6 = r5.moveToNext()     // Catch:{ all -> 0x0082 }
            if (r6 == 0) goto L_0x0082
            int r6 = r5.getColumnIndex(r2)     // Catch:{ all -> 0x0082 }
            java.lang.String r6 = r5.getString(r6)     // Catch:{ all -> 0x0082 }
            int r7 = r5.getColumnIndex(r1)     // Catch:{ all -> 0x0082 }
            java.lang.String r7 = r5.getString(r7)     // Catch:{ all -> 0x0082 }
            int r8 = r5.getColumnIndex(r0)     // Catch:{ all -> 0x0082 }
            int r8 = r5.getInt(r8)     // Catch:{ all -> 0x0082 }
            boolean r9 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x0082 }
            if (r9 != 0) goto L_0x0021
            r9 = 1
            if (r8 == r9) goto L_0x0065
            r9 = 2
            if (r8 == r9) goto L_0x0060
            r9 = 3
            if (r8 == r9) goto L_0x005b
            r9 = 4
            if (r8 == r9) goto L_0x007a
            r9 = 5
            if (r8 == r9) goto L_0x0056
        L_0x0054:
            r7 = r3
            goto L_0x007a
        L_0x0056:
            java.lang.Float r7 = com.yandex.metrica.impl.ob.abk.b(r7)     // Catch:{ all -> 0x0082 }
            goto L_0x007a
        L_0x005b:
            java.lang.Long r7 = com.yandex.metrica.impl.ob.abk.a(r7)     // Catch:{ all -> 0x0082 }
            goto L_0x007a
        L_0x0060:
            java.lang.Integer r7 = com.yandex.metrica.impl.ob.abk.c(r7)     // Catch:{ all -> 0x0082 }
            goto L_0x007a
        L_0x0065:
            java.lang.String r8 = "true"
            boolean r8 = r8.equals(r7)     // Catch:{ all -> 0x0082 }
            if (r8 == 0) goto L_0x0070
            java.lang.Boolean r7 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x0082 }
            goto L_0x007a
        L_0x0070:
            java.lang.String r8 = "false"
            boolean r7 = r8.equals(r7)     // Catch:{ all -> 0x0082 }
            if (r7 == 0) goto L_0x0054
            java.lang.Boolean r7 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x0082 }
        L_0x007a:
            if (r7 == 0) goto L_0x0021
            java.util.Map<java.lang.String, java.lang.Object> r8 = r13.b     // Catch:{ all -> 0x0082 }
            r8.put(r6, r7)     // Catch:{ all -> 0x0082 }
            goto L_0x0021
        L_0x0082:
            r3 = r5
            goto L_0x0085
        L_0x0084:
            r4 = r3
        L_0x0085:
            com.yandex.metrica.impl.ob.dl.a(r3)
            com.yandex.metrica.impl.ob.me r0 = r13.g
            r0.a(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yandex.metrica.impl.ob.lx.c():void");
    }

    public void b() {
        synchronized (this.e) {
            this.e.notifyAll();
        }
    }

    public String a() {
        return this.d;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void a(Map<String, Object> map) {
        ContentValues[] contentValuesArr = new ContentValues[map.size()];
        int i = 0;
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            ContentValues contentValues = new ContentValues();
            Object value = entry.getValue();
            contentValues.put("key", entry.getKey());
            if (value == this) {
                contentValues.putNull("value");
            } else if (value instanceof String) {
                contentValues.put("value", (String) value);
                contentValues.put("type", (Integer) 4);
            } else if (value instanceof Long) {
                contentValues.put("value", (Long) value);
                contentValues.put("type", (Integer) 3);
            } else if (value instanceof Integer) {
                contentValues.put("value", (Integer) value);
                contentValues.put("type", (Integer) 2);
            } else if (value instanceof Boolean) {
                contentValues.put("value", String.valueOf(((Boolean) value).booleanValue()));
                contentValues.put("type", (Integer) 1);
            } else if (value instanceof Float) {
                contentValues.put("value", (Float) value);
                contentValues.put("type", (Integer) 5);
            }
            contentValuesArr[i] = contentValues;
            i++;
        }
        a(contentValuesArr);
    }

    public synchronized lx b(String str, String str2) {
        a(str, (Object) str2);
        return this;
    }

    public lx b(String str, long j) {
        a(str, Long.valueOf(j));
        return this;
    }

    public synchronized lx b(String str, int i) {
        a(str, Integer.valueOf(i));
        return this;
    }

    public lx b(String str, boolean z) {
        a(str, Boolean.valueOf(z));
        return this;
    }

    public boolean b(@NonNull String str) {
        boolean containsKey;
        synchronized (this.b) {
            d();
            containsKey = this.b.containsKey(str);
        }
        return containsKey;
    }

    private Object c(String str) {
        Object obj;
        synchronized (this.b) {
            d();
            obj = this.b.get(str);
        }
        return obj;
    }

    private void a(ContentValues[] contentValuesArr) {
        if (contentValuesArr != null) {
            SQLiteDatabase sQLiteDatabase = null;
            try {
                SQLiteDatabase a3 = this.g.a();
                if (a3 != null) {
                    try {
                        a3.beginTransaction();
                        for (ContentValues contentValues : contentValuesArr) {
                            if (contentValues.getAsString("value") == null) {
                                a3.delete(a(), "key = ?", new String[]{contentValues.getAsString("key")});
                            } else {
                                a3.insertWithOnConflict(a(), null, contentValues, 5);
                            }
                        }
                        a3.setTransactionSuccessful();
                    } catch (Throwable unused) {
                        sQLiteDatabase = a3;
                        dl.a(sQLiteDatabase);
                        this.g.a(sQLiteDatabase);
                    }
                }
                dl.a(a3);
                this.g.a(a3);
            } catch (Throwable unused2) {
                dl.a(sQLiteDatabase);
                this.g.a(sQLiteDatabase);
            }
        }
    }

    @Nullable
    public String a(String str, String str2) {
        Object c2 = c(str);
        return c2 instanceof String ? (String) c2 : str2;
    }

    public int a(String str, int i) {
        Object c2 = c(str);
        return c2 instanceof Integer ? ((Integer) c2).intValue() : i;
    }

    public long a(String str, long j) {
        Object c2 = c(str);
        return c2 instanceof Long ? ((Long) c2).longValue() : j;
    }

    public boolean a(String str, boolean z) {
        Object c2 = c(str);
        return c2 instanceof Boolean ? ((Boolean) c2).booleanValue() : z;
    }

    public lx a(String str) {
        synchronized (this.b) {
            d();
            this.b.remove(str);
        }
        synchronized (this.e) {
            this.c.put(str, this);
            this.e.notifyAll();
        }
        return this;
    }

    @VisibleForTesting
    public void a(String str, Object obj) {
        synchronized (this.b) {
            d();
            this.b.put(str, obj);
        }
        synchronized (this.e) {
            this.c.put(str, obj);
            this.e.notifyAll();
        }
    }
}
