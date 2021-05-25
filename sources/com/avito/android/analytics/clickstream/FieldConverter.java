package com.avito.android.analytics.clickstream;

import com.avito.android.remote.auth.AuthSource;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\f\u0010\rJ-\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00052\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/avito/android/analytics/clickstream/FieldConverter;", "", "", "", "fields", "", "convertFields", "(Ljava/util/Map;)Ljava/util/Map;", "Lcom/avito/android/analytics/clickstream/AnalyticMetricsFormatter;", AuthSource.SEND_ABUSE, "Lcom/avito/android/analytics/clickstream/AnalyticMetricsFormatter;", "metricsFormatter", "<init>", "(Lcom/avito/android/analytics/clickstream/AnalyticMetricsFormatter;)V", "analytics-clickstream_release"}, k = 1, mv = {1, 4, 2})
public final class FieldConverter {
    public final AnalyticMetricsFormatter a;

    public FieldConverter(@NotNull AnalyticMetricsFormatter analyticMetricsFormatter) {
        Intrinsics.checkNotNullParameter(analyticMetricsFormatter, "metricsFormatter");
        this.a = analyticMetricsFormatter;
    }

    @NotNull
    public final Map<String, String> convertFields(@NotNull Map<String, ? extends Object> map) {
        String str;
        Intrinsics.checkNotNullParameter(map, "fields");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, ? extends Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            boolean z = true;
            if (value instanceof Boolean) {
                str = String.valueOf(((Boolean) value).booleanValue() ? 1 : 0);
            } else if (value instanceof List) {
                str = CollectionsKt___CollectionsKt.joinToString$default((Iterable) value, ",", null, null, 0, null, new r4(0, this), 30, null);
            } else if (value instanceof Object[]) {
                str = ArraysKt___ArraysKt.joinToString$default((Object[]) value, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new r4(1, this), 30, (Object) null);
            } else {
                str = value.toString();
            }
            if (str.length() <= 0) {
                z = false;
            }
            if (z) {
                linkedHashMap.put(key, str);
            }
        }
        return linkedHashMap;
    }
}
