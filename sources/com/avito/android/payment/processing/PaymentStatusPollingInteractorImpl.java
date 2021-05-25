package com.avito.android.payment.processing;

import com.avito.android.payment.remote.PaymentApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.model.payment.status.PaymentStatusResult;
import com.avito.android.util.LoadingState;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\u000f\u0010\u0010J#\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u000e\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/payment/processing/PaymentStatusPollingInteractorImpl;", "Lcom/avito/android/payment/processing/PaymentStatusPollingInteractor;", "", AnalyticFieldsName.orderId, "Lio/reactivex/Observable;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/remote/model/payment/status/PaymentStatusResult;", "getPaymentStatus", "(Ljava/lang/String;)Lio/reactivex/Observable;", "Lcom/avito/android/payment/remote/PaymentApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/payment/remote/PaymentApi;", "getApi", "()Lcom/avito/android/payment/remote/PaymentApi;", "api", "<init>", "(Lcom/avito/android/payment/remote/PaymentApi;)V", "payment-core_release"}, k = 1, mv = {1, 4, 2})
public final class PaymentStatusPollingInteractorImpl implements PaymentStatusPollingInteractor {
    @NotNull
    public final PaymentApi a;

    public static final class a<T, R> implements Function<TypedResult<PaymentStatusResult>, LoadingState<? super PaymentStatusResult>> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public LoadingState<? super PaymentStatusResult> apply(TypedResult<PaymentStatusResult> typedResult) {
            TypedResult<PaymentStatusResult> typedResult2 = typedResult;
            Intrinsics.checkNotNullParameter(typedResult2, "it");
            if (typedResult2 instanceof TypedResult.OfResult) {
                return new LoadingState.Loaded(((TypedResult.OfResult) typedResult2).getResult());
            }
            if (typedResult2 instanceof TypedResult.OfError) {
                return new LoadingState.Error(((TypedResult.OfError) typedResult2).getError());
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    public PaymentStatusPollingInteractorImpl(@NotNull PaymentApi paymentApi) {
        Intrinsics.checkNotNullParameter(paymentApi, "api");
        this.a = paymentApi;
    }

    @NotNull
    public final PaymentApi getApi() {
        return this.a;
    }

    @Override // com.avito.android.payment.processing.PaymentStatusPollingInteractor
    @NotNull
    public Observable<LoadingState<PaymentStatusResult>> getPaymentStatus(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, AnalyticFieldsName.orderId);
        Observable<LoadingState<PaymentStatusResult>> startWith = InteropKt.toV2(this.a.getPaymentStatus(str)).map(a.a).startWith((Observable) LoadingState.Loading.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(startWith, "api.getPaymentStatus(ord…ith(LoadingState.Loading)");
        return startWith;
    }
}
