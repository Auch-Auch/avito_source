package com.avito.android.publish.analytics.events;

import com.avito.android.analytics.publish.PublishAnalyticsDataProvider;
import java.util.Map;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"publish_release"}, k = 2, mv = {1, 4, 2})
public final class ItemAddScreenOpenEventKt {
    public static final Map access$createParams(PublishAnalyticsDataProvider publishAnalyticsDataProvider, String str) {
        Map<String, String> commonAnalyticsParameters = publishAnalyticsDataProvider.getCommonAnalyticsParameters();
        if (str != null) {
            commonAnalyticsParameters.put("item_add_screen", str);
        }
        return commonAnalyticsParameters;
    }
}
