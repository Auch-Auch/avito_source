package a2.a.a.t1.e.a;

import com.avito.android.payment.top_up.form.ScreenState;
import com.avito.android.payment.top_up.form.TopUpFormPresenterImpl;
import com.avito.android.remote.error.ErrorWithMessage;
import com.avito.android.remote.error.TypedError;
import com.avito.android.remote.model.payment.top_up.TopUpForm;
import com.avito.android.util.LoadingState;
import io.reactivex.functions.Function;
import java.util.Objects;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
public final class i<T, R> implements Function<LoadingState<? super TopUpForm>, ScreenState> {
    public final /* synthetic */ TopUpFormPresenterImpl a;

    public i(TopUpFormPresenterImpl topUpFormPresenterImpl) {
        this.a = topUpFormPresenterImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public ScreenState apply(LoadingState<? super TopUpForm> loadingState) {
        LoadingState<? super TopUpForm> loadingState2 = loadingState;
        Intrinsics.checkNotNullParameter(loadingState2, "loadingState");
        if (loadingState2 instanceof LoadingState.Loaded) {
            return TopUpFormPresenterImpl.access$bakeInitialContent(this.a, (TopUpForm) ((LoadingState.Loaded) loadingState2).getData());
        }
        if (loadingState2 instanceof LoadingState.Error) {
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
