package com.avito.android.payment.google_pay;

import android.app.Activity;
import android.content.Intent;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.social.AppleSignInManagerKt;
import com.google.android.gms.wallet.AutoResolveHelper;
import com.google.android.gms.wallet.PaymentData;
import com.google.android.gms.wallet.PaymentsClient;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\u0006\u0010\u0014\u001a\u00020\u0011¢\u0006\u0004\b\u0019\u0010\u001aJ'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/avito/android/payment/google_pay/GooglePayInteractor;", "", "Landroid/app/Activity;", "activity", "", "requestCode", "", "amount", "", "startGooglePay", "(Landroid/app/Activity;ILjava/lang/String;)V", "Landroid/content/Intent;", "data", "extractPaymentToken", "(Landroid/content/Intent;)Ljava/lang/String;", "handleGooglePayError", "(Landroid/content/Intent;)V", "Lcom/avito/android/payment/google_pay/GooglePayRequestBuilder;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/payment/google_pay/GooglePayRequestBuilder;", "googlePayRequestBuilder", "Lcom/google/android/gms/wallet/PaymentsClient;", AuthSource.SEND_ABUSE, "Lcom/google/android/gms/wallet/PaymentsClient;", "paymentsClient", "<init>", "(Lcom/google/android/gms/wallet/PaymentsClient;Lcom/avito/android/payment/google_pay/GooglePayRequestBuilder;)V", "payment-core_release"}, k = 1, mv = {1, 4, 2})
public class GooglePayInteractor {
    public final PaymentsClient a;
    public final GooglePayRequestBuilder b;

    public GooglePayInteractor(@NotNull PaymentsClient paymentsClient, @NotNull GooglePayRequestBuilder googlePayRequestBuilder) {
        Intrinsics.checkNotNullParameter(paymentsClient, "paymentsClient");
        Intrinsics.checkNotNullParameter(googlePayRequestBuilder, "googlePayRequestBuilder");
        this.a = paymentsClient;
        this.b = googlePayRequestBuilder;
    }

    @NotNull
    public String extractPaymentToken(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "data");
        PaymentData fromIntent = PaymentData.getFromIntent(intent);
        Intrinsics.checkNotNull(fromIntent);
        String string = new JSONObject(fromIntent.toJson()).getJSONObject("paymentMethodData").getJSONObject("tokenizationData").getString(AppleSignInManagerKt.EXTRA_APPLE_TOKEN);
        Intrinsics.checkNotNullExpressionValue(string, "paymentMethodsData.getJS…Data\").getString(\"token\")");
        return string;
    }

    public void handleGooglePayError(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "data");
        AutoResolveHelper.getStatusFromIntent(intent);
    }

    public void startGooglePay(@NotNull Activity activity, int i, @NotNull String str) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(str, "amount");
        AutoResolveHelper.resolveTask(this.a.loadPaymentData(this.b.createPaymentDataRequest(str)), activity, i);
    }
}
