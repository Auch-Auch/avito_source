package com.avito.android.util.preferences;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.avito.android.db.CachingCursor;
import com.avito.android.db.preferences.SharedPreferencesTable;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.GsonsKt;
import com.avito.android.util.preferences.db_preferences.Types;
import com.facebook.appevents.UserDataStore;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010&\u001a\u00020$\u0012\u0006\u0010#\u001a\u00020\u0005\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u0012\u0006\u0010\u0018\u001a\u00020\u0015¢\u0006\u0004\b'\u0010(J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001b\u0010\t\u001a\u00020\b*\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\r\u001a\u00020\u0002*\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0003¢\u0006\u0004\b\r\u0010\u000eJ-\u0010\u0013\u001a\u00020\u0002*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0019\u0010!\u001a\u00020\u001d8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0016\u0010#\u001a\u00020\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\"R\u0016\u0010&\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010%¨\u0006)"}, d2 = {"Lcom/avito/android/util/preferences/SharedPreferencesMigrator;", "", "", "migrate", "()V", "Landroid/database/sqlite/SQLiteDatabase;", "", "file", "Landroid/database/Cursor;", AuthSource.SEND_ABUSE, "(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;)Landroid/database/Cursor;", "Lcom/avito/android/util/preferences/Preferences;", "preferences", AuthSource.BOOKING_ORDER, "(Landroid/database/Cursor;Lcom/avito/android/util/preferences/Preferences;)V", "Landroid/content/SharedPreferences$Editor;", "key", "type", "value", "c", "(Landroid/content/SharedPreferences$Editor;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Lcom/avito/android/util/preferences/PreferenceFactory;", "e", "Lcom/avito/android/util/preferences/PreferenceFactory;", "factory", "Lcom/google/gson/Gson;", "d", "Lcom/google/gson/Gson;", "gson", "Lcom/avito/android/db/preferences/SharedPreferencesTable;", "Lcom/avito/android/db/preferences/SharedPreferencesTable;", "getTable", "()Lcom/avito/android/db/preferences/SharedPreferencesTable;", "table", "Landroid/database/sqlite/SQLiteDatabase;", UserDataStore.DATE_OF_BIRTH, "Landroid/content/Context;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Landroid/database/sqlite/SQLiteDatabase;Lcom/google/gson/Gson;Lcom/avito/android/util/preferences/PreferenceFactory;)V", "core_release"}, k = 1, mv = {1, 4, 2})
public final class SharedPreferencesMigrator {
    @NotNull
    public final SharedPreferencesTable a = new SharedPreferencesTable();
    public final Context b;
    public final SQLiteDatabase c;
    public final Gson d;
    public final PreferenceFactory e;

