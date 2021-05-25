package com.avito.android.advert_core.analytics.broker;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/advert_core/analytics/broker/BankData;", "", "toAnalyticsParam", "(Lcom/avito/android/advert_core/analytics/broker/BankData;)Ljava/lang/String;", "advert-core_release"}, k = 2, mv = {1, 4, 2})
public final class BankDataKt {
    @NotNull
    public static final String toAnalyticsParam(@Nullable BankData bankData) {
        String json;
        return (bankData == null || (json = bankData.toJson()) == null) ? "empty: no banks" : json;
    }
}
