package com.avito.android.remote;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.interceptor.HeaderProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0007\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\n\u001a\u00020\u00028\u0016@\u0016XD¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u001c\u0010\u000e\u001a\u00020\u000b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/avito/android/remote/PaymentsPlanHeaderProvider;", "Lcom/avito/android/remote/interceptor/HeaderProvider;", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "value", AuthSource.SEND_ABUSE, "getKey", "key", "", "c", "Z", "isMandatory", "()Z", "paymentsPlan", "<init>", "(Ljava/lang/String;)V", "api_release"}, k = 1, mv = {1, 4, 2})
public class PaymentsPlanHeaderProvider implements HeaderProvider {
    @NotNull
    public final String a = "X-Payments-Plan";
    @NotNull
    public final String b;
    public final boolean c;

    public PaymentsPlanHeaderProvider(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "paymentsPlan");
        this.b = str;
        this.c = str.length() > 0;
    }

    @Override // com.avito.android.remote.interceptor.HeaderProvider
    @NotNull
    public String getKey() {
        return this.a;
    }

    @Override // com.avito.android.remote.interceptor.HeaderProvider
    @NotNull
    public String getValue() {
        return this.b;
    }

    @Override // com.avito.android.remote.interceptor.HeaderProvider
    public boolean isMandatory() {
        return this.c;
    }
}
