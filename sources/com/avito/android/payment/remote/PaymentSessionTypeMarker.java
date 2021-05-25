package com.avito.android.payment.remote;

import androidx.core.app.NotificationCompat;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.payment.PaymentMethodTypeKt;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/avito/android/payment/remote/PaymentSessionTypeMarker;", "", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "type", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "SERVICE", "LEGACY_SERVICE", "WALLET", "payment_release"}, k = 1, mv = {1, 4, 2})
public enum PaymentSessionTypeMarker {
    SERVICE(NotificationCompat.CATEGORY_SERVICE),
    LEGACY_SERVICE("legacy_service"),
    WALLET(PaymentMethodTypeKt.PAYMENT_METHOD_TYPE_WALLET);
    
    @NotNull
    public final String a;

    /* access modifiers changed from: public */
    PaymentSessionTypeMarker(String str) {
        this.a = str;
    }

    @NotNull
    public final String getType() {
        return this.a;
    }
}
