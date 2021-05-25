package a2.a.a.t1.b.n;

import com.avito.android.payment.form.status.PaymentStatusFormPresenterImpl;
import com.avito.android.payment.form.status.ScreenState;
import com.avito.android.remote.error.ErrorWithMessage;
import com.avito.android.remote.error.TypedError;
import com.avito.android.remote.model.payment.status.form.PaymentStatusFormResult;
import com.avito.android.util.LoadingState;
import io.reactivex.functions.Function;
import java.util.Objects;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
public final class d<T, R> implements Function<LoadingState<? super PaymentStatusFormResult>, ScreenState> {
    public final /* synthetic */ PaymentStatusFormPresenterImpl a;

    public d(PaymentStatusFormPresenterImpl paymentStatusFormPresenterImpl) {
        this.a = paymentStatusFormPresenterImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public ScreenState apply(LoadingState<? super PaymentStatusFormResult> loadingState) {
        LoadingState<? super PaymentStatusFormResult> loadingState2 = loadingState;
        Intrinsics.checkNotNullParameter(loadingState2, "loadingState");
        if (loadingState2 instanceof LoadingState.Loaded) {
            PaymentStatusFormResult paymentStatusFormResult = (PaymentStatusFormResult) ((LoadingState.Loaded) loadingState2).getData();
            if (paymentStatusFormResult instanceof PaymentStatusFormResult.StatusForm) {
                return PaymentStatusFormPresenterImpl.access$bindContent(this.a, (PaymentStatusFormResult.StatusForm) paymentStatusFormResult);
            }
            throw new NoWhenBranchMatchedException();
        } else if (loadingState2 instanceof LoadingState.Error) {
            TypedError error = ((LoadingState.Error) loadingState2).getError();
            Objects.requireNonNull(error, "null cannot be cast to non-null type com.avito.android.remote.error.ErrorWithMessage");
            return new ScreenState.FullScreenError(((ErrorWithMessage) error).getMessage());
        } else if (loadingState2 instanceof LoadingState.Loading) {
            return new ScreenState.FullScreenLoading();
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }
}
