package com.avito.android.util.preferences.db_preferences;

import a2.g.r.g;
import android.content.ContentValues;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Handler;
import android.os.Looper;
import com.avito.android.db.CachingCursor;
import com.avito.android.db.preferences.SharedPreferencesTable;
import com.avito.android.db.sqlbrite.Database;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.GsonsKt;
import com.avito.android.util.Logs;
import com.avito.android.util.preferences.Names;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.squareup.sqlbrite2.BriteDatabase;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.r;
import t6.n.y;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001)B)\u0012\u0006\u00105\u001a\u000202\u0012\u0006\u0010E\u001a\u00020B\u0012\u0006\u00109\u001a\u000206\u0012\b\b\u0002\u00101\u001a\u00020\u0002¢\u0006\u0004\bF\u0010GJ\u001f\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J#\u0010\u0011\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J/\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00152\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0018\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u001d\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b \u0010!J\u0017\u0010%\u001a\u00020$2\u0006\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\b%\u0010&J\u0017\u0010'\u001a\u00020$2\u0006\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\b'\u0010&J3\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00152\b\u0010(\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0015H\u0002¢\u0006\u0004\b)\u0010\u0018J#\u0010,\u001a\u0004\u0018\u00010\u001c2\b\u0010*\u001a\u0004\u0018\u00010\u00022\u0006\u0010+\u001a\u00020\u0002H\u0002¢\u0006\u0004\b,\u0010-J\u0019\u0010.\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b.\u0010\u0014R\u0016\u00101\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b7\u00108R\"\u0010<\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u001c0:8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010;R\u0016\u0010>\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010=R\u0016\u0010A\u001a\u00020?8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010@R\u0016\u0010E\u001a\u00020B8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bC\u0010D¨\u0006H"}, d2 = {"Lcom/avito/android/util/preferences/db_preferences/DbSharedPreferencesImpl;", "Landroid/content/SharedPreferences;", "", "key", "", "defaultValue", "getBoolean", "(Ljava/lang/String;Z)Z", "", "getInt", "(Ljava/lang/String;I)I", "", "getLong", "(Ljava/lang/String;J)J", "", "getFloat", "(Ljava/lang/String;F)F", "getString", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "getAsString", "(Ljava/lang/String;)Ljava/lang/String;", "", "defaultValues", "getStringSet", "(Ljava/lang/String;Ljava/util/Set;)Ljava/util/Set;", "contains", "(Ljava/lang/String;)Z", "", "", "getAll", "()Ljava/util/Map;", "Landroid/content/SharedPreferences$Editor;", "edit", "()Landroid/content/SharedPreferences$Editor;", "Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "registerOnSharedPreferenceChangeListener", "(Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;)V", "unregisterOnSharedPreferenceChangeListener", "value", AuthSource.SEND_ABUSE, "stringValue", "type", AuthSource.BOOKING_ORDER, "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;", "c", g.a, "Ljava/lang/String;", "file", "Lcom/avito/android/db/sqlbrite/Database;", "d", "Lcom/avito/android/db/sqlbrite/Database;", "database", "Landroid/os/Handler;", "f", "Landroid/os/Handler;", "mainThread", "Ljava/util/WeakHashMap;", "Ljava/util/WeakHashMap;", "listeners", "Ljava/lang/Object;", "placeHolder", "Lcom/avito/android/db/preferences/SharedPreferencesTable;", "Lcom/avito/android/db/preferences/SharedPreferencesTable;", "table", "Lcom/google/gson/Gson;", "e", "Lcom/google/gson/Gson;", "gson", "<init>", "(Lcom/avito/android/db/sqlbrite/Database;Lcom/google/gson/Gson;Landroid/os/Handler;Ljava/lang/String;)V", "core_release"}, k = 1, mv = {1, 4, 2})
public final class DbSharedPreferencesImpl implements SharedPreferences {
    public final Object a;
    public final SharedPreferencesTable b;
    public final WeakHashMap<SharedPreferences.OnSharedPreferenceChangeListener, Object> c;
    public final Database d;
    public final Gson e;
    public final Handler f;
    public final String g;

    public final class a implements SharedPreferences.Editor {
        public volatile Map<String, Object> a = new LinkedHashMap();
        public volatile Set<String> b = new LinkedHashSet();
        public boolean c;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public a() {
        }

