package com.avito.android.safedeal.delivery_courier.time_interval_select;

import android.content.Context;
import android.content.Intent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a%\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007\"\u0016\u0010\b\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\b\u0010\t\"\u0016\u0010\n\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\n\u0010\t\"\u0016\u0010\u000b\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u000b\u0010\t¨\u0006\f"}, d2 = {"Landroid/content/Context;", "context", "", "orderID", "source", "Landroid/content/Intent;", "createDeliveryCourierDateRangeSelectIntent", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;", DeliveryCourierTimeIntervalSelectActivityKt.EXTRA_SELECTED, "Ljava/lang/String;", "EXTRA_ORDER_ID", "EXTRA_SOURCE", "safedeal_release"}, k = 2, mv = {1, 4, 2})
public final class DeliveryCourierTimeIntervalSelectActivityKt {
    @NotNull
    public static final String EXTRA_ORDER_ID = "EXTRA_ORDER_ID";
    @NotNull
    public static final String EXTRA_SELECTED = "EXTRA_SELECTED";
    @NotNull
    public static final String EXTRA_SOURCE = "EXTRA_SOURCE";

    @NotNull
    public static final Intent createDeliveryCourierDateRangeSelectIntent(@NotNull Context context, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "orderID");
        Intrinsics.checkNotNullParameter(str2, "source");
        Intent putExtra = new Intent(context, DeliveryCourierTimeIntervalSelectActivity.class).putExtra("EXTRA_ORDER_ID", str).putExtra("EXTRA_SOURCE", str2);
        Intrinsics.checkNotNullExpressionValue(putExtra, "context.createActivityIn…tra(EXTRA_SOURCE, source)");
        return putExtra;
    }
}
