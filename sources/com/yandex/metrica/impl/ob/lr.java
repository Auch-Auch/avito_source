package com.yandex.metrica.impl.ob;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.text.TextUtils;
import com.facebook.gamingservices.cloudgaming.internal.SDKAnalyticsEvents;
import com.yandex.metrica.impl.ob.al;
import com.yandex.metrica.impl.ob.i;
import com.yandex.metrica.impl.ob.lq;
import com.yandex.metrica.impl.ob.mi;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
public class lr implements Closeable {
    private final ReentrantReadWriteLock a;
    private final Lock b;
    private final Lock c;
    private final lu d;
    private final a e;
    private final Object f;
    private final List<ContentValues> g;
    private final Context h;
    private final fe i;
    private final AtomicLong j;
    @NonNull
    private final List<ow> k;
    @NonNull
    private final lq l;

    public lr(@NonNull fe feVar, lu luVar) {
        this(feVar, luVar, new lq(feVar.a()));
    }

    private long e() {
        this.b.lock();
        long j2 = 0;
        try {
            SQLiteDatabase readableDatabase = this.d.getReadableDatabase();
            if (readableDatabase != null) {
                j2 = aax.a(readableDatabase, "reports");
            }
        } catch (Throwable unused) {
        }
        this.b.unlock();
        return j2;
    }

