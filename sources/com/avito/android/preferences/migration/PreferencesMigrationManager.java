package com.avito.android.preferences.migration;

import android.content.SharedPreferences;
import com.avito.android.preferences.migration.delegate.PreferenceUpdateTask;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Logs;
import com.avito.android.util.preferences.Preference;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.o.a;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u001c\u0010\u000e\u001a\u00020\n8\u0016@\u0016XD¢\u0006\f\n\u0004\b\u0005\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/avito/android/preferences/migration/PreferencesMigrationManager;", "", "", "migrate", "()V", AuthSource.SEND_ABUSE, "Landroid/content/SharedPreferences;", AuthSource.BOOKING_ORDER, "Landroid/content/SharedPreferences;", "prefs", "", "I", "getSchemeVersion", "()I", "schemeVersion", "", "Lcom/avito/android/preferences/migration/delegate/PreferenceUpdateTask;", "c", "Ljava/util/List;", "tasks", "<init>", "(Landroid/content/SharedPreferences;Ljava/util/List;)V", "core_release"}, k = 1, mv = {1, 4, 2})
public class PreferencesMigrationManager {
    public final int a = 2;
    public final SharedPreferences b;
    public final List<PreferenceUpdateTask> c;

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.List<? extends com.avito.android.preferences.migration.delegate.PreferenceUpdateTask> */
    /* JADX WARN: Multi-variable type inference failed */
    public PreferencesMigrationManager(@NotNull SharedPreferences sharedPreferences, @NotNull List<? extends PreferenceUpdateTask> list) {
        Intrinsics.checkNotNullParameter(sharedPreferences, "prefs");
        Intrinsics.checkNotNullParameter(list, "tasks");
        this.b = sharedPreferences;
        this.c = list;
    }

    public final void a() {
        SharedPreferences.Editor edit = this.b.edit();
        edit.putInt(Preference.SCHEME_VERSION, getSchemeVersion());
        edit.apply();
    }

    public int getSchemeVersion() {
        return this.a;
    }

    public void migrate() {
        int schemeVersion = getSchemeVersion();
        try {
            List sortedWith = CollectionsKt___CollectionsKt.sortedWith(this.c, new Comparator<T>() { // from class: com.avito.android.preferences.migration.PreferencesMigrationManager$migrate$$inlined$sortedBy$1
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return a.compareValues(Integer.valueOf(t.getUpdateVersion()), Integer.valueOf(t2.getUpdateVersion()));
                }
            });
            for (int i = this.b.getInt(Preference.SCHEME_VERSION, 0); i < schemeVersion; i++) {
                ((PreferenceUpdateTask) sortedWith.get(i)).execute();
            }
        } catch (Exception e) {
            SharedPreferences.Editor edit = this.b.edit();
            edit.clear();
            edit.apply();
            Logs.error("PreferencesMigrationHelper", "update error", e);
        } catch (Throwable th) {
            a();
            throw th;
        }
        a();
    }
}
