package com.avito.android.analytics.clickstream;

import com.avito.android.analytics.provider.clickstream.ClickStreamEvent;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/analytics/clickstream/ClickStreamEventTracker;", "", "Lcom/avito/android/analytics/provider/clickstream/ClickStreamEvent;", "event", "", "trackEvent", "(Lcom/avito/android/analytics/provider/clickstream/ClickStreamEvent;)V", "ClickStreamEventSaturator", "analytics-clickstream_release"}, k = 1, mv = {1, 4, 2})
public interface ClickStreamEventTracker {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001b\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/avito/android/analytics/clickstream/ClickStreamEventTracker$ClickStreamEventSaturator;", "", "", "", "environment", "()Ljava/util/Map;", "analytics-clickstream_release"}, k = 1, mv = {1, 4, 2})
    public interface ClickStreamEventSaturator {
        @NotNull
        Map<String, String> environment();
    }

    void trackEvent(@NotNull ClickStreamEvent clickStreamEvent);
}
