package com.avito.android.publish.slots.market_price.analytics;

import com.avito.android.analytics.publish.PublishAnalyticsDataProvider;
import com.avito.android.remote.model.category_parameters.slot.market_price.MarketPriceResponse;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"publish_release"}, k = 2, mv = {1, 4, 2})
public final class ItemAddImvShieldShowEventKt {
    public static final Map access$createParams(PublishAnalyticsDataProvider publishAnalyticsDataProvider, long j, long j2, MarketPriceResponse.PriceRange priceRange) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.putAll(publishAnalyticsDataProvider.getCommonAnalyticsParameters());
        linkedHashMap.put("price", Long.valueOf(j));
        linkedHashMap.put("market_price", Long.valueOf(j2));
        linkedHashMap.put("min_range", Long.valueOf(priceRange.getMin()));
        linkedHashMap.put("max_range", Long.valueOf(priceRange.getMax()));
        String priceType = priceRange.getPriceType();
        if (priceType != null) {
            linkedHashMap.put("shield_type", priceType);
        }
        return linkedHashMap;
    }
}
