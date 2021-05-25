package com.avito.android.util.preferences;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import androidx.annotation.VisibleForTesting;
import com.avito.android.publish.residential_complex_search.di.ResidentialComplexModuleKt;
import com.avito.android.remote.auth.AuthSource;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u00103\u001a\u00020.¢\u0006\u0004\b4\u00105J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ#\u0010\u000e\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0006J\u001f\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\u0012J\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u0013J\u001d\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ!\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0018\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u001f\u0010!\u001a\u00020\u00192\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020 H\u0016¢\u0006\u0004\b!\u0010\"J'\u0010%\u001a\u00020\u00192\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010#H\u0016¢\u0006\u0004\b%\u0010&J\u001f\u0010'\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010#2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b'\u0010(J\u0019\u0010)\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b)\u0010\u0013J\u001f\u0010*\u001a\u00020\u00192\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0004H\u0016¢\u0006\u0004\b*\u0010+J\u0017\u0010,\u001a\u00020\u00192\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b,\u0010-R\u001c\u00103\u001a\u00020.8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102¨\u00066"}, d2 = {"Lcom/avito/android/util/preferences/SharedPreferencesImpl;", "Lcom/avito/android/util/preferences/Preferences;", "", "key", "", "contains", "(Ljava/lang/String;)Z", "", "defaultValue", "getLong", "(Ljava/lang/String;J)J", "", "getInt", "(Ljava/lang/String;I)I", "getString", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "getBoolean", "defValue", "(Ljava/lang/String;Z)Z", "(Ljava/lang/String;)Ljava/lang/String;", "", "", "getAll", "()Ljava/util/Map;", "value", "", "putLong", "(Ljava/lang/String;J)V", "putInt", "(Ljava/lang/String;I)V", "putString", "(Ljava/lang/String;Ljava/lang/String;)V", "", "putFloat", "(Ljava/lang/String;F)V", "", ResidentialComplexModuleKt.VALUES, "putStringSet", "(Ljava/lang/String;Ljava/util/Set;)V", "getStringSet", "(Ljava/lang/String;)Ljava/util/Set;", "getAsString", "putBoolean", "(Ljava/lang/String;Z)V", ProductAction.ACTION_REMOVE, "(Ljava/lang/String;)V", "Landroid/content/SharedPreferences;", AuthSource.SEND_ABUSE, "Landroid/content/SharedPreferences;", "getSharedPreferences", "()Landroid/content/SharedPreferences;", "sharedPreferences", "<init>", "(Landroid/content/SharedPreferences;)V", "preferences_release"}, k = 1, mv = {1, 4, 2})
@SuppressLint({"ApplySharedPref"})
public final class SharedPreferencesImpl implements Preferences {
    @NotNull
    public final SharedPreferences a;

    @VisibleForTesting
    public SharedPreferencesImpl(@NotNull SharedPreferences sharedPreferences) {
        Intrinsics.checkNotNullParameter(sharedPreferences, "sharedPreferences");
        this.a = sharedPreferences;
    }

    @Override // com.avito.android.util.preferences.Preferences
    public boolean contains(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        return getSharedPreferences().contains(str);
    }

    @Override // com.avito.android.util.preferences.Preferences
    @NotNull
    public Map<String, Object> getAll() {
        Map<String, ?> all = getSharedPreferences().getAll();
        Intrinsics.checkNotNullExpressionValue(all, "sharedPreferences.all");
        return all;
    }

    @Override // com.avito.android.util.preferences.Preferences
    @Nullable
    public String getAsString(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        Object obj = getSharedPreferences().getAll().get(str);
        if (obj != null) {
            return obj.toString();
        }
        return null;
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
    @NotNull
    public SharedPreferences getSharedPreferences() {
        return this.a;
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
    @Nullable
    public String getString(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        return getSharedPreferences().getString(str, null);
    }
}
