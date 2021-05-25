package com.avito.android.analytics.screens.tracker;

import com.avito.android.analytics.screens.PublicConstantsKt;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J#\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/avito/android/analytics/screens/tracker/ViewDataPreparingTracker;", "Lcom/avito/android/analytics/screens/tracker/Tracker;", "", "page", "", PublicConstantsKt.FAILURE, "", "trackViewDataPreparing", "(Ljava/lang/Integer;Z)V", "analytics-screens_release"}, k = 1, mv = {1, 4, 2})
public interface ViewDataPreparingTracker extends Tracker {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ void trackViewDataPreparing$default(ViewDataPreparingTracker viewDataPreparingTracker, Integer num, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    num = null;
                }
                viewDataPreparingTracker.trackViewDataPreparing(num, z);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: trackViewDataPreparing");
        }
    }

    void trackViewDataPreparing(@Nullable Integer num, boolean z);
}