        public final void a(Set<String> set, Map<String, ? extends Object> map) {
            String str;
            String str2;
            BriteDatabase.Transaction newTransaction = DbSharedPreferencesImpl.this.d.newTransaction();
            try {
                Iterator<T> it = set.iterator();
                while (it.hasNext()) {
                    DbSharedPreferencesImpl.this.d.delete(DbSharedPreferencesImpl.this.b.getTABLE(), DbSharedPreferencesImpl.this.b.getDELETE_KEY(), it.next(), DbSharedPreferencesImpl.this.g);
                }
                ContentValues contentValues = new ContentValues();
                for (Map.Entry<String, ? extends Object> entry : map.entrySet()) {
                    contentValues.clear();
                    Object value = entry.getValue();
                    if (value instanceof Set) {
                        str = DbSharedPreferencesImpl.this.e.toJson(value);
                    } else {
                        str = value != null ? value.toString() : null;
                    }
                    Database database = DbSharedPreferencesImpl.this.d;
                    String table = DbSharedPreferencesImpl.this.b.getTABLE();
                    contentValues.put(DbSharedPreferencesImpl.this.b.getKEY(), entry.getKey());
                    contentValues.put(DbSharedPreferencesImpl.this.b.getVALUE(), str);
                    contentValues.put(DbSharedPreferencesImpl.this.b.getFILE(), DbSharedPreferencesImpl.this.g);
                    String type = DbSharedPreferencesImpl.this.b.getTYPE();
                    Object value2 = entry.getValue();
                    if (value2 instanceof Integer) {
                        str2 = Types.INT;
                    } else if (value2 instanceof Long) {
                        str2 = "long";
                    } else if (value2 instanceof Boolean) {
                        str2 = Types.BOOLEAN;
                    } else if (value2 instanceof Set) {
                        str2 = Types.STRING_SET;
                    } else if (value2 instanceof Float) {
                        str2 = Types.FLOAT;
                    } else {
                        str2 = value2 instanceof String ? Types.STRING : "unknown";
                    }
                    contentValues.put(type, str2);
                    database.insert(table, contentValues);
                }
                newTransaction.markSuccessful();
            } finally {
                newTransaction.end();
            }
        }

        @Override // android.content.SharedPreferences.Editor
        public void apply() {
            commit();
        }

