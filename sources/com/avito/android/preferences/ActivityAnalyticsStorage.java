package com.avito.android.preferences;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u000bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\u0006J\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\bH&¢\u0006\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/avito/android/preferences/ActivityAnalyticsStorage;", "", "Lcom/avito/android/preferences/ActivityAnalyticsStorage$ActivityRecord;", "activity", "", "saveActivity", "(Lcom/avito/android/preferences/ActivityAnalyticsStorage$ActivityRecord;)V", "removeActivity", "", "popActivities", "()Ljava/util/Collection;", "ActivityRecord", "core_release"}, k = 1, mv = {1, 4, 2})
public interface ActivityAnalyticsStorage {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J$\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0006\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0013\u001a\u0004\b\u0016\u0010\u0004¨\u0006\u0019"}, d2 = {"Lcom/avito/android/preferences/ActivityAnalyticsStorage$ActivityRecord;", "", "", "component1", "()Ljava/lang/String;", "component2", "id", "name", "copy", "(Ljava/lang/String;Ljava/lang/String;)Lcom/avito/android/preferences/ActivityAnalyticsStorage$ActivityRecord;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getId", AuthSource.BOOKING_ORDER, "getName", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "core_release"}, k = 1, mv = {1, 4, 2})
    public static final class ActivityRecord {
        @NotNull
        public final String a;
        @NotNull
        public final String b;

        public ActivityRecord(@NotNull String str, @NotNull String str2) {
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, "name");
            this.a = str;
            this.b = str2;
        }

        public static /* synthetic */ ActivityRecord copy$default(ActivityRecord activityRecord, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = activityRecord.a;
            }
            if ((i & 2) != 0) {
                str2 = activityRecord.b;
            }
            return activityRecord.copy(str, str2);
        }

        @NotNull
        public final String component1() {
            return this.a;
        }

        @NotNull
        public final String component2() {
            return this.b;
        }

        @NotNull
        public final ActivityRecord copy(@NotNull String str, @NotNull String str2) {
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, "name");
            return new ActivityRecord(str, str2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ActivityRecord)) {
                return false;
            }
            ActivityRecord activityRecord = (ActivityRecord) obj;
            return Intrinsics.areEqual(this.a, activityRecord.a) && Intrinsics.areEqual(this.b, activityRecord.b);
        }

        @NotNull
        public final String getId() {
            return this.a;
        }

        @NotNull
        public final String getName() {
            return this.b;
        }

        public int hashCode() {
            String str = this.a;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.b;
            if (str2 != null) {
                i = str2.hashCode();
            }
            return hashCode + i;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("ActivityRecord(id=");
            L.append(this.a);
            L.append(", name=");
            return a.t(L, this.b, ")");
        }
    }

    @NotNull
    Collection<ActivityRecord> popActivities();

    void removeActivity(@NotNull ActivityRecord activityRecord);

    void saveActivity(@NotNull ActivityRecord activityRecord);
}
