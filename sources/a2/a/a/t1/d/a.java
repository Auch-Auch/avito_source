package a2.a.a.t1.d;

import com.avito.android.payment.processing.PaymentGenericPresenterImpl;
import com.avito.android.payment.processing.PaymentProcessingRouter;
import com.avito.android.remote.error.ErrorWithMessage;
import com.avito.android.remote.error.TypedError;
import com.avito.android.remote.model.payment.status.PaymentStatusResult;
import com.avito.android.util.LoadingState;
import io.reactivex.functions.Consumer;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;
public final class a<T> implements Consumer<LoadingState<? super PaymentStatusResult>> {
    public final /* synthetic */ PaymentGenericPresenterImpl a;
    public final /* synthetic */ int b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;

    public a(PaymentGenericPresenterImpl paymentGenericPresenterImpl, int i, String str, String str2) {
        this.a = paymentGenericPresenterImpl;
        this.b = i;
        this.c = str;
        this.d = str2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(LoadingState<? super PaymentStatusResult> loadingState) {
        PaymentProcessingRouter paymentProcessingRouter;
        int i;
        LoadingState<? super PaymentStatusResult> loadingState2 = loadingState;
        if (loadingState2 instanceof LoadingState.Loaded) {
            PaymentStatusResult paymentStatusResult = (PaymentStatusResult) ((LoadingState.Loaded) loadingState2).getData();
            if (paymentStatusResult instanceof PaymentStatusResult.PaymentStatus) {
                if (!Intrinsics.areEqual(((PaymentStatusResult.PaymentStatus) paymentStatusResult).getState(), "active") || (i = this.b) >= 3) {
                    PaymentProcessingRouter paymentProcessingRouter2 = this.a.b;
                    if (paymentProcessingRouter2 != null) {
                        paymentProcessingRouter2.onPaymentResult(this.d);
                        return;
                    }
                    return;
                }
                PaymentGenericPresenterImpl.access$getPaymentStatusPolling(this.a, i + 1, this.c, this.d);
            } else if ((paymentStatusResult instanceof PaymentStatusResult.ForbiddenPayment) && (paymentProcessingRouter = this.a.b) != null) {
                paymentProcessingRouter.onPaymentResult(this.d);
            }
        } else if (loadingState2 instanceof LoadingState.Error) {
            LoadingState.Error error = (LoadingState.Error) loadingState2;
            if (error.getError() instanceof ErrorWithMessage) {
                PaymentGenericPresenterImpl paymentGenericPresenterImpl = this.a;
                TypedError error2 = error.getError();
                Objects.requireNonNull(error2, "null cannot be cast to non-null type com.avito.android.remote.error.ErrorWithMessage");
                PaymentGenericPresenterImpl.access$handleError(paymentGenericPresenterImpl, ((ErrorWithMessage) error2).getMessage());
            }
        }
    }
}
