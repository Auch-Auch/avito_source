package com.avito.android.analytics.event.notification_center;

import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"analytics_release"}, k = 2, mv = {1, 4, 2})
public final class NotificationButtonClickEventKt {
    public static final Map access$combineParams(Map map, String str) {
        Map mutableMapOf = r.mutableMapOf(TuplesKt.to("button_name", str));
        mutableMapOf.putAll(map);
        return mutableMapOf;
    }
}
