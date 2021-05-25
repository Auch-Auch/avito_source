package com.avito.android.payment.wallet.history.details;

import android.content.Context;
import android.content.Intent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a%\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroid/content/Context;", "context", "Lcom/avito/android/payment/wallet/history/details/PaymentDetailsType;", "paymentDetailsType", "", "id", "Landroid/content/Intent;", "createPaymentHistoryDetailsIntent", "(Landroid/content/Context;Lcom/avito/android/payment/wallet/history/details/PaymentDetailsType;Ljava/lang/String;)Landroid/content/Intent;", "payment_release"}, k = 2, mv = {1, 4, 2})
public final class PaymentHistoryDetailsActivityKt {
    @NotNull
    public static final Intent createPaymentHistoryDetailsIntent(@NotNull Context context, @NotNull PaymentDetailsType paymentDetailsType, @NotNull String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(paymentDetailsType, "paymentDetailsType");
        Intrinsics.checkNotNullParameter(str, "id");
        Intent putExtra = new Intent(context, PaymentHistoryDetailsActivity.class).putExtra("EXTRA_PAYMENT_DETAILS_TYPE", paymentDetailsType).putExtra("EXTRA_PAYMENT_DETAILS_ID", str);
        Intrinsics.checkNotNullExpressionValue(putExtra, "Intent(context, PaymentH…A_PAYMENT_DETAILS_ID, id)");
        return putExtra;
    }
}
