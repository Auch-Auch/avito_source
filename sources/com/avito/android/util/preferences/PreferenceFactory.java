package com.avito.android.util.preferences;

import android.content.Context;
import com.avito.android.db.sqlbrite.Database;
import com.google.gson.Gson;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u000f\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0011\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/avito/android/util/preferences/PreferenceFactory;", "", "Lcom/avito/android/db/sqlbrite/Database;", "database", "Lcom/google/gson/Gson;", "gson", "", "name", "Lcom/avito/android/util/preferences/Preferences;", "getDatabasePreferences", "(Lcom/avito/android/db/sqlbrite/Database;Lcom/google/gson/Gson;Ljava/lang/String;)Lcom/avito/android/util/preferences/Preferences;", "Landroid/content/Context;", "context", "getDefaultPreferences", "(Landroid/content/Context;)Lcom/avito/android/util/preferences/Preferences;", "getCustomPreferences", "(Landroid/content/Context;Ljava/lang/String;)Lcom/avito/android/util/preferences/Preferences;", "getCustomPreferencesName", "(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;", "core_release"}, k = 1, mv = {1, 4, 2})
public interface PreferenceFactory {
    @NotNull
    Preferences getCustomPreferences(@NotNull Context context, @NotNull String str);

    @NotNull
    String getCustomPreferencesName(@NotNull Context context, @NotNull String str);

    @NotNull
    Preferences getDatabasePreferences(@NotNull Database database, @NotNull Gson gson, @NotNull String str);

    @NotNull
    Preferences getDefaultPreferences(@NotNull Context context);
}
