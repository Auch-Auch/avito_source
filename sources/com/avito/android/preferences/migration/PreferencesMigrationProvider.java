package com.avito.android.preferences.migration;

import android.content.SharedPreferences;
import com.avito.android.preferences.migration.delegate.From0To1UpdateTask;
import com.avito.android.preferences.migration.delegate.From1To2UpdateTask;
import com.avito.android.preferences.migration.delegate.PreferenceUpdateTask;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/avito/android/preferences/migration/PreferencesMigrationProvider;", "", "Landroid/content/SharedPreferences;", "preferences", "", "Lcom/avito/android/preferences/migration/delegate/PreferenceUpdateTask;", "provide", "(Landroid/content/SharedPreferences;)Ljava/util/List;", "<init>", "()V", "core_release"}, k = 1, mv = {1, 4, 2})
public final class PreferencesMigrationProvider {
    @NotNull
    public final List<PreferenceUpdateTask> provide(@NotNull SharedPreferences sharedPreferences) {
        Intrinsics.checkNotNullParameter(sharedPreferences, "preferences");
        return CollectionsKt__CollectionsKt.mutableListOf(new From0To1UpdateTask(sharedPreferences), new From1To2UpdateTask(sharedPreferences));
    }
}
