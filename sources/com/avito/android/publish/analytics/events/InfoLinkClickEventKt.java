package com.avito.android.publish.analytics.events;

import com.avito.android.analytics.publish.PublishAnalyticsDataProvider;
import java.util.Map;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"publish_release"}, k = 2, mv = {1, 4, 2})
public final class InfoLinkClickEventKt {
    public static final Map access$createParams(PublishAnalyticsDataProvider publishAnalyticsDataProvider, String str) {
        Map<String, String> commonAnalyticsParameters = publishAnalyticsDataProvider.getCommonAnalyticsParameters();
        commonAnalyticsParameters.put("url", str);
        return commonAnalyticsParameters;
    }
}
