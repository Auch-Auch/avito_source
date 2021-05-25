package com.avito.android.advert_core.analytics.broker.events;

import a2.a.a.g.b.a.e.a;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"advert-core_release"}, k = 2, mv = {1, 4, 2})
public final class CreditFormCompleteEventKt {
    public static final String access$toJson(List list) {
        if (list.isEmpty()) {
            return "empty: no banks";
        }
        return CollectionsKt___CollectionsKt.joinToString$default(list, ",", "[", "]", 0, null, a.a, 24, null);
    }
}
