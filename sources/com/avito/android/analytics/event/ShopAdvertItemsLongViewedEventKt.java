package com.avito.android.analytics.event;

import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"shop_release"}, k = 2, mv = {1, 4, 2})
public final class ShopAdvertItemsLongViewedEventKt {
    public static final Map access$createParams(String str, int i) {
        return r.mutableMapOf(TuplesKt.to("type", "5.0"), TuplesKt.to("count", Integer.valueOf(i)), TuplesKt.to("sid", str));
    }
}
