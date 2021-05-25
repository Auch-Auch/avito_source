package com.avito.android.payment.lib;

import a2.b.a.a.a;
import com.avito.android.remote.model.payment.service.OrderItem;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"payment-lib_release"}, k = 2, mv = {1, 4, 2})
public final class PaymentSessionInteractorKt {
    public static final Map access$toArrayQueryParams(Set set, String str) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int i = 0;
        for (Object obj : set) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            OrderItem orderItem = (OrderItem) obj;
            linkedHashMap.put(str + '[' + i + "][serviceSlug]", orderItem.getServiceSlug());
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append('[');
            linkedHashMap.put(a.j(sb, i, "][externalId]"), orderItem.getExternalId());
            i = i2;
        }
        return linkedHashMap;
    }
}
