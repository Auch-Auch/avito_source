package com.avito.android.analytics.screens.tracker;

import com.avito.android.analytics.screens.PublicConstantsKt;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J-\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/analytics/screens/tracker/ContentLoadingTracker;", "Lcom/avito/android/analytics/screens/tracker/Tracker;", "", "page", "", PublicConstantsKt.FAILURE, "", "durationMs", "", "trackContentLoading", "(Ljava/lang/Integer;Ljava/lang/String;J)V", "analytics-screens_release"}, k = 1, mv = {1, 4, 2})
public interface ContentLoadingTracker extends Tracker {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ void trackContentLoading$default(ContentLoadingTracker contentLoadingTracker, Integer num, String str, long j, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    num = null;
                }
                if ((i & 4) != 0) {
                    j = -1;
                }
                contentLoadingTracker.trackContentLoading(num, str, j);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: trackContentLoading");
        }
    }

    void trackContentLoading(@Nullable Integer num, @NotNull String str, long j);
}
