package a2.a.a.k0.b.b;

import com.avito.android.delivery.order_cancellation.details.ReasonDetailsViewModelImpl;
import com.avito.android.util.LoadingState;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
public final class b<T> implements Consumer<LoadingState<? super Unit>> {
    public final /* synthetic */ ReasonDetailsViewModelImpl a;

    public b(ReasonDetailsViewModelImpl reasonDetailsViewModelImpl) {
        this.a = reasonDetailsViewModelImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(LoadingState<? super Unit> loadingState) {
        LoadingState<? super Unit> loadingState2 = loadingState;
        if (loadingState2 instanceof LoadingState.Loaded) {
            this.a.getButtonStateChanges().setValue(Boolean.FALSE);
            this.a.getCloseScreenChanges().setValue(-1);
        } else if (loadingState2 instanceof LoadingState.Error) {
            this.a.getButtonStateChanges().setValue(Boolean.FALSE);
            this.a.getSnackbarChanges().postValue(this.a.v.getErrorOccurred());
        } else if (loadingState2 instanceof LoadingState.Loading) {
            this.a.getButtonStateChanges().setValue(Boolean.TRUE);
        }
    }
}
