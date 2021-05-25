package com.avito.android.payment.form;

import android.content.Context;
import android.content.Intent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a%\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroid/content/Context;", "context", "", "sessionId", "methodSignature", "Landroid/content/Intent;", "createPaymentGenericFormActivity", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;", "payment_release"}, k = 2, mv = {1, 4, 2})
public final class PaymentGenericFormActivityKt {
    @NotNull
    public static final Intent createPaymentGenericFormActivity(@NotNull Context context, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "sessionId");
        Intrinsics.checkNotNullParameter(str2, "methodSignature");
        Intent putExtra = new Intent(context, PaymentGenericFormActivity.class).putExtra("PaymentGenericFormActivity_session_id", str).putExtra("PaymentGenericFormActivity_method_signature", str2);
        Intrinsics.checkNotNullExpressionValue(putExtra, "Intent(context, PaymentG…GNATURE, methodSignature)");
        return putExtra;
    }
}