    private void f() {
        Cursor cursor;
        this.b.lock();
        Cursor cursor2 = null;
        try {
            SQLiteDatabase readableDatabase = this.d.getReadableDatabase();
            if (readableDatabase != null) {
                Cursor rawQuery = readableDatabase.rawQuery(" SELECT DISTINCT id From sessions order by id asc ", new String[0]);
                try {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("All sessions in db: ");
                    while (rawQuery.moveToNext()) {
                        stringBuffer.append(rawQuery.getString(0));
                        stringBuffer.append(", ");
                    }
                    cursor2 = readableDatabase.rawQuery(" SELECT DISTINCT session_id From reports order by session_id asc ", new String[0]);
                    StringBuffer stringBuffer2 = new StringBuffer();
                    stringBuffer2.append("All sessions in reports db: ");
                    while (cursor2.moveToNext()) {
                        stringBuffer2.append(cursor2.getString(0));
                        stringBuffer2.append(", ");
                    }
                } catch (Throwable unused) {
                }
                cursor = cursor2;
                cursor2 = rawQuery;
                this.b.unlock();
                dl.a(cursor2);
                dl.a(cursor);
            }
        } catch (Throwable unused2) {
        }
        cursor = null;
        this.b.unlock();
        dl.a(cursor2);
        dl.a(cursor);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private int g(ContentValues contentValues) {
        return c(contentValues, "type");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.g.clear();
        this.e.a();
    }

    public lr(@NonNull fe feVar, lu luVar, @NonNull lq lqVar) {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.a = reentrantReadWriteLock;
        this.b = reentrantReadWriteLock.readLock();
        this.c = reentrantReadWriteLock.writeLock();
        this.f = new Object();
        this.g = new ArrayList(3);
        AtomicLong atomicLong = new AtomicLong();
        this.j = atomicLong;
        this.k = new ArrayList();
        this.d = luVar;
        this.h = feVar.k();
        this.i = feVar;
        this.l = lqVar;
        atomicLong.set(e());
        a aVar = new a(feVar);
        this.e = aVar;
        aVar.setName(a(feVar));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean g() {
        boolean isEmpty;
        synchronized (this.f) {
            isEmpty = this.g.isEmpty();
        }
        return isEmpty;
    }

    public long b() {
        this.b.lock();
        try {
            return this.j.get();
        } finally {
            this.b.unlock();
        }
    }

    public void c() {
        SQLiteDatabase writableDatabase;
        try {
            this.c.lock();
            if (this.j.get() > this.i.i().Z() && (writableDatabase = this.d.getWritableDatabase()) != null) {
                this.j.addAndGet((long) (-a(writableDatabase)));
            }
        } catch (Throwable unused) {
        }
        this.c.unlock();
    }

    @NonNull
    public List<ContentValues> d() {
        ArrayList arrayList = new ArrayList();
        this.b.lock();
        Cursor cursor = null;
        try {
            SQLiteDatabase readableDatabase = this.d.getReadableDatabase();
            if (readableDatabase != null) {
                cursor = readableDatabase.rawQuery(mi.g.c, null);
                while (cursor.moveToNext()) {
                    ContentValues contentValues = new ContentValues();
                    DatabaseUtils.cursorRowToContentValues(cursor, contentValues);
                    arrayList.add(contentValues);
                }
            }
        } catch (Throwable th) {
            dl.a((Cursor) null);
            this.b.unlock();
            throw th;
        }
        dl.a(cursor);
        this.b.unlock();
        return arrayList;
    }

    public class a extends acx {
        @Nullable
        private fe b;

        public a(fe feVar) {
            this.b = feVar;
        }

        public synchronized void a() {
            b();
            this.b = null;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            ArrayList arrayList;
            while (c()) {
                try {
                    synchronized (this) {
                        if (lr.this.g()) {
                            wait();
                        }
                    }
                } catch (Throwable unused) {
                    b();
                }
                synchronized (lr.this.f) {
                    arrayList = new ArrayList(lr.this.g);
                    lr.this.g.clear();
                }
                lr.this.a(arrayList);
                a(arrayList);
            }
        }

        public synchronized void a(@NonNull List<ContentValues> list) {
            ArrayList arrayList = new ArrayList();
            for (ContentValues contentValues : list) {
                arrayList.add(Integer.valueOf(lr.this.g(contentValues)));
            }
            for (ow owVar : lr.this.k) {
                owVar.a(arrayList);
            }
            fe feVar = this.b;
            if (feVar != null) {
                feVar.C().a();
            }
        }
    }

    public void a() {
        this.e.start();
    }

    public long a(@NonNull Set<Integer> set) {
        this.b.lock();
        Cursor cursor = null;
        long j2 = 0;
        try {
            SQLiteDatabase readableDatabase = this.d.getReadableDatabase();
            if (readableDatabase != null) {
                StringBuilder sb = new StringBuilder("SELECT count() FROM reports");
                if (!set.isEmpty()) {
                    sb.append(" WHERE ");
                }
                int i2 = 0;
                for (Integer num : set) {
                    if (i2 > 0) {
                        sb.append(" OR ");
                    }
                    sb.append("type == " + num);
                    i2++;
                }
                cursor = readableDatabase.rawQuery(sb.toString(), null);
                if (cursor.moveToFirst()) {
                    j2 = cursor.getLong(0);
                }
            }
        } catch (Throwable unused) {
        }
        dl.a(cursor);
        this.b.unlock();
        return j2;
    }

    private String e(ContentValues contentValues) {
        return b(contentValues, "name");
    }

    public void b(ContentValues contentValues) {
        synchronized (this.f) {
            this.g.add(contentValues);
        }
        synchronized (this.e) {
            this.e.notifyAll();
        }
    }

    private void c(ContentValues contentValues) {
        if (contentValues != null) {
            this.c.lock();
            try {
                SQLiteDatabase writableDatabase = this.d.getWritableDatabase();
                if (writableDatabase != null) {
                    writableDatabase.insertOrThrow("sessions", null, contentValues);
                }
            } catch (Throwable unused) {
            }
            this.c.unlock();
        }
    }

    private int c(ContentValues contentValues, String str) {
        return contentValues.getAsInteger(str).intValue();
    }

    public ContentValues b(long j2, jy jyVar) {
        ContentValues contentValues = new ContentValues();
        this.b.lock();
        Cursor cursor = null;
        try {
            SQLiteDatabase readableDatabase = this.d.getReadableDatabase();
            if (readableDatabase != null) {
                cursor = readableDatabase.rawQuery(String.format(Locale.US, "SELECT report_request_parameters FROM sessions WHERE id = %s AND type = %s ORDER BY id DESC LIMIT 1", Long.valueOf(j2), Integer.valueOf(jyVar.a())), null);
                if (cursor.moveToNext()) {
                    ContentValues contentValues2 = new ContentValues();
                    DatabaseUtils.cursorRowToContentValues(cursor, contentValues2);
                    contentValues = contentValues2;
                }
            }
        } catch (Throwable unused) {
        }
        dl.a(cursor);
        this.b.unlock();
        return contentValues;
    }

    private String f(ContentValues contentValues) {
        return b(contentValues, "value");
    }

    private static int d(ContentValues contentValues) {
        Integer asInteger = contentValues.getAsInteger("type");
        if (asInteger != null) {
            return asInteger.intValue();
        }
        return -1;
    }

    public void a(@NonNull ow owVar) {
        this.k.add(owVar);
    }

    private static String a(fk fkVar) {
        StringBuilder L = a2.b.a.a.a.L("DatabaseWorker [");
        L.append(fkVar.c().c());
        L.append("]");
        return L.toString();
    }

    public void a(long j2, jy jyVar, long j3) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", Long.valueOf(j2));
        contentValues.put("start_time", Long.valueOf(j3));
        contentValues.put("server_time_offset", Long.valueOf(abu.c()));
        contentValues.put("obtained_before_first_sync", Boolean.valueOf(abp.a().d()));
        contentValues.put("type", Integer.valueOf(jyVar.a()));
        new ac(this.h).a(this.i.i()).a(contentValues).a();
        a(contentValues);
    }

    private String b(ContentValues contentValues, String str) {
        return dh.b(contentValues.getAsString(str), "");
    }

    public void a(@NonNull aci aci, int i2, @NonNull jv jvVar, @NonNull i.a aVar, @NonNull fi fiVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("number", Long.valueOf(jvVar.c()));
        contentValues.put("global_number", Integer.valueOf(al.e(i2) ? fiVar.a() : 0));
        contentValues.put("number_of_type", Integer.valueOf(fiVar.a(i2)));
        contentValues.put("time", Long.valueOf(jvVar.d()));
        contentValues.put(SDKAnalyticsEvents.PARAMETER_SESSION_ID, Long.valueOf(jvVar.a()));
        contentValues.put("session_type", Integer.valueOf(jvVar.b().a()));
        new ac(this.h).a(this.i.i()).a(contentValues).a(aci, aVar);
        b(contentValues);
    }

    public void a(ContentValues contentValues) {
        c(contentValues);
    }

    public int a(long j2) {
        this.c.lock();
        int i2 = 0;
        try {
            if (mi.a.booleanValue()) {
                f();
            }
            SQLiteDatabase writableDatabase = this.d.getWritableDatabase();
            if (writableDatabase != null) {
                i2 = writableDatabase.delete("sessions", mi.g.d, new String[]{String.valueOf(j2)});
            }
        } catch (Throwable unused) {
        }
        this.c.unlock();
        return i2;
    }

    private int a(SQLiteDatabase sQLiteDatabase) {
        try {
            EnumSet<al.a> enumSet = al.a;
            Integer[] numArr = new Integer[enumSet.size()];
            Iterator it = enumSet.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                numArr[i2] = Integer.valueOf(((al.a) it.next()).a());
                i2++;
            }
            return this.l.a(sQLiteDatabase, "reports", String.format("%1$s NOT IN (%2$s) AND (%3$s IN (SELECT %3$s FROM %4$s ORDER BY %5$s, %6$s LIMIT (SELECT count() FROM %4$s) / %7$s ))", "type", TextUtils.join(",", numArr), "id", "reports", SDKAnalyticsEvents.PARAMETER_SESSION_ID, "number", 10), lq.b.DB_OVERFLOW, this.i.c().a(), true).b;
        } catch (Throwable th) {
            xa.a().reportError("deleteExcessiveReports exception", th);
            return 0;
        }
    }

