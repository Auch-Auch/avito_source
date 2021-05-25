package com.avito.android.analytics.events;

import a2.a.a.i.e.a;
import com.avito.android.analytics.Analytics;
import com.avito.android.remote.model.ab_tests.AnalyticsParams;
import com.avito.android.remote.model.ab_tests.WithClientExposure;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/avito/android/remote/model/ab_tests/WithClientExposure;", "Lcom/avito/android/analytics/Analytics;", "analytics", "", "exposeIfNeeded", "(Lcom/avito/android/remote/model/ab_tests/WithClientExposure;Lcom/avito/android/analytics/Analytics;)V", "ab-tests_release"}, k = 2, mv = {1, 4, 2})
public final class ExposureEventKt {
    public static final boolean access$shouldExpose(AnalyticsParams analyticsParams) {
        return analyticsParams != null && analyticsParams.getClientExposure();
    }

    public static final void exposeIfNeeded(@NotNull WithClientExposure withClientExposure, @NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(withClientExposure, "$this$exposeIfNeeded");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        AnalyticsParams analyticParams = withClientExposure.getAnalyticParams();
        if (analyticParams != null && analyticParams.getClientExposure()) {
            analytics.track(new a(withClientExposure));
        }
    }
}
