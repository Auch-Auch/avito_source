package com.yandex.metrica.impl.ob;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
public abstract class lo {
    @NonNull
    private final lu a;
    @NonNull
    private final mq b;
    @NonNull
    private final AtomicLong c;
    @NonNull
    private final AtomicLong d;
    @NonNull
    private final AtomicLong e;
    @NonNull
    private final ContentValues f = new ContentValues();

    public lo(@NonNull lu luVar, @NonNull mq mqVar) {
        this.a = luVar;
        this.b = mqVar;
        this.c = new AtomicLong(f());
        this.d = new AtomicLong(a(Long.MAX_VALUE));
        this.e = new AtomicLong(c(-1L));
    }

    private long f() {
        try {
            SQLiteDatabase readableDatabase = d().getReadableDatabase();
            if (readableDatabase != null) {
                return aax.a(readableDatabase, e());
            }
            return 0;
        } catch (Throwable unused) {
            return 0;
        }
    }

    public long a() {
        return this.c.get();
    }

    public long b() {
        return this.d.get();
    }

    public abstract long c(long j);

    @NonNull
    public mq c() {
        return this.b;
    }

    @NonNull
    public lu d() {
        return this.a;
    }

    public abstract mq d(long j);

    public abstract String e();

    @NonNull
    private ContentValues c(long j, @NonNull String str) {
        this.f.clear();
        this.f.put("incremental_id", Long.valueOf(this.e.get() + 1));
        this.f.put("timestamp", Long.valueOf(j));
        this.f.put("data", str);
        return this.f;
    }

    public void a(long j, String str) {
        this.c.incrementAndGet();
        this.e.incrementAndGet();
        d(this.e.get()).q();
        if (this.d.get() > j) {
            this.d.set(j);
        }
    }

    public synchronized void b(long j, String str) {
        try {
            SQLiteDatabase writableDatabase = d().getWritableDatabase();
            if (writableDatabase != null) {
                if (writableDatabase.insert(e(), null, c(j, str)) != -1) {
                    a(j, str);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public void a(int i) {
        this.c.getAndAdd((long) (-i));
        this.d.set(a(Long.MAX_VALUE));
    }

    @NonNull
    public synchronized Map<Long, String> b(int i) {
        LinkedHashMap linkedHashMap;
        linkedHashMap = new LinkedHashMap();
        Cursor cursor = null;
        try {
            SQLiteDatabase readableDatabase = d().getReadableDatabase();
            if (readableDatabase != null) {
                cursor = readableDatabase.query(e(), new String[]{"incremental_id", "data"}, null, null, null, null, "incremental_id ASC", String.valueOf(i));
                while (cursor.moveToNext()) {
                    this.f.clear();
                    aax.a(cursor, this.f);
                    aav.a(linkedHashMap, this.f.getAsLong("incremental_id"), this.f.getAsString("data"));
                }
            }
        } catch (Throwable unused) {
        }
        dl.a(cursor);
        return linkedHashMap;
    }

    public synchronized int c(int i) {
        int i2 = 0;
        if (i < 1) {
            return 0;
        }
        String format = String.format(Locale.US, "%1$s <= (select max(%1$s) from (select %1$s from %2$s order by %1$s limit ?))", "incremental_id", e());
        try {
            SQLiteDatabase writableDatabase = d().getWritableDatabase();
            if (writableDatabase != null && (i2 = writableDatabase.delete(e(), format, new String[]{String.valueOf(i)})) > 0) {
                a(i2);
            }
        } catch (Throwable unused) {
        }
        return i2;
    }

    public long a(long j) {
        String format = String.format(Locale.US, "Select min(%s) from %s", "timestamp", e());
        Cursor cursor = null;
        try {
            SQLiteDatabase readableDatabase = d().getReadableDatabase();
            if (readableDatabase != null) {
                cursor = readableDatabase.rawQuery(format, null);
                if (cursor.moveToFirst()) {
                    long j2 = cursor.getLong(0);
                    if (j2 != 0) {
                        j = j2;
                    }
                }
            }
        } catch (Throwable unused) {
        }
        dl.a(cursor);
        return j;
    }

    public synchronized int b(long j) {
        int i;
        i = 0;
        String format = String.format(Locale.US, "%s <= ?", "incremental_id");
        try {
            SQLiteDatabase writableDatabase = d().getWritableDatabase();
            if (writableDatabase != null && (i = writableDatabase.delete(e(), format, new String[]{String.valueOf(j)})) > 0) {
                a(i);
            }
        } catch (Throwable unused) {
        }
        return i;
    }
}
