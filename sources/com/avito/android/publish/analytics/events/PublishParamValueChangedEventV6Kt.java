package com.avito.android.publish.analytics.events;

import com.avito.android.analytics.publish.PublishAnalyticsDataProvider;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"publish_release"}, k = 2, mv = {1, 4, 2})
public final class PublishParamValueChangedEventV6Kt {
    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0027: APUT  
      (r0v1 kotlin.Pair[])
      (2 ??[int, float, short, byte, char])
      (wrap: kotlin.Pair : 0x0022: INVOKE  (r2v5 kotlin.Pair) = ("categories"), (r4v1 java.util.List) type: STATIC call: kotlin.TuplesKt.to(java.lang.Object, java.lang.Object):kotlin.Pair)
     */
    public static final Map access$createParams(String str, String str2, List list, String str3, PublishAnalyticsDataProvider publishAnalyticsDataProvider) {
        Map<String, String> commonAnalyticsParameters = publishAnalyticsDataProvider.getCommonAnalyticsParameters();
        Pair[] pairArr = new Pair[4];
        pairArr[0] = TuplesKt.to("form_input_field_name", str);
        pairArr[1] = TuplesKt.to("form_input_field_value", str2);
        if (list == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        pairArr[2] = TuplesKt.to("categories", list);
        if (str3 == null) {
            str3 = "";
        }
        pairArr[3] = TuplesKt.to("infm_raw_params", str3);
        return r.plus(commonAnalyticsParameters, r.mapOf(pairArr));
    }
}
