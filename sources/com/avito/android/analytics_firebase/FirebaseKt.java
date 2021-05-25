package com.avito.android.analytics_firebase;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u001a5\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0000*\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"", "", "", "customerValue", "", "withCustomerValue", "(Ljava/util/Map;Ljava/lang/Double;)Ljava/util/Map;", "analytics-firebase_release"}, k = 2, mv = {1, 4, 2})
public final class FirebaseKt {
    @NotNull
    public static final Map<String, Object> withCustomerValue(@Nullable Map<String, String> map, @Nullable Double d) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (map != null) {
            linkedHashMap.putAll(map);
        }
        if (d != null) {
            d.doubleValue();
            linkedHashMap.put("value", d);
            linkedHashMap.put(FirebaseAnalytics.Param.CURRENCY, "RUB");
        }
        return linkedHashMap;
    }
}
