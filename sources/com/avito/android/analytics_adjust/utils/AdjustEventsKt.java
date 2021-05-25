package com.avito.android.analytics_adjust.utils;

import com.adjust.sdk.AdjustEvent;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0004\u001a\u0019\u0010\u0003\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0019\u0010\u0007\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\b\u001a\u001b\u0010\u000b\u001a\u00020\u0000*\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\f\u001a'\u0010\u000f\u001a\u00020\u0000*\u00020\u00002\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\r¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/adjust/sdk/AdjustEvent;", "Lcom/avito/android/analytics_adjust/utils/AdjustContentType;", "contentType", "withContentType", "(Lcom/adjust/sdk/AdjustEvent;Lcom/avito/android/analytics_adjust/utils/AdjustContentType;)Lcom/adjust/sdk/AdjustEvent;", "", "contentId", "withContentIds", "(Lcom/adjust/sdk/AdjustEvent;Ljava/lang/String;)Lcom/adjust/sdk/AdjustEvent;", "", "customerValue", "withCustomerValue", "(Lcom/adjust/sdk/AdjustEvent;Ljava/lang/Double;)Lcom/adjust/sdk/AdjustEvent;", "", "params", "withParams", "(Lcom/adjust/sdk/AdjustEvent;Ljava/util/Map;)Lcom/adjust/sdk/AdjustEvent;", "analytics-adjust_release"}, k = 2, mv = {1, 4, 2})
public final class AdjustEventsKt {
    @NotNull
    public static final AdjustEvent withContentIds(@NotNull AdjustEvent adjustEvent, @NotNull String str) {
        Intrinsics.checkNotNullParameter(adjustEvent, "$this$withContentIds");
        Intrinsics.checkNotNullParameter(str, "contentId");
        adjustEvent.addPartnerParameter("content_ids", str);
        return adjustEvent;
    }

    @NotNull
    public static final AdjustEvent withContentType(@NotNull AdjustEvent adjustEvent, @NotNull AdjustContentType adjustContentType) {
        Intrinsics.checkNotNullParameter(adjustEvent, "$this$withContentType");
        Intrinsics.checkNotNullParameter(adjustContentType, "contentType");
        adjustEvent.addPartnerParameter(FirebaseAnalytics.Param.CONTENT_TYPE, adjustContentType.getValue$analytics_adjust_release());
        return adjustEvent;
    }

    @NotNull
    public static final AdjustEvent withCustomerValue(@NotNull AdjustEvent adjustEvent, @Nullable Double d) {
        Intrinsics.checkNotNullParameter(adjustEvent, "$this$withCustomerValue");
        if (d != null) {
            adjustEvent.addPartnerParameter("value", String.valueOf(d.doubleValue()));
        }
        return adjustEvent;
    }

    @NotNull
    public static final AdjustEvent withParams(@NotNull AdjustEvent adjustEvent, @Nullable Map<String, String> map) {
        Intrinsics.checkNotNullParameter(adjustEvent, "$this$withParams");
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                adjustEvent.addPartnerParameter(entry.getKey(), entry.getValue());
            }
        }
        return adjustEvent;
    }
}
