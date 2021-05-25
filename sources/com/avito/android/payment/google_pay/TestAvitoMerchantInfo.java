package com.avito.android.payment.google_pay;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0007\u001a\u00020\u00028\u0016@\u0016XD¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\r\u001a\u00020\b8\u0016@\u0016XD¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0010\u001a\u00020\u00028\u0016@\u0016XD¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/avito/android/payment/google_pay/TestAvitoMerchantInfo;", "Lcom/avito/android/payment/google_pay/AvitoMerchantInfo;", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getGatewayMerchantId", "()Ljava/lang/String;", "gatewayMerchantId", "", "c", "I", "getEnvironment", "()I", "environment", AuthSource.SEND_ABUSE, "getName", "name", "<init>", "()V", "payment-core_release"}, k = 1, mv = {1, 4, 2})
public final class TestAvitoMerchantInfo implements AvitoMerchantInfo {
    @NotNull
    public final String a = "Avito Test";
    @NotNull
    public final String b = "avito_1";
    public final int c = 3;

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
