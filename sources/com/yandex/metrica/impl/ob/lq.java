package com.yandex.metrica.impl.ob;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import com.yandex.metrica.CounterConfiguration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import org.spongycastle.i18n.ErrorBundle;
public class lq {
    @NonNull
    private final CounterConfiguration.a a;
    @Nullable
    private final cz b;

    public static class a {
        @Nullable
        public final List<ContentValues> a;
        public final int b;

        public a(@Nullable List<ContentValues> list, int i) {
            this.a = list;
            this.b = i;
        }
    }

    public enum b {
        BAD_REQUEST("bad_request"),
        DB_OVERFLOW("db_overflow");
        
        private final String c;

        private b(String str) {
            this.c = str;
        }
    }

    public lq(@NonNull CounterConfiguration.a aVar) {
        this(aVar, as.a().q());
    }

    @Nullable
    private List<ContentValues> a(@Nullable Cursor cursor) {
        if (cursor == null || cursor.getCount() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(cursor.getCount());
        while (cursor.moveToNext()) {
            ContentValues contentValues = new ContentValues();
            DatabaseUtils.cursorRowToContentValues(cursor, contentValues);
            arrayList.add(contentValues);
        }
        return arrayList;
    }

    private void b(@NonNull List<ContentValues> list, @NonNull b bVar, @Nullable String str, int i) {
        cz czVar;
        if (str != null && (czVar = this.b) != null) {
            cy a3 = czVar.a(str, this.a);
            aa a4 = a(list, bVar, str, i);
            if (a4 != null) {
                a3.a(a4);
            }
        }
    }

    @VisibleForTesting
    public lq(@NonNull CounterConfiguration.a aVar, @Nullable cz czVar) {
        this.a = aVar;
        this.b = czVar;
    }

    @NonNull
    public a a(@NonNull SQLiteDatabase sQLiteDatabase, @NonNull String str, @NonNull String str2, @NonNull b bVar, @Nullable String str3, boolean z) {
        List<ContentValues> a3 = a(sQLiteDatabase, str, str2);
        int i = 0;
        if (!dl.a((Collection) a3)) {
            try {
                i = sQLiteDatabase.delete(str, str2, null);
            } catch (Throwable unused) {
            }
            if (z) {
                b(a3, bVar, str3, i);
            }
            a3.size();
        } else {
            HashMap k0 = a2.b.a.a.a.k0("table_name", str);
            k0.put("api_key", String.valueOf(str3));
            xa.a().reportEvent("select_rows_to_delete_failed", k0);
        }
        return new a(a3, i);
    }

    @Nullable
    private List<ContentValues> a(@NonNull SQLiteDatabase sQLiteDatabase, @NonNull String str, @NonNull String str2) {
        Cursor cursor;
        Throwable th;
        List<ContentValues> list = null;
        try {
            cursor = sQLiteDatabase.rawQuery(String.format("SELECT %s, %s, %s FROM %s WHERE %s", "global_number", "type", "number_of_type", "reports", str2), null);
            try {
                list = a(cursor);
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
            try {
                xa.a().reportError("select_rows_to_delete_exception", th);
                dl.a(cursor);
                return list;
            } catch (Throwable th4) {
                dl.a(cursor);
                throw th4;
            }
        }
        dl.a(cursor);
        return list;
    }

    @Nullable
    private aa a(@NonNull List<ContentValues> list, @NonNull b bVar, @Nullable String str, int i) {
        abl abl;
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            JSONArray jSONArray2 = new JSONArray();
            JSONArray jSONArray3 = new JSONArray();
            for (ContentValues contentValues : list) {
                Integer asInteger = contentValues.getAsInteger("global_number");
                Integer asInteger2 = contentValues.getAsInteger("type");
                Integer asInteger3 = contentValues.getAsInteger("number_of_type");
                if (!(asInteger == null || asInteger2 == null || asInteger3 == null)) {
                    jSONArray.put(asInteger);
                    jSONArray2.put(asInteger2);
                    jSONArray3.put(asInteger3);
                }
            }
            jSONObject.put("global_number", jSONArray).put("event_type", jSONArray2).put("number_of_type", jSONArray3);
            JSONObject put = new JSONObject().put(ErrorBundle.DETAIL_ENTRY, new JSONObject().put("reason", bVar.c).put("cleared", jSONObject).put("actual_deleted_number", i));
            if (str == null) {
                abl = abd.a();
            } else {
                abl = abd.a(str);
            }
            return al.i(put.toString(), abl);
        } catch (Throwable unused) {
            return null;
        }
    }
}
