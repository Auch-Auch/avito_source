package com.avito.android.payment.wallet.history;

import com.avito.android.payment.remote.PaymentApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.model.payment.history.PaymentHistoryPage;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\n¢\u0006\u0004\b\u000e\u0010\u000fJ-\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00052\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/payment/wallet/history/PaymentHistoryInteractor;", "", "", "historyId", "pageToken", "Lio/reactivex/Observable;", "Lcom/avito/android/remote/model/TypedResult;", "Lcom/avito/android/remote/model/payment/history/PaymentHistoryPage;", "getPaymentHistory", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "Lcom/avito/android/payment/remote/PaymentApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/payment/remote/PaymentApi;", "paymentApi", "<init>", "(Lcom/avito/android/payment/remote/PaymentApi;)V", "payment_release"}, k = 1, mv = {1, 4, 2})
public final class PaymentHistoryInteractor {
    public final PaymentApi a;

    public PaymentHistoryInteractor(@NotNull PaymentApi paymentApi) {
        Intrinsics.checkNotNullParameter(paymentApi, "paymentApi");
        this.a = paymentApi;
    }

    public static /* synthetic */ Observable getPaymentHistory$default(PaymentHistoryInteractor paymentHistoryInteractor, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        return paymentHistoryInteractor.getPaymentHistory(str, str2);
    }

    @NotNull
    public final Observable<TypedResult<PaymentHistoryPage>> getPaymentHistory(@NotNull String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "historyId");
        return InteropKt.toV2(this.a.getPaymentHistory(str, str2));
    }
}