    public void a(long j2, int i2, int i3, boolean z) throws SQLiteException {
        List<ContentValues> list;
        if (i3 > 0) {
            this.c.lock();
            try {
                String format = String.format(Locale.US, "%1$s = %2$s AND %3$s = %4$s AND %5$s <= (SELECT %5$s FROM %6$s WHERE %1$s = %2$s AND %3$s = %4$s ORDER BY %5$s ASC LIMIT %7$s, 1)", SDKAnalyticsEvents.PARAMETER_SESSION_ID, Long.toString(j2), "session_type", Integer.toString(i2), "id", "reports", Integer.toString(i3 - 1));
                SQLiteDatabase writableDatabase = this.d.getWritableDatabase();
                if (writableDatabase != null) {
                    lq.a a3 = this.l.a(writableDatabase, "reports", format, lq.b.BAD_REQUEST, this.i.c().a(), z);
                    if (a3.a != null) {
                        ArrayList arrayList = new ArrayList();
                        for (ContentValues contentValues : a3.a) {
                            arrayList.add(Integer.valueOf(g(contentValues)));
                        }
                        for (ow owVar : this.k) {
                            owVar.b(arrayList);
                        }
                    }
                    if (this.i.l().c() && (list = a3.a) != null) {
                        a(list, "Event removed from db");
                    }
                    this.j.addAndGet((long) (-a3.b));
                }
            } catch (Throwable unused) {
            }
            this.c.unlock();
        }
    }

