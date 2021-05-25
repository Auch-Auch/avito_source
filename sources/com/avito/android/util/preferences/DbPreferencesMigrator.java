package com.avito.android.util.preferences;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.avito.android.db.preferences.SharedPreferencesTable;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.preferences.db_preferences.Types;
import com.facebook.appevents.UserDataStore;
import com.google.gson.Gson;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\u0006\u0010\u0019\u001a\u00020\u0016¢\u0006\u0004\b \u0010!J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J'\u0010\b\u001a\u00020\u0002*\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00052\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0019\u0010\u001f\u001a\u00020\u001a8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006\""}, d2 = {"Lcom/avito/android/util/preferences/DbPreferencesMigrator;", "", "", "migrate", "()V", "", "", "file", "migrateValues", "(Ljava/util/Map;Ljava/lang/String;)V", "Landroid/content/Context;", AuthSource.BOOKING_ORDER, "Landroid/content/Context;", "context", "Landroid/database/sqlite/SQLiteDatabase;", "c", "Landroid/database/sqlite/SQLiteDatabase;", UserDataStore.DATE_OF_BIRTH, "Lcom/google/gson/Gson;", "d", "Lcom/google/gson/Gson;", "gson", "Lcom/avito/android/util/preferences/PreferenceFactory;", "e", "Lcom/avito/android/util/preferences/PreferenceFactory;", "factory", "Lcom/avito/android/db/preferences/SharedPreferencesTable;", AuthSource.SEND_ABUSE, "Lcom/avito/android/db/preferences/SharedPreferencesTable;", "getTable", "()Lcom/avito/android/db/preferences/SharedPreferencesTable;", "table", "<init>", "(Landroid/content/Context;Landroid/database/sqlite/SQLiteDatabase;Lcom/google/gson/Gson;Lcom/avito/android/util/preferences/PreferenceFactory;)V", "core_release"}, k = 1, mv = {1, 4, 2})
public final class DbPreferencesMigrator {
    @NotNull
    public final SharedPreferencesTable a = new SharedPreferencesTable();
    public final Context b;
    public final SQLiteDatabase c;
    public final Gson d;
    public final PreferenceFactory e;

    public DbPreferencesMigrator(@NotNull Context context, @NotNull SQLiteDatabase sQLiteDatabase, @NotNull Gson gson, @NotNull PreferenceFactory preferenceFactory) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sQLiteDatabase, UserDataStore.DATE_OF_BIRTH);
        Intrinsics.checkNotNullParameter(gson, "gson");
        Intrinsics.checkNotNullParameter(preferenceFactory, "factory");
        this.b = context;
        this.c = sQLiteDatabase;
        this.d = gson;
        this.e = preferenceFactory;
    }

    public static final String access$getStringForValue(DbPreferencesMigrator dbPreferencesMigrator, Object obj) {
        Objects.requireNonNull(dbPreferencesMigrator);
        if (!(obj instanceof Set)) {
            return String.valueOf(obj);
        }
        String json = dbPreferencesMigrator.d.toJson(obj);
        Intrinsics.checkNotNullExpressionValue(json, "gson.toJson(value)");
        return json;
    }

    public static final String access$getTypeFor(DbPreferencesMigrator dbPreferencesMigrator, Object obj) {
        Objects.requireNonNull(dbPreferencesMigrator);
        if (obj instanceof Integer) {
            return Types.INT;
        }
        if (obj instanceof Long) {
            return "long";
        }
        if (obj instanceof Boolean) {
            return Types.BOOLEAN;
        }
        if (obj instanceof Set) {
            return Types.STRING_SET;
        }
        if (obj instanceof Float) {
            return Types.FLOAT;
        }
        return obj instanceof String ? Types.STRING : "unknown";
    }

    @NotNull
    public final SharedPreferencesTable getTable() {
        return this.a;
    }

    public final void migrate() {
        migrateValues(this.e.getDefaultPreferences(this.b).getAll(), Names.DEFAULT);
        migrateValues(this.e.getCustomPreferences(this.b, Names.GEO).getAll(), Names.GEO);
    }

    public final void migrateValues(@NotNull Map<String, ? extends Object> map, @NotNull String str) {
        Intrinsics.checkNotNullParameter(map, "$this$migrateValues");
        Intrinsics.checkNotNullParameter(str, "file");
        ContentValues contentValues = new ContentValues();
        SQLiteDatabase sQLiteDatabase = this.c;
        sQLiteDatabase.beginTransaction();
        try {
            for (Map.Entry<String, ? extends Object> entry : map.entrySet()) {
                contentValues.clear();
                String access$getStringForValue = access$getStringForValue(this, entry.getValue());
                SQLiteDatabase sQLiteDatabase2 = this.c;
                String table = getTable().getTABLE();
                contentValues.put(getTable().getKEY(), entry.getKey());
                contentValues.put(getTable().getVALUE(), access$getStringForValue);
                contentValues.put(getTable().getFILE(), str);
                contentValues.put(getTable().getTYPE(), access$getTypeFor(this, entry.getValue()));
                Unit unit = Unit.INSTANCE;
                sQLiteDatabase2.insert(table, null, contentValues);
            }
            sQLiteDatabase.setTransactionSuccessful();
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }
}
