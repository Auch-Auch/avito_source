package com.avito.android.payment.lib;

import com.avito.android.Features;
import com.avito.android.payment.lib.PaymentSessionType;
import com.avito.android.payment.remote.PaymentApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.model.payment.service.PaymentSessionResult;
import com.avito.android.util.ParameterTreesKt;
import com.avito.android.util.RequestUtils;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.Observable;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u0014\u0010\u0015J/\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/avito/android/payment/lib/PaymentSessionInteractor;", "", "Lcom/avito/android/payment/lib/PaymentSessionType;", "paymentSessionType", "", "", "nativeMethods", "Lio/reactivex/Observable;", "Lcom/avito/android/remote/model/TypedResult;", "Lcom/avito/android/remote/model/payment/service/PaymentSessionResult;", "createPaymentSession", "(Lcom/avito/android/payment/lib/PaymentSessionType;Ljava/util/Set;)Lio/reactivex/Observable;", "Lcom/avito/android/Features;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/Features;", "features", "Lcom/avito/android/payment/remote/PaymentApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/payment/remote/PaymentApi;", "paymentApi", "<init>", "(Lcom/avito/android/payment/remote/PaymentApi;Lcom/avito/android/Features;)V", "payment-lib_release"}, k = 1, mv = {1, 4, 2})
public final class PaymentSessionInteractor {
    public final PaymentApi a;
    public final Features b;

    public PaymentSessionInteractor(@NotNull PaymentApi paymentApi, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(paymentApi, "paymentApi");
        Intrinsics.checkNotNullParameter(features, "features");
        this.a = paymentApi;
        this.b = features;
    }

    @NotNull
    public final Observable<TypedResult<PaymentSessionResult>> createPaymentSession(@NotNull PaymentSessionType paymentSessionType, @NotNull Set<String> set) {
        Intrinsics.checkNotNullParameter(paymentSessionType, "paymentSessionType");
        Intrinsics.checkNotNullParameter(set, "nativeMethods");
        RequestUtils requestUtils = RequestUtils.INSTANCE;
        Map<String, String> arrayQueryParams = requestUtils.toArrayQueryParams(set, "nativeMethods");
        if (paymentSessionType instanceof PaymentSessionType.Wallet) {
            Map<String, String> convertToMap = ParameterTreesKt.convertToMap(((PaymentSessionType.Wallet) paymentSessionType).getParams());
            if (this.b.getRebrandToYooMoney().invoke().booleanValue()) {
                return InteropKt.toV2(this.a.createWalletPaymentSessionV4(convertToMap, arrayQueryParams));
            }
            return InteropKt.toV2(this.a.createWalletPaymentSession(convertToMap, arrayQueryParams));
        } else if (paymentSessionType instanceof PaymentSessionType.LegacyServices) {
            PaymentSessionType.LegacyServices legacyServices = (PaymentSessionType.LegacyServices) paymentSessionType;
            return InteropKt.toV2(this.a.legacyCreateServicePaymentSession(legacyServices.getItemId(), requestUtils.toArrayQueryParams(legacyServices.getServiceIds(), "serviceIds"), legacyServices.getContext(), arrayQueryParams));
        } else if (paymentSessionType instanceof PaymentSessionType.Services) {
            PaymentSessionType.Services services = (PaymentSessionType.Services) paymentSessionType;
            return InteropKt.toV2(this.a.createServicePaymentSession(PaymentSessionInteractorKt.access$toArrayQueryParams(services.getOrderItems(), "orderItems"), services.getContext(), arrayQueryParams));
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }
}
