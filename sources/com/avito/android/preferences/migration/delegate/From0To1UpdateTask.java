package com.avito.android.preferences.migration.delegate;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\f\u001a\u00020\t8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/avito/android/preferences/migration/delegate/From0To1UpdateTask;", "Lcom/avito/android/preferences/migration/delegate/PreferenceUpdateTask;", "", "execute", "()V", "Landroid/content/SharedPreferences;", AuthSource.SEND_ABUSE, "Landroid/content/SharedPreferences;", "prefs", "", "getUpdateVersion", "()I", "updateVersion", "<init>", "(Landroid/content/SharedPreferences;)V", "core_release"}, k = 1, mv = {1, 4, 2})
public class From0To1UpdateTask implements PreferenceUpdateTask {
    public final SharedPreferences a;

    public From0To1UpdateTask(@NotNull SharedPreferences sharedPreferences) {
        Intrinsics.checkNotNullParameter(sharedPreferences, "prefs");
        this.a = sharedPreferences;
    }

    @Override // com.avito.android.preferences.migration.delegate.PreferenceUpdateTask
    @SuppressLint({"CommitPrefEdits"})
    public void execute() {
        SharedPreferences.Editor edit = this.a.edit();
        edit.remove("locationId");
        edit.remove(Constants.LOCATION_NAME);
        edit.remove(Constants.PARENT_LOCATION_ID);
        edit.remove(Constants.PARENT_LOCATION_NAME);
        edit.remove(Constants.LOC_HAS_METRO);
        edit.remove(Constants.LOC_HAS_DISTRICTS);
        edit.remove(Constants.LOC_HAS_DIRECTIONS).apply();
    }

    @Override // com.avito.android.preferences.migration.delegate.PreferenceUpdateTask
    public int getUpdateVersion() {
        return 0;
    }
}
