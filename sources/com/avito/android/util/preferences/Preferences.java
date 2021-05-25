package com.avito.android.util.preferences;

import android.content.SharedPreferences;
import com.avito.android.publish.residential_complex_search.di.ResidentialComplexModuleKt;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\n\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H¦\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u000bH&¢\u0006\u0004\b\f\u0010\rJ#\u0010\u000e\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0010\u0010\u0006J\u001f\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0004H&¢\u0006\u0004\b\u0010\u0010\u0012J\u001f\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0007H&¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u000e\u0010\u0017J\u001f\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u000bH&¢\u0006\u0004\b\u0018\u0010\u0019J!\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u001cH&¢\u0006\u0004\b\u001d\u0010\u001eJ'\u0010!\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001fH&¢\u0006\u0004\b!\u0010\"J\u001f\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001f2\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b#\u0010$J\u0019\u0010%\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b%\u0010\u0017J\u001f\u0010&\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0004H&¢\u0006\u0004\b&\u0010'J\u0017\u0010(\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b(\u0010)J\u001d\u0010+\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00010*H&¢\u0006\u0004\b+\u0010,R\u0016\u00100\u001a\u00020-8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/¨\u00061"}, d2 = {"Lcom/avito/android/util/preferences/Preferences;", "", "", "key", "", "contains", "(Ljava/lang/String;)Z", "", "defaultValue", "getLong", "(Ljava/lang/String;J)J", "", "getInt", "(Ljava/lang/String;I)I", "getString", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "getBoolean", "defValue", "(Ljava/lang/String;Z)Z", "value", "", "putLong", "(Ljava/lang/String;J)V", "(Ljava/lang/String;)Ljava/lang/String;", "putInt", "(Ljava/lang/String;I)V", "putString", "(Ljava/lang/String;Ljava/lang/String;)V", "", "putFloat", "(Ljava/lang/String;F)V", "", ResidentialComplexModuleKt.VALUES, "putStringSet", "(Ljava/lang/String;Ljava/util/Set;)V", "getStringSet", "(Ljava/lang/String;)Ljava/util/Set;", "getAsString", "putBoolean", "(Ljava/lang/String;Z)V", ProductAction.ACTION_REMOVE, "(Ljava/lang/String;)V", "", "getAll", "()Ljava/util/Map;", "Landroid/content/SharedPreferences;", "getSharedPreferences", "()Landroid/content/SharedPreferences;", "sharedPreferences", "preferences_release"}, k = 1, mv = {1, 4, 2})
public interface Preferences {
    boolean contains(@NotNull String str);

    @NotNull
    Map<String, Object> getAll();

    @Nullable
    String getAsString(@NotNull String str);

    boolean getBoolean(@NotNull String str);

    boolean getBoolean(@NotNull String str, boolean z);

    int getInt(@NotNull String str, int i);

    long getLong(@NotNull String str, long j);

    @NotNull
    SharedPreferences getSharedPreferences();

    @Nullable
    String getString(@NotNull String str);

    @Nullable
    String getString(@NotNull String str, @Nullable String str2);

    @Nullable
    Set<String> getStringSet(@NotNull String str);

    void putBoolean(@NotNull String str, boolean z);

    void putFloat(@NotNull String str, float f);

    void putInt(@NotNull String str, int i);

    void putLong(@NotNull String str, long j);

    void putString(@NotNull String str, @Nullable String str2);

    void putStringSet(@NotNull String str, @Nullable Set<String> set);

    void remove(@NotNull String str);
}
