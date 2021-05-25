package com.google.android.datatransport.runtime.scheduling.persistence;

import a2.b.a.a.a;
import a2.j.b.a.c.m.d.o;
import a2.j.b.a.c.m.d.p;
import a2.j.b.a.c.m.d.q;
import a2.j.b.a.c.m.d.r;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.Arrays;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
public final class SchemaManager extends SQLiteOpenHelper {
    public static final List<Migration> c = Arrays.asList(o.a, p.a, q.a, r.a);
    public final int a;
    public boolean b = false;

    public interface Migration {
        void upgrade(SQLiteDatabase sQLiteDatabase);
    }

    @Inject
    public SchemaManager(Context context, @Named("SQLITE_DB_NAME") String str, @Named("SCHEMA_VERSION") int i) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, i);
        this.a = i;
    }

    public final void a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        List<Migration> list = c;
        if (i2 <= list.size()) {
            while (i < i2) {
                c.get(i).upgrade(sQLiteDatabase);
                i++;
            }
            return;
        }
        StringBuilder N = a.N("Migration from ", i, " to ", i2, " was requested, but cannot be performed. Only ");
        N.append(list.size());
        N.append(" migrations are provided");
        throw new IllegalArgumentException(N.toString());
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onConfigure(SQLiteDatabase sQLiteDatabase) {
        this.b = true;
        sQLiteDatabase.rawQuery("PRAGMA busy_timeout=0;", new String[0]).close();
        sQLiteDatabase.setForeignKeyConstraintsEnabled(true);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        int i = this.a;
        if (!this.b) {
            onConfigure(sQLiteDatabase);
        }
        a(sQLiteDatabase, 0, i);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE events");
        sQLiteDatabase.execSQL("DROP TABLE event_metadata");
        sQLiteDatabase.execSQL("DROP TABLE transport_contexts");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS event_payloads");
        if (!this.b) {
            onConfigure(sQLiteDatabase);
        }
        a(sQLiteDatabase, 0, i2);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        if (!this.b) {
            onConfigure(sQLiteDatabase);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (!this.b) {
            onConfigure(sQLiteDatabase);
        }
        a(sQLiteDatabase, i, i2);
    }
}
