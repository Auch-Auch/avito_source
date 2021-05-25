package com.avito.android.analytics.screens.tracker;

import com.yandex.mobile.ads.video.tracking.Tracker;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/avito/android/analytics/screens/tracker/ScreenInitTracker;", "", "", Tracker.Events.CREATIVE_START, "()V", "", "durationMs", "trackInit", "(J)V", "analytics-screens_release"}, k = 1, mv = {1, 4, 2})
public interface ScreenInitTracker {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ void trackInit$default(ScreenInitTracker screenInitTracker, long j, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    j = -1;
                }
                screenInitTracker.trackInit(j);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: trackInit");
        }
    }

    void start();

    void trackInit(long j);
}
