package com.avito.android.publish.analytics.events;

import androidx.core.app.NotificationCompat;
import com.avito.android.analytics.publish.PublishAnalyticsDataProvider;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"publish_release"}, k = 2, mv = {1, 4, 2})
public final class PublishInputsValidationErrorEventV4Kt {
    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0029: APUT  
      (r0v1 kotlin.Pair[])
      (2 ??[int, float, short, byte, char])
      (wrap: kotlin.Pair : 0x0024: INVOKE  (r4v3 kotlin.Pair) = ("categories"), (r5v1 java.util.List) type: STATIC call: kotlin.TuplesKt.to(java.lang.Object, java.lang.Object):kotlin.Pair)
     */
    public static final Map access$createParams(PublishAnalyticsDataProvider publishAnalyticsDataProvider, Map map, List list, String str) {
        Map<String, String> commonAnalyticsParameters = publishAnalyticsDataProvider.getCommonAnalyticsParameters();
        Pair[] pairArr = new Pair[4];
        pairArr[0] = TuplesKt.to(NotificationCompat.CATEGORY_ERROR, "400");
        pairArr[1] = TuplesKt.to("errorsDetailed", map);
        if (list == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        pairArr[2] = TuplesKt.to("categories", list);
        if (str == null) {
            str = "";
        }
        pairArr[3] = TuplesKt.to("infm_raw_params", str);
        return r.plus(commonAnalyticsParameters, r.mapOf(pairArr));
    }
}
