package com.avito.android.payment.google_pay;

import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.payment.PaymentMethodTypeKt;
import com.google.android.gms.wallet.PaymentDataRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\tJ\u000f\u0010\u000b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000b\u0010\tR\u0016\u0010\u000e\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/payment/google_pay/GooglePayRequestBuilderImpl;", "Lcom/avito/android/payment/google_pay/GooglePayRequestBuilder;", "", "amount", "Lcom/google/android/gms/wallet/PaymentDataRequest;", "createPaymentDataRequest", "(Ljava/lang/String;)Lcom/google/android/gms/wallet/PaymentDataRequest;", "Lorg/json/JSONObject;", "getIsReadyToPayRequest", "()Lorg/json/JSONObject;", AuthSource.SEND_ABUSE, AuthSource.BOOKING_ORDER, "Lcom/avito/android/payment/google_pay/AvitoMerchantInfo;", "Lcom/avito/android/payment/google_pay/AvitoMerchantInfo;", "avitoMerchantInfo", "<init>", "(Lcom/avito/android/payment/google_pay/AvitoMerchantInfo;)V", "payment-core_release"}, k = 1, mv = {1, 4, 2})
public final class GooglePayRequestBuilderImpl implements GooglePayRequestBuilder {
    public final AvitoMerchantInfo a;

    public GooglePayRequestBuilderImpl(@NotNull AvitoMerchantInfo avitoMerchantInfo) {
        Intrinsics.checkNotNullParameter(avitoMerchantInfo, "avitoMerchantInfo");
        this.a = avitoMerchantInfo;
    }

    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("type", "CARD");
        JSONObject jSONObject2 = new JSONObject();
        JSONArray put = new JSONArray().put("CRYPTOGRAM_3DS").put("PAN_ONLY");
        Intrinsics.checkNotNullExpressionValue(put, "JSONArray()\n            …         .put(\"PAN_ONLY\")");
        JSONObject put2 = jSONObject2.put("allowedAuthMethods", put);
        JSONArray put3 = new JSONArray().put("MASTERCARD").put("VISA");
        Intrinsics.checkNotNullExpressionValue(put3, "JSONArray()\n            …\n            .put(\"VISA\")");
        jSONObject.put(ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT, put2.put("allowedCardNetworks", put3));
        return jSONObject;
    }

    public final JSONObject b() {
        JSONObject put = new JSONObject().put("apiVersion", 2).put("apiVersionMinor", 0);
        Intrinsics.checkNotNullExpressionValue(put, "JSONObject()\n           …put(\"apiVersionMinor\", 0)");
        return put;
    }

    @Override // com.avito.android.payment.google_pay.GooglePayRequestBuilder
    @NotNull
    public PaymentDataRequest createPaymentDataRequest(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "amount");
        JSONObject b = b();
        JSONArray jSONArray = new JSONArray();
        JSONObject a3 = a();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("type", "PAYMENT_GATEWAY");
        jSONObject.put(ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT, new JSONObject().put("gateway", PaymentMethodTypeKt.PAYMENT_METHOD_TYPE_SBERBANK).put("gatewayMerchantId", this.a.getGatewayMerchantId()));
        a3.put("tokenizationSpecification", jSONObject);
        b.put("allowedPaymentMethods", jSONArray.put(a3));
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("totalPrice", str);
        jSONObject2.put("totalPriceStatus", "FINAL");
        jSONObject2.put("currencyCode", "RUB");
        b.put("transactionInfo", jSONObject2);
        JSONObject put = new JSONObject().put("merchantName", this.a.getName());
        Intrinsics.checkNotNullExpressionValue(put, "JSONObject()\n           …, avitoMerchantInfo.name)");
        b.put("merchantInfo", put);
        PaymentDataRequest fromJson = PaymentDataRequest.fromJson(b.toString());
        Intrinsics.checkNotNullExpressionValue(fromJson, "PaymentDataRequest.fromJ…quest(amount).toString())");
        return fromJson;
    }

    @Override // com.avito.android.payment.google_pay.GooglePayRequestBuilder
    @NotNull
    public JSONObject getIsReadyToPayRequest() {
        JSONObject b = b();
        b.put("allowedPaymentMethods", new JSONArray().put(a()));
        return b;
    }
}
