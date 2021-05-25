package com.avito.android.delivery.summary;

import a2.b.a.a.a;
import android.content.Context;
import android.content.Intent;
import com.avito.android.SummaryState;
import com.avito.android.delivery.map.start_ordering.DeliveryRdsStartOrderingActivityKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u001aC\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a\u001f\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u000e\u0010\u000f\"\u0016\u0010\u0010\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011\"\u0016\u0010\u0012\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0012\u0010\u0011\"\u0016\u0010\u0013\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0013\u0010\u0011¨\u0006\u0014"}, d2 = {"Landroid/content/Context;", "context", "", "searchContext", "Lcom/avito/android/SummaryState;", "summaryState", "", "isCart", "isMarketplace", "source", "Landroid/content/Intent;", "createDeliveryRdsSummaryIntent", "(Landroid/content/Context;Ljava/lang/String;Lcom/avito/android/SummaryState;ZZLjava/lang/String;)Landroid/content/Intent;", "payOrderId", "createDeliveryRdsPayOrderIntent", "(Landroid/content/Context;Ljava/lang/String;)Landroid/content/Intent;", "EXTRA_PAY_ORDER_ID", "Ljava/lang/String;", "EXTRA_SUMMARY_STATE", "EXTRA_SEARCH_CONTEXT", "delivery_release"}, k = 2, mv = {1, 4, 2})
public final class DeliveryRdsSummaryActivityKt {
    @NotNull
    public static final String EXTRA_PAY_ORDER_ID = "pay_order_id";
    @NotNull
    public static final String EXTRA_SEARCH_CONTEXT = "search_context";
    @NotNull
    public static final String EXTRA_SUMMARY_STATE = "summary_state";

    @NotNull
    public static final Intent createDeliveryRdsPayOrderIntent(@NotNull Context context, @NotNull String str) {
        return a.j1(context, "context", str, "payOrderId", context, DeliveryRdsSummaryActivity.class, EXTRA_PAY_ORDER_ID, str, "context.createActivityIn…PAY_ORDER_ID, payOrderId)");
    }

    @NotNull
    public static final Intent createDeliveryRdsSummaryIntent(@NotNull Context context, @Nullable String str, @NotNull SummaryState summaryState, boolean z, boolean z2, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(summaryState, "summaryState");
        Intent intent = new Intent(context, DeliveryRdsSummaryActivity.class);
        intent.putExtra(EXTRA_SUMMARY_STATE, summaryState);
        if (str != null) {
            intent.putExtra("search_context", str);
        }
        intent.putExtra(DeliveryRdsStartOrderingActivityKt.EXTRA_CART_FLAG, z);
        intent.putExtra(DeliveryRdsStartOrderingActivityKt.EXTRA_MARKETPLACE_FLAG, z2);
        intent.putExtra("source", str2);
        return intent;
    }
}
