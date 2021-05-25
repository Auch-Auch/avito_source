package com.avito.android.util.preferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import androidx.preference.PreferenceManager;
import com.avito.android.db.sqlbrite.Database;
import com.avito.android.remote.auth.AuthSource;
import com.google.gson.Gson;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\u0018J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u000f\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0011\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/avito/android/util/preferences/PreferenceFactoryImpl;", "Lcom/avito/android/util/preferences/PreferenceFactory;", "Lcom/avito/android/db/sqlbrite/Database;", "database", "Lcom/google/gson/Gson;", "gson", "", "name", "Lcom/avito/android/util/preferences/Preferences;", "getDatabasePreferences", "(Lcom/avito/android/db/sqlbrite/Database;Lcom/google/gson/Gson;Ljava/lang/String;)Lcom/avito/android/util/preferences/Preferences;", "Landroid/content/Context;", "context", "getDefaultPreferences", "(Landroid/content/Context;)Lcom/avito/android/util/preferences/Preferences;", "getCustomPreferences", "(Landroid/content/Context;Ljava/lang/String;)Lcom/avito/android/util/preferences/Preferences;", "getCustomPreferencesName", "(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;", "Landroid/os/Handler;", AuthSource.SEND_ABUSE, "Landroid/os/Handler;", "mainThread", "<init>", "()V", "core_release"}, k = 1, mv = {1, 4, 2})
public final class PreferenceFactoryImpl implements PreferenceFactory {
    public final Handler a = new Handler(Looper.getMainLooper());

    @Override // com.avito.android.util.preferences.PreferenceFactory
    @NotNull
    public Preferences getCustomPreferences(@NotNull Context context, @NotNull String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "name");
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(getCustomPreferencesName(context, str), 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "preferences");
        return new SharedPreferencesImpl(sharedPreferences);
    }

    @Override // com.avito.android.util.preferences.PreferenceFactory
    @NotNull
    public String getCustomPreferencesName(@NotNull Context context, @NotNull String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "name");
        return context.getPackageName() + "_" + str;
    }

    @Override // com.avito.android.util.preferences.PreferenceFactory
    @NotNull
    public Preferences getDatabasePreferences(@NotNull Database database, @NotNull Gson gson, @NotNull String str) {
        Intrinsics.checkNotNullParameter(database, "database");
        Intrinsics.checkNotNullParameter(gson, "gson");
        Intrinsics.checkNotNullParameter(str, "name");
        return new DbPreferencesImpl(database, gson, this.a, str);
    }

    @Override // com.avito.android.util.preferences.PreferenceFactory
    @NotNull
    public Preferences getDefaultPreferences(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context.getApplicationContext());
        Intrinsics.checkNotNullExpressionValue(defaultSharedPreferences, "preferences");
        return new SharedPreferencesImpl(defaultSharedPreferences);
    }
}