    @Nullable
    public Cursor a(Map<String, String> map) {
        this.b.lock();
        Cursor cursor = null;
        try {
            SQLiteDatabase readableDatabase = this.d.getReadableDatabase();
            if (readableDatabase != null) {
                cursor = readableDatabase.query("sessions", null, a("id >= ?", map), a(new String[]{Long.toString(0)}, map), null, null, "id ASC", null);
            }
        } catch (Throwable unused) {
        }
        this.b.unlock();
        return cursor;
    }

    @Nullable
    public Cursor a(long j2, @NonNull jy jyVar) throws SQLiteException {
        this.b.lock();
        Cursor cursor = null;
        try {
            SQLiteDatabase readableDatabase = this.d.getReadableDatabase();
            if (readableDatabase != null) {
                cursor = readableDatabase.query("reports", null, "session_id = ? AND session_type = ?", new String[]{Long.toString(j2), Integer.toString(jyVar.a())}, null, null, "number ASC", null);
            }
        } catch (Throwable unused) {
        }
        this.b.unlock();
        return cursor;
    }

    @VisibleForTesting
    public void a(List<ContentValues> list) {
        if (!(list == null || list.isEmpty())) {
            this.c.lock();
            SQLiteDatabase sQLiteDatabase = null;
            try {
                SQLiteDatabase writableDatabase = this.d.getWritableDatabase();
                if (writableDatabase != null) {
                    try {
                        writableDatabase.beginTransaction();
                        for (ContentValues contentValues : list) {
                            writableDatabase.insertOrThrow("reports", null, contentValues);
                            this.j.incrementAndGet();
                            a(contentValues, "Event saved to db");
                        }
                        writableDatabase.setTransactionSuccessful();
                        this.j.get();
                    } catch (Throwable unused) {
                        sQLiteDatabase = writableDatabase;
                        dl.a(sQLiteDatabase);
                        this.c.unlock();
                    }
                }
                dl.a(writableDatabase);
            } catch (Throwable unused2) {
                dl.a(sQLiteDatabase);
                this.c.unlock();
            }
            this.c.unlock();
        }
    }

    private void a(ContentValues contentValues, String str) {
        if (al.b(d(contentValues))) {
            StringBuilder sb = new StringBuilder(str);
            sb.append(": ");
            sb.append(e(contentValues));
            String f2 = f(contentValues);
            if (al.c(g(contentValues)) && !TextUtils.isEmpty(f2)) {
                sb.append(" with value ");
                sb.append(f2);
            }
            this.i.l().a(sb.toString());
        }
    }

    private void a(List<ContentValues> list, String str) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            a(list.get(i2), str);
        }
    }

    private static String a(String str, Map<String, String> map) {
        StringBuilder sb = new StringBuilder(str);
        for (String str2 : map.keySet()) {
            sb.append(sb.length() > 0 ? " AND " : "");
            sb.append(str2 + " = ? ");
        }
        if (TextUtils.isEmpty(sb.toString())) {
            return null;
        }
        return sb.toString();
    }

    private static String[] a(String[] strArr, Map<String, String> map) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(Arrays.asList(strArr));
        for (Map.Entry<String, String> entry : map.entrySet()) {
            arrayList.add(entry.getValue());
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }
}
