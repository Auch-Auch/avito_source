package com.avito.android.payment.google_pay;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0007\u001a\u00020\u00028\u0016@\u0016XD¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\n\u001a\u00020\u00028\u0016@\u0016XD¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u001c\u0010\u0010\u001a\u00020\u000b8\u0016@\u0016XD¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/avito/android/payment/google_pay/ProdAvitoMerchantInfo;", "Lcom/avito/android/payment/google_pay/AvitoMerchantInfo;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "name", AuthSource.BOOKING_ORDER, "getGatewayMerchantId", "gatewayMerchantId", "", "c", "I", "getEnvironment", "()I", "environment", "<init>", "()V", "payment-core_release"}, k = 1, mv = {1, 4, 2})
public final class ProdAvitoMerchantInfo implements AvitoMerchantInfo {
    @NotNull
    public final String a = "Avito";
    @NotNull
    public final String b = "avito";
    public final int c = 1;

    @Override // com.avito.android.payment.google_pay.AvitoMerchantInfo
    public int getEnvironment() {
        return this.c;
    }

    @Override // com.avito.android.payment.google_pay.AvitoMerchantInfo
    @NotNull
    public String getGatewayMerchantId() {
        return this.b;
    }

    @Override // com.avito.android.payment.google_pay.AvitoMerchantInfo
    @NotNull
    public String getName() {
        return this.a;
    }
}
