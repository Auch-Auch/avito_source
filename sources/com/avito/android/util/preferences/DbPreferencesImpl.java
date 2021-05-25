package com.avito.android.util.preferences;

import android.os.Handler;
import com.avito.android.db.sqlbrite.Database;
import com.avito.android.publish.residential_complex_search.di.ResidentialComplexModuleKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.preferences.db_preferences.DbSharedPreferencesImpl;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.gson.Gson;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\"\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B)\u0012\u0006\u00108\u001a\u000207\u0012\u0006\u0010:\u001a\u000209\u0012\u0006\u0010<\u001a\u00020;\u0012\b\b\u0002\u00100\u001a\u00020\u0002¢\u0006\u0004\b=\u0010>J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J#\u0010\u0014\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J!\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0018\u0010\u0006J\u001f\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0018\u0010\u001aJ\u001f\u0010\u001b\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0014\u0010\u001dJ\u0019\u0010\u001e\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001e\u0010\u001dJ'\u0010!\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001fH\u0016¢\u0006\u0004\b!\u0010\"J\u001f\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b#\u0010$J\u001f\u0010&\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020%H\u0016¢\u0006\u0004\b&\u0010'J\u001d\u0010*\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010)0(H\u0016¢\u0006\u0004\b*\u0010+J\u0017\u0010,\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b,\u0010-R\u0016\u00100\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u001c\u00106\u001a\u0002018\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105¨\u0006?"}, d2 = {"Lcom/avito/android/util/preferences/DbPreferencesImpl;", "Lcom/avito/android/util/preferences/Preferences;", "", "key", "", "contains", "(Ljava/lang/String;)Z", "", "defaultValue", "getLong", "(Ljava/lang/String;J)J", "value", "", "putLong", "(Ljava/lang/String;J)V", "", "getInt", "(Ljava/lang/String;I)I", "putInt", "(Ljava/lang/String;I)V", "getString", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "putString", "(Ljava/lang/String;Ljava/lang/String;)V", "getBoolean", "defValue", "(Ljava/lang/String;Z)Z", "putBoolean", "(Ljava/lang/String;Z)V", "(Ljava/lang/String;)Ljava/lang/String;", "getAsString", "", ResidentialComplexModuleKt.VALUES, "putStringSet", "(Ljava/lang/String;Ljava/util/Set;)V", "getStringSet", "(Ljava/lang/String;)Ljava/util/Set;", "", "putFloat", "(Ljava/lang/String;F)V", "", "", "getAll", "()Ljava/util/Map;", ProductAction.ACTION_REMOVE, "(Ljava/lang/String;)V", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "file", "Lcom/avito/android/util/preferences/db_preferences/DbSharedPreferencesImpl;", AuthSource.SEND_ABUSE, "Lcom/avito/android/util/preferences/db_preferences/DbSharedPreferencesImpl;", "getSharedPreferences", "()Lcom/avito/android/util/preferences/db_preferences/DbSharedPreferencesImpl;", "sharedPreferences", "Lcom/avito/android/db/sqlbrite/Database;", "database", "Lcom/google/gson/Gson;", "gson", "Landroid/os/Handler;", "mainThread", "<init>", "(Lcom/avito/android/db/sqlbrite/Database;Lcom/google/gson/Gson;Landroid/os/Handler;Ljava/lang/String;)V", "core_release"}, k = 1, mv = {1, 4, 2})
public final class DbPreferencesImpl implements Preferences {
    @NotNull
    public final DbSharedPreferencesImpl a;
    public final String b;

    public DbPreferencesImpl(@NotNull Database database, @NotNull Gson gson, @NotNull Handler handler, @NotNull String str) {
        Intrinsics.checkNotNullParameter(database, "database");
        Intrinsics.checkNotNullParameter(gson, "gson");
        Intrinsics.checkNotNullParameter(handler, "mainThread");
        Intrinsics.checkNotNullParameter(str, "file");
        this.b = str;
        this.a = new DbSharedPreferencesImpl(database, gson, handler, str);
    }

    @Override // com.avito.android.util.preferences.Preferences
    public boolean contains(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        return getSharedPreferences().contains(str);
    }

    @Override // com.avito.android.util.preferences.Preferences
    @NotNull
    public Map<String, Object> getAll() {
        return getSharedPreferences().getAll();
    }

    @Override // com.avito.android.util.preferences.Preferences
    @Nullable
    public String getAsString(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        return getSharedPreferences().getAsString(str);
    }

    @Override // com.avito.android.util.preferences.Preferences
    public boolean getBoolean(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        return getSharedPreferences().getBoolean(str, false);
    }

    @Override // com.avito.android.util.preferences.Preferences
    public int getInt(@NotNull String str, int i) {
        Intrinsics.checkNotNullParameter(str, "key");
        return getSharedPreferences().getInt(str, i);
    }

    @Override // com.avito.android.util.preferences.Preferences
    public long getLong(@NotNull String str, long j) {
        Intrinsics.checkNotNullParameter(str, "key");
        return getSharedPreferences().getLong(str, j);
    }

    @Override // com.avito.android.util.preferences.Preferences
    @Nullable
    public String getString(@NotNull String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "key");
        return getSharedPreferences().getString(str, str2);
    }

    @Override // com.avito.android.util.preferences.Preferences
    @Nullable
    public Set<String> getStringSet(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        return getSharedPreferences().getStringSet(str, null);
    }

    @Override // com.avito.android.util.preferences.Preferences
    public void putBoolean(@NotNull String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "key");
        getSharedPreferences().edit().putBoolean(str, z).commit();
    }

    @Override // com.avito.android.util.preferences.Preferences
    public void putFloat(@NotNull String str, float f) {
        Intrinsics.checkNotNullParameter(str, "key");
        getSharedPreferences().edit().putFloat(str, f).commit();
    }

    @Override // com.avito.android.util.preferences.Preferences
    public void putInt(@NotNull String str, int i) {
        Intrinsics.checkNotNullParameter(str, "key");
        getSharedPreferences().edit().putInt(str, i).commit();
    }

    @Override // com.avito.android.util.preferences.Preferences
    public void putLong(@NotNull String str, long j) {
        Intrinsics.checkNotNullParameter(str, "key");
        getSharedPreferences().edit().putLong(str, j).commit();
    }

    @Override // com.avito.android.util.preferences.Preferences
    public void putString(@NotNull String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "key");
        getSharedPreferences().edit().putString(str, str2).commit();
    }

    @Override // com.avito.android.util.preferences.Preferences
    public void putStringSet(@NotNull String str, @Nullable Set<String> set) {
        Intrinsics.checkNotNullParameter(str, "key");
        getSharedPreferences().edit().putStringSet(str, set).commit();
    }

    @Override // com.avito.android.util.preferences.Preferences
    public void remove(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        getSharedPreferences().edit().remove(str).commit();
    }

    @Override // com.avito.android.util.preferences.Preferences
    public boolean getBoolean(@NotNull String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "key");
        return getSharedPreferences().getBoolean(str, z);
    }

    @Override // com.avito.android.util.preferences.Preferences
    @NotNull
    public DbSharedPreferencesImpl getSharedPreferences() {
        return this.a;
    }

    @Override // com.avito.android.util.preferences.Preferences
    @Nullable
    public String getString(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        return getSharedPreferences().getString(str, null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DbPreferencesImpl(Database database, Gson gson, Handler handler, String str, int i, j jVar) {
        this(database, gson, handler, (i & 8) != 0 ? Names.DEFAULT : str);
    }
}
