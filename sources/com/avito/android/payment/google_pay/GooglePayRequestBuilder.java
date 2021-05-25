package com.avito.android.payment.google_pay;

import com.google.android.gms.wallet.PaymentDataRequest;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/avito/android/payment/google_pay/GooglePayRequestBuilder;", "", "", "amount", "Lcom/google/android/gms/wallet/PaymentDataRequest;", "createPaymentDataRequest", "(Ljava/lang/String;)Lcom/google/android/gms/wallet/PaymentDataRequest;", "Lorg/json/JSONObject;", "getIsReadyToPayRequest", "()Lorg/json/JSONObject;", "payment-core_release"}, k = 1, mv = {1, 4, 2})
public interface GooglePayRequestBuilder {
    @NotNull
    PaymentDataRequest createPaymentDataRequest(@NotNull String str);

    @NotNull
    JSONObject getIsReadyToPayRequest();
}
