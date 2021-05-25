package a2.a.a.t1.b;

import com.avito.android.payment.form.PaymentGenericFormPresenterImpl;
import com.avito.android.payment.form.ScreenState;
import com.avito.android.remote.error.ErrorWithMessage;
import com.avito.android.remote.error.TypedError;
import com.avito.android.remote.model.payment.form.PaymentGenericFormResult;
import com.avito.android.util.LoadingState;
import io.reactivex.functions.Function;
import java.util.Objects;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
public final class l<T, R> implements Function<LoadingState<? super PaymentGenericFormResult>, ScreenState> {
    public final /* synthetic */ PaymentGenericFormPresenterImpl a;

    public l(PaymentGenericFormPresenterImpl paymentGenericFormPresenterImpl) {
        this.a = paymentGenericFormPresenterImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public ScreenState apply(LoadingState<? super PaymentGenericFormResult> loadingState) {
        LoadingState<? super PaymentGenericFormResult> loadingState2 = loadingState;
        Intrinsics.checkNotNullParameter(loadingState2, "loadingState");
        if (loadingState2 instanceof LoadingState.Loaded) {
            PaymentGenericFormResult paymentGenericFormResult = (PaymentGenericFormResult) ((LoadingState.Loaded) loadingState2).getData();
            if (paymentGenericFormResult instanceof PaymentGenericFormResult.Ok) {
                return PaymentGenericFormPresenterImpl.access$bakeInitialContent(this.a, (PaymentGenericFormResult.Ok) paymentGenericFormResult);
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
