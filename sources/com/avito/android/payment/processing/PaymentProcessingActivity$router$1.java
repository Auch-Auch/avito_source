package com.avito.android.payment.processing;

import android.content.Intent;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.PaymentStatusLink;
import com.avito.android.remote.model.payment.status.PaymentStatusResult;
import com.facebook.share.internal.ShareConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\f\u0010\n¨\u0006\r"}, d2 = {"com/avito/android/payment/processing/PaymentProcessingActivity$router$1", "Lcom/avito/android/payment/processing/PaymentProcessingRouter;", "Lcom/avito/android/remote/model/payment/status/PaymentStatusResult$PaymentStatus;", "status", "", "onStatusDelivered", "(Lcom/avito/android/remote/model/payment/status/PaymentStatusResult$PaymentStatus;)V", "", ShareConstants.MEDIA_URI, "onPaymentResult", "(Ljava/lang/String;)V", "message", "onError", "payment_release"}, k = 1, mv = {1, 4, 2})
public final class PaymentProcessingActivity$router$1 implements PaymentProcessingRouter {
    public final /* synthetic */ PaymentProcessingActivity a;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    public PaymentProcessingActivity$router$1(PaymentProcessingActivity paymentProcessingActivity) {
        this.a = paymentProcessingActivity;
    }

    @Override // com.avito.android.payment.processing.PaymentProcessingRouter
    public void onError(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        Intent intent = new Intent();
        intent.putExtra(PaymentProcessingConstants.EXTRA_PAYMENT_ERROR_RESULT, str);
        this.a.setResult(0, intent);
        this.a.finish();
    }

    @Override // com.avito.android.payment.processing.PaymentProcessingRouter
    public void onPaymentResult(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, ShareConstants.MEDIA_URI);
        DeepLink createFromUri = this.a.getDeepLinkFactory().createFromUri(str);
        if (createFromUri instanceof PaymentStatusLink) {
            this.a.startActivity(this.a.getDeepLinkIntentFactory().getIntent(createFromUri));
            return;
        }
        Intent intent = new Intent();
        intent.putExtra(PaymentProcessingConstants.EXTRA_PAYMENT_REDIRECT_RESULT, str);
        this.a.setResult(-1, intent);
        this.a.finish();
    }

    @Override // com.avito.android.payment.processing.PaymentProcessingRouter
    public void onStatusDelivered(@NotNull PaymentStatusResult.PaymentStatus paymentStatus) {
        Intrinsics.checkNotNullParameter(paymentStatus, "status");
        Intent intent = new Intent();
        intent.putExtra(PaymentProcessingConstants.EXTRA_PAYMENT_STATUS_RESULT, paymentStatus);
        this.a.setResult(-1, intent);
        this.a.finish();
    }
}