    public SharedPreferencesMigrator(@NotNull Context context, @NotNull SQLiteDatabase sQLiteDatabase, @NotNull Gson gson, @NotNull PreferenceFactory preferenceFactory) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sQLiteDatabase, UserDataStore.DATE_OF_BIRTH);
        Intrinsics.checkNotNullParameter(gson, "gson");
        Intrinsics.checkNotNullParameter(preferenceFactory, "factory");
        this.b = context;
        this.c = sQLiteDatabase;
        this.d = gson;
        this.e = preferenceFactory;
    }

    public final Cursor a(SQLiteDatabase sQLiteDatabase, String str) {
        Cursor rawQuery = sQLiteDatabase.rawQuery(this.a.getFILE_QUERY(), new String[]{str});
        Intrinsics.checkNotNullExpressionValue(rawQuery, "rawQuery(table.FILE_QUERY, arrayOf(file))");
        return rawQuery;
    }

    @SuppressLint({"ApplySharedPref"})
    public final void b(Cursor cursor, Preferences preferences) {
        CachingCursor cachingCursor;
        if (cursor.getCount() > 0) {
            SharedPreferences.Editor edit = preferences.getSharedPreferences().edit();
            if (cursor instanceof CachingCursor) {
                cachingCursor = (CachingCursor) cursor;
            } else {
                cachingCursor = new CachingCursor(cursor);
            }
            while (cachingCursor.moveToNext()) {
                try {
                    String stringOrNull = cachingCursor.getStringOrNull(this.a.getVALUE());
                    String string = cachingCursor.getString(this.a.getTYPE());
                    String string2 = cachingCursor.getString(this.a.getKEY());
                    Intrinsics.checkNotNullExpressionValue(edit, "editor");
                    c(edit, string2, string, stringOrNull);
                } catch (Exception e2) {
                    try {
                        cachingCursor.close();
                    } catch (Exception unused) {
                    }
                    throw e2;
                } catch (Throwable th) {
                    if (1 == 0) {
                        cachingCursor.close();
                    }
                    throw th;
                }
            }
            cachingCursor.close();
            edit.commit();
        }
    }

    public final void c(SharedPreferences.Editor editor, String str, String str2, String str3) {
        Type type;
        switch (str2.hashCode()) {
            case -1572742348:
                if (str2.equals(Types.STRING_SET)) {
                    Set<String> set = null;
                    if (str3 != null) {
                        Gson gson = this.d;
                        Type type2 = new TypeToken<Set<? extends String>>() { // from class: com.avito.android.util.preferences.SharedPreferencesMigrator$extractStringSet$$inlined$fromJson$1
                        }.getType();
                        Intrinsics.checkNotNullExpressionValue(type2, "object : TypeToken<T>() {}.type");
                        if (type2 instanceof ParameterizedType) {
                            ParameterizedType parameterizedType = (ParameterizedType) type2;
                            if (GsonsKt.isWildcard(parameterizedType)) {
                                type = parameterizedType.getRawType();
                                Intrinsics.checkNotNullExpressionValue(type, "type.rawType");
                                Object fromJson = gson.fromJson(str3, type);
                                Intrinsics.checkNotNullExpressionValue(fromJson, "fromJson(json, typeToken<T>())");
                                set = (Set) fromJson;
                            }
                        }
                        type = GsonsKt.removeTypeWildcards(type2);
                        Object fromJson = gson.fromJson(str3, type);
                        Intrinsics.checkNotNullExpressionValue(fromJson, "fromJson(json, typeToken<T>())");
                        set = (Set) fromJson;
                    }
                    editor.putStringSet(str, set);
                    return;
                }
                return;
            case -891985903:
                if (str2.equals(Types.STRING)) {
                    editor.putString(str, str3);
                    return;
                }
                return;
            case 104431:
                if (str2.equals(Types.INT) && str3 != null) {
                    editor.putInt(str, Integer.parseInt(str3));
                    return;
                }
                return;
            case 3327612:
                if (str2.equals("long") && str3 != null) {
                    editor.putLong(str, Long.parseLong(str3));
                    return;
                }
                return;
            case 64711720:
                if (str2.equals(Types.BOOLEAN) && str3 != null) {
                    editor.putBoolean(str, Boolean.parseBoolean(str3));
                    return;
                }
                return;
            case 97526364:
                if (str2.equals(Types.FLOAT) && str3 != null) {
                    editor.putFloat(str, Float.parseFloat(str3));
                    return;
                }
                return;
            default:
                return;
        }
    }

    @NotNull
    public final SharedPreferencesTable getTable() {
        return this.a;
    }

    public final void migrate() {
        b(a(this.c, Names.DEFAULT), this.e.getDefaultPreferences(this.b));
        b(a(this.c, Names.GEO), this.e.getCustomPreferences(this.b, Names.GEO));
        b(a(this.c, Names.ABTESTS), this.e.getCustomPreferences(this.b, Names.ABTESTS));
        b(a(this.c, "suggests"), this.e.getCustomPreferences(this.b, "suggests"));
        b(a(this.c, Names.DEBUG), this.e.getCustomPreferences(this.b, Names.DEBUG));
    }
}
