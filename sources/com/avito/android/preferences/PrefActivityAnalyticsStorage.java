package com.avito.android.preferences;

import a2.b.a.a.a;
import android.content.SharedPreferences;
import com.avito.android.preferences.ActivityAnalyticsStorage;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Logs;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import t6.n.e;
import t6.n.y;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0012¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0014\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/avito/android/preferences/PrefActivityAnalyticsStorage;", "Lcom/avito/android/preferences/ActivityAnalyticsStorage;", "Lcom/avito/android/preferences/ActivityAnalyticsStorage$ActivityRecord;", "activity", "", "saveActivity", "(Lcom/avito/android/preferences/ActivityAnalyticsStorage$ActivityRecord;)V", "removeActivity", "", "popActivities", "()Ljava/util/Collection;", "", "", AuthSource.SEND_ABUSE, "()Ljava/util/Set;", "record", AuthSource.BOOKING_ORDER, "(Lcom/avito/android/preferences/ActivityAnalyticsStorage$ActivityRecord;)Ljava/lang/String;", "Landroid/content/SharedPreferences;", "Landroid/content/SharedPreferences;", "preferences", "<init>", "(Landroid/content/SharedPreferences;)V", "core_release"}, k = 1, mv = {1, 4, 2})
public final class PrefActivityAnalyticsStorage implements ActivityAnalyticsStorage {
    public final SharedPreferences a;

    public PrefActivityAnalyticsStorage(@NotNull SharedPreferences sharedPreferences) {
        Intrinsics.checkNotNullParameter(sharedPreferences, "preferences");
        this.a = sharedPreferences;
    }

    public final Set<String> a() {
        return new HashSet(this.a.getStringSet("unexpected_exit_activities", y.emptySet()));
    }

    public final String b(ActivityAnalyticsStorage.ActivityRecord activityRecord) {
        return activityRecord.getId() + "@" + activityRecord.getName();
    }

    @Override // com.avito.android.preferences.ActivityAnalyticsStorage
    @NotNull
    public Collection<ActivityAnalyticsStorage.ActivityRecord> popActivities() {
        Set<String> a3 = a();
        this.a.edit().remove("unexpected_exit_activities").apply();
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(a3, 10));
        Iterator<T> it = a3.iterator();
        while (it.hasNext()) {
            List split$default = StringsKt__StringsKt.split$default((CharSequence) it.next(), new String[]{"@"}, false, 0, 6, (Object) null);
            arrayList.add(new ActivityAnalyticsStorage.ActivityRecord((String) CollectionsKt___CollectionsKt.first((List<? extends Object>) split$default), (String) CollectionsKt___CollectionsKt.last((List<? extends Object>) split$default)));
        }
        return arrayList;
    }

    @Override // com.avito.android.preferences.ActivityAnalyticsStorage
    public void removeActivity(@NotNull ActivityAnalyticsStorage.ActivityRecord activityRecord) {
        Intrinsics.checkNotNullParameter(activityRecord, "activity");
        String b = b(activityRecord);
        Set<String> a3 = a();
        boolean remove = ((HashSet) a3).remove(b);
        this.a.edit().putStringSet("unexpected_exit_activities", a3).apply();
        if (!remove) {
            StringBuilder L = a.L("Activity ");
            L.append(activityRecord.getName());
            L.append(" was not exist in storage");
            Logs.debug$default("PrefActivityAnalyticsStorage", L.toString(), null, 4, null);
        }
    }

    @Override // com.avito.android.preferences.ActivityAnalyticsStorage
    public void saveActivity(@NotNull ActivityAnalyticsStorage.ActivityRecord activityRecord) {
        Intrinsics.checkNotNullParameter(activityRecord, "activity");
        String b = b(activityRecord);
        Set<String> a3 = a();
        ((HashSet) a3).add(b);
        this.a.edit().putStringSet("unexpected_exit_activities", a3).apply();
    }
}
