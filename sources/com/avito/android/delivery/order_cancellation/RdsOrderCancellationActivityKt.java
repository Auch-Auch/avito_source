package com.avito.android.delivery.order_cancellation;

import a2.b.a.a.a;
import android.content.Context;
import android.content.Intent;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001d\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroid/content/Context;", "context", "", AnalyticFieldsName.orderId, "Landroid/content/Intent;", "createRdsOrderCancellationIntent", "(Landroid/content/Context;Ljava/lang/String;)Landroid/content/Intent;", "delivery_release"}, k = 2, mv = {1, 4, 2})
public final class RdsOrderCancellationActivityKt {
    @NotNull
    public static final Intent createRdsOrderCancellationIntent(@NotNull Context context, @NotNull String str) {
        return a.j1(context, "context", str, AnalyticFieldsName.orderId, context, RdsOrderCancellationActivity.class, "EXTRA_ORDER_ID", str, "context.createActivityIn…(EXTRA_ORDER_ID, orderId)");
    }
}
