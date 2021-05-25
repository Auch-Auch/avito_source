package com.avito.android.payment.wallet.history.details;

import com.avito.android.payment.remote.PaymentApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.model.payment.history.PaymentDetails;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00050\u00042\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\bR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/payment/wallet/history/details/PaymentHistoryDetailsInteractor;", "", "", AnalyticFieldsName.orderId, "Lio/reactivex/Observable;", "Lcom/avito/android/remote/model/TypedResult;", "Lcom/avito/android/remote/model/payment/history/PaymentDetails$OrderDetails;", "getOrderDetails", "(Ljava/lang/String;)Lio/reactivex/Observable;", "operationId", "Lcom/avito/android/remote/model/payment/history/PaymentDetails$OperationDetails;", "getOperationDetails", "Lcom/avito/android/payment/remote/PaymentApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/payment/remote/PaymentApi;", "paymentApi", "<init>", "(Lcom/avito/android/payment/remote/PaymentApi;)V", "payment_release"}, k = 1, mv = {1, 4, 2})
public final class PaymentHistoryDetailsInteractor {
    public final PaymentApi a;

    public PaymentHistoryDetailsInteractor(@NotNull PaymentApi paymentApi) {
        Intrinsics.checkNotNullParameter(paymentApi, "paymentApi");
        this.a = paymentApi;
    }

    @NotNull
    public final Observable<TypedResult<PaymentDetails.OperationDetails>> getOperationDetails(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "operationId");
        return InteropKt.toV2(this.a.getOperationDetails(str));
    }

    @NotNull
    public final Observable<TypedResult<PaymentDetails.OrderDetails>> getOrderDetails(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, AnalyticFieldsName.orderId);
        return InteropKt.toV2(this.a.getOrderDetails(str));
    }
}