        public final void b(Set<String> set) {
            for (T t : set) {
                synchronized (DbSharedPreferencesImpl.this) {
                    for (SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener : new HashSet(DbSharedPreferencesImpl.this.c.keySet())) {
                        if (DbSharedPreferencesImpl.this.c.containsKey(onSharedPreferenceChangeListener) && onSharedPreferenceChangeListener != null) {
                            onSharedPreferenceChangeListener.onSharedPreferenceChanged(DbSharedPreferencesImpl.this, t);
                        }
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
        }

        public final void c(String str, Object obj) {
            synchronized (this) {
                this.a.put(str, obj);
            }
        }

        @Override // android.content.SharedPreferences.Editor
        @NotNull
        public SharedPreferences.Editor clear() {
            synchronized (DbSharedPreferencesImpl.this) {
                this.c = true;
                Unit unit = Unit.INSTANCE;
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public boolean commit() {
            Map<String, ? extends Object> map;
            Set<String> set;
            boolean z;
            r.emptyMap();
            y.emptySet();
            synchronized (DbSharedPreferencesImpl.this) {
                map = this.a;
                set = this.b;
                z = this.c;
                this.a = new LinkedHashMap();
                this.b = new LinkedHashSet();
                this.c = false;
            }
            if (z) {
                DbSharedPreferencesImpl.this.d.delete(DbSharedPreferencesImpl.this.b.getTABLE(), DbSharedPreferencesImpl.this.b.getDELETE_FILE(), DbSharedPreferencesImpl.this.g);
            }
            try {
                a(set, map);
                Set<String> linkedHashSet = new LinkedHashSet<>();
                linkedHashSet.addAll(set);
                linkedHashSet.addAll(map.keySet());
                if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
                    b(linkedHashSet);
                } else {
                    DbSharedPreferencesImpl.this.f.post(new a2.a.a.n3.x.a.a(this, linkedHashSet));
                }
            } catch (Exception e) {
                Logs.error("DbSharedPreferences commit error", e);
            }
            return true;
        }

        @Override // android.content.SharedPreferences.Editor
        @NotNull
        public SharedPreferences.Editor putBoolean(@NotNull String str, boolean z) {
            Intrinsics.checkNotNullParameter(str, "key");
            c(str, Boolean.valueOf(z));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        @NotNull
        public SharedPreferences.Editor putFloat(@NotNull String str, float f) {
            Intrinsics.checkNotNullParameter(str, "key");
            c(str, Float.valueOf(f));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        @NotNull
        public SharedPreferences.Editor putInt(@NotNull String str, int i) {
            Intrinsics.checkNotNullParameter(str, "key");
            c(str, Integer.valueOf(i));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        @NotNull
        public SharedPreferences.Editor putLong(@NotNull String str, long j) {
            Intrinsics.checkNotNullParameter(str, "key");
            c(str, Long.valueOf(j));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        @NotNull
        public SharedPreferences.Editor putString(@NotNull String str, @Nullable String str2) {
            Intrinsics.checkNotNullParameter(str, "key");
            c(str, str2);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        @NotNull
        public SharedPreferences.Editor putStringSet(@NotNull String str, @Nullable Set<String> set) {
            Intrinsics.checkNotNullParameter(str, "key");
            c(str, set);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        @NotNull
        public SharedPreferences.Editor remove(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "key");
            synchronized (this) {
                this.b.add(str);
            }
            return this;
        }
    }

    public DbSharedPreferencesImpl(@NotNull Database database, @NotNull Gson gson, @NotNull Handler handler, @NotNull String str) {
        Intrinsics.checkNotNullParameter(database, "database");
        Intrinsics.checkNotNullParameter(gson, "gson");
        Intrinsics.checkNotNullParameter(handler, "mainThread");
        Intrinsics.checkNotNullParameter(str, "file");
        this.d = database;
        this.e = gson;
        this.f = handler;
        this.g = str;
        this.a = new Object();
        this.b = new SharedPreferencesTable();
        this.c = new WeakHashMap<>();
    }

    public final Set<String> a(String str, Set<String> set) {
        Type type;
        if (str == null) {
            return set;
        }
        Gson gson = this.e;
        Type type2 = new TypeToken<Set<? extends String>>() { // from class: com.avito.android.util.preferences.db_preferences.DbSharedPreferencesImpl$extractStringSet$$inlined$fromJson$1
        }.getType();
        Intrinsics.checkNotNullExpressionValue(type2, "object : TypeToken<T>() {}.type");
        if (type2 instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type2;
            if (GsonsKt.isWildcard(parameterizedType)) {
                type = parameterizedType.getRawType();
                Intrinsics.checkNotNullExpressionValue(type, "type.rawType");
                Object fromJson = gson.fromJson(str, type);
                Intrinsics.checkNotNullExpressionValue(fromJson, "fromJson(json, typeToken<T>())");
                return (Set) fromJson;
            }
        }
        type = GsonsKt.removeTypeWildcards(type2);
        Object fromJson = gson.fromJson(str, type);
        Intrinsics.checkNotNullExpressionValue(fromJson, "fromJson(json, typeToken<T>())");
        return (Set) fromJson;
    }

    public final Object b(String str, String str2) {
        switch (str2.hashCode()) {
            case -1572742348:
                if (str2.equals(Types.STRING_SET)) {
                    return a(str, null);
                }
                break;
            case -891985903:
                if (str2.equals(Types.STRING)) {
                    return str;
                }
                break;
            case 104431:
                if (str2.equals(Types.INT) && str != null) {
                    return Integer.valueOf(Integer.parseInt(str));
                }
            case 3327612:
                if (str2.equals("long") && str != null) {
                    return Long.valueOf(Long.parseLong(str));
                }
            case 64711720:
                if (str2.equals(Types.BOOLEAN) && str != null) {
                    return Boolean.valueOf(Boolean.parseBoolean(str));
                }
            case 97526364:
                if (str2.equals(Types.FLOAT) && str != null) {
                    return Float.valueOf(Float.parseFloat(str));
                }
        }
        return null;
    }

    public final String c(String str) {
        CachingCursor cachingCursor;
        Throwable th;
        boolean z = false;
        Cursor query = this.d.query(this.b.getVALUE_QUERY(), str, this.g);
        if (query.getCount() > 0) {
            if (query instanceof CachingCursor) {
                cachingCursor = (CachingCursor) query;
            } else {
                cachingCursor = new CachingCursor(query);
            }
            try {
                cachingCursor.moveToFirst();
                String stringOrNull = cachingCursor.getStringOrNull(this.b.getVALUE());
                cachingCursor.close();
                return stringOrNull;
            } catch (Exception e2) {
                try {
                    cachingCursor.close();
                } catch (Exception unused) {
                }
                throw e2;
            } catch (Throwable th2) {
                th = th2;
                z = true;
            }
        } else {
            query.close();
            return null;
        }
        if (!z) {
            cachingCursor.close();
        }
        throw th;
    }

    @Override // android.content.SharedPreferences
    public boolean contains(@NotNull String str) {
        Throwable th;
        Intrinsics.checkNotNullParameter(str, "key");
        boolean z = false;
        Cursor query = this.d.query(this.b.getVALUE_QUERY(), str, this.g);
        try {
            if (query.getCount() > 0) {
                z = true;
            }
            query.close();
            return z;
        } catch (Exception e2) {
            try {
                query.close();
            } catch (Exception unused) {
            }
            throw e2;
        } catch (Throwable th2) {
            th = th2;
            z = true;
        }
        if (!z) {
            query.close();
        }
        throw th;
    }

    @Override // android.content.SharedPreferences
    @NotNull
    public SharedPreferences.Editor edit() {
        return new a();
    }

    @Override // android.content.SharedPreferences
    @NotNull
    public Map<String, Object> getAll() {
        CachingCursor cachingCursor;
        Throwable th;
        boolean z = true;
        Cursor query = this.d.query(this.b.getFILE_QUERY(), this.g);
        if (query.getCount() <= 0) {
            return r.emptyMap();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (query instanceof CachingCursor) {
            cachingCursor = (CachingCursor) query;
        } else {
            cachingCursor = new CachingCursor(query);
        }
        while (cachingCursor.moveToNext()) {
            try {
                linkedHashMap.put(cachingCursor.getString(this.b.getKEY()), b(cachingCursor.getStringOrNull(this.b.getVALUE()), cachingCursor.getString(this.b.getTYPE())));
            } catch (Exception e2) {
                try {
                    cachingCursor.close();
                } catch (Exception unused) {
                }
                throw e2;
            } catch (Throwable th2) {
                th = th2;
            }
        }
        cachingCursor.close();
        return linkedHashMap;
        if (!z) {
            cachingCursor.close();
        }
        throw th;
    }

    @Nullable
    public final String getAsString(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        return c(str);
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(@NotNull String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "key");
        String c2 = c(str);
        return c2 != null ? Boolean.parseBoolean(c2) : z;
    }

    @Override // android.content.SharedPreferences
    public float getFloat(@NotNull String str, float f2) {
        Intrinsics.checkNotNullParameter(str, "key");
        String c2 = c(str);
        return c2 != null ? Float.parseFloat(c2) : f2;
    }

    @Override // android.content.SharedPreferences
    public int getInt(@NotNull String str, int i) {
        Intrinsics.checkNotNullParameter(str, "key");
        String c2 = c(str);
        return c2 != null ? Integer.parseInt(c2) : i;
    }

    @Override // android.content.SharedPreferences
    public long getLong(@NotNull String str, long j) {
        Intrinsics.checkNotNullParameter(str, "key");
        String c2 = c(str);
        return c2 != null ? Long.parseLong(c2) : j;
    }

    @Override // android.content.SharedPreferences
    @Nullable
    public String getString(@NotNull String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "key");
        return contains(str) ? c(str) : str2;
    }

    @Override // android.content.SharedPreferences
    @Nullable
    public Set<String> getStringSet(@NotNull String str, @Nullable Set<String> set) {
        Intrinsics.checkNotNullParameter(str, "key");
        return a(c(str), set);
    }

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(@NotNull SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        Intrinsics.checkNotNullParameter(onSharedPreferenceChangeListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        synchronized (this) {
            this.c.put(onSharedPreferenceChangeListener, this.a);
        }
    }

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(@NotNull SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        Intrinsics.checkNotNullParameter(onSharedPreferenceChangeListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        synchronized (this) {
            this.c.remove(onSharedPreferenceChangeListener);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DbSharedPreferencesImpl(Database database, Gson gson, Handler handler, String str, int i, j jVar) {
        this(database, gson, handler, (i & 8) != 0 ? Names.DEFAULT : str);
    }
}
