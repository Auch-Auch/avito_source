package com.avito.android.payment.lib;

import com.avito.android.Features;
import com.avito.android.payment.lib.PaymentSessionType;
import com.avito.android.payment.remote.PaymentApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.model.payment.generic.PaymentGenericResult;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.q;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J9\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/avito/android/payment/lib/PaymentGenericInteractor;", "", "Lcom/avito/android/payment/lib/PaymentSessionType;", "paymentSessionType", "", "paymentSessionId", "methodSignature", "paymentToken", "Lio/reactivex/Observable;", "Lcom/avito/android/remote/model/TypedResult;", "Lcom/avito/android/remote/model/payment/generic/PaymentGenericResult;", "paymentGeneric", "(Lcom/avito/android/payment/lib/PaymentSessionType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "Lcom/avito/android/payment/remote/PaymentApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/payment/remote/PaymentApi;", "paymentApi", "Lcom/avito/android/Features;", "features", "<init>", "(Lcom/avito/android/payment/remote/PaymentApi;Lcom/avito/android/Features;)V", "payment-lib_release"}, k = 1, mv = {1, 4, 2})
public final class PaymentGenericInteractor {
    public final PaymentApi a;

    public PaymentGenericInteractor(@NotNull PaymentApi paymentApi, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(paymentApi, "paymentApi");
        Intrinsics.checkNotNullParameter(features, "features");
        this.a = paymentApi;
    }

    @NotNull
    public final Observable<TypedResult<PaymentGenericResult>> paymentGeneric(@NotNull PaymentSessionType paymentSessionType, @NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(paymentSessionType, "paymentSessionType");
        Intrinsics.checkNotNullParameter(str, "paymentSessionId");
        Intrinsics.checkNotNullParameter(str2, "methodSignature");
        Intrinsics.checkNotNullParameter(str3, "paymentToken");
        if (paymentSessionType instanceof PaymentSessionType.Services) {
            return InteropKt.toV2(this.a.createPayment(str, str2, q.mapOf(TuplesKt.to("paymentToken", str3))));
        }
        if (paymentSessionType instanceof PaymentSessionType.LegacyServices) {
            return InteropKt.toV2(this.a.legacyCreatePayment(str, str2, q.mapOf(TuplesKt.to("paymentToken", str3))));
        }
        if (paymentSessionType instanceof PaymentSessionType.Wallet) {
            return InteropKt.toV2(this.a.createPayment(str, str2, q.mapOf(TuplesKt.to("paymentToken", str3))));
        }
        throw new NoWhenBranchMatchedException();
    }
}
