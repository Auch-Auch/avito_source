package com.avito.android.payment.processing;

import a2.b.a.a.a;
import android.content.Context;
import android.content.Intent;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.remote.model.category_parameters.ParametersTree;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a-\u0010\b\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\t\u001a\u001d\u0010\b\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\u000b¨\u0006\f"}, d2 = {"Landroid/content/Context;", "context", "", "paymentSessionId", "methodSignature", "Lcom/avito/android/remote/model/category_parameters/ParametersTree;", ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT, "Landroid/content/Intent;", "createPaymentProcessingActivity", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/category_parameters/ParametersTree;)Landroid/content/Intent;", AnalyticFieldsName.orderId, "(Landroid/content/Context;Ljava/lang/String;)Landroid/content/Intent;", "payment_release"}, k = 2, mv = {1, 4, 2})
public final class PaymentProcessingActivityKt {
    @NotNull
    public static final Intent createPaymentProcessingActivity(@NotNull Context context, @NotNull String str, @NotNull String str2, @NotNull ParametersTree parametersTree) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "paymentSessionId");
        Intrinsics.checkNotNullParameter(str2, "methodSignature");
        Intrinsics.checkNotNullParameter(parametersTree, ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT);
        Intent putExtra = new Intent(context, PaymentProcessingActivity.class).putExtra("PaymentProcessingActivity_session_id", str).putExtra("PaymentProcessingActivity_method_signature", str2).putExtra("PaymentProcessingActivity_parameters", parametersTree);
        Intrinsics.checkNotNullExpressionValue(putExtra, "Intent(context, PaymentP…A_PARAMETERS, parameters)");
        return putExtra;
    }

    @NotNull
    public static final Intent createPaymentProcessingActivity(@NotNull Context context, @NotNull String str) {
        return a.j1(context, "context", str, AnalyticFieldsName.orderId, context, PaymentProcessingActivity.class, "PaymentProcessingActivity_order_id", str, "Intent(context, PaymentP…(EXTRA_ORDER_ID, orderId)");
    }
}
