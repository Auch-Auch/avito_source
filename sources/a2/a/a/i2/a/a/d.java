package a2.a.a.i2.a.a;

import androidx.lifecycle.Observer;
import com.avito.android.remote.error.ErrorWithMessage;
import com.avito.android.remote.error.TypedError;
import com.avito.android.safedeal.delivery_courier.order_update.DeliveryCourierOrderUpdateFragment;
import com.avito.android.util.LoadingState;
public final class d<T> implements Observer<LoadingState<?>> {
    public final /* synthetic */ DeliveryCourierOrderUpdateFragment a;

    public d(DeliveryCourierOrderUpdateFragment deliveryCourierOrderUpdateFragment) {
        this.a = deliveryCourierOrderUpdateFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(LoadingState<?> loadingState) {
        LoadingState<?> loadingState2 = loadingState;
        if (loadingState2 instanceof LoadingState.Loading) {
            DeliveryCourierOrderUpdateFragment.access$getProgressOverlay$p(this.a).showLoading();
        } else if (loadingState2 instanceof LoadingState.Loaded) {
            DeliveryCourierOrderUpdateFragment.access$getProgressOverlay$p(this.a).showContent();
        } else if (loadingState2 instanceof LoadingState.Error) {
            TypedError error = ((LoadingState.Error) loadingState2).getError();
            DeliveryCourierOrderUpdateFragment.access$getProgressOverlay$p(this.a).showLoadingProblem(error instanceof ErrorWithMessage ? ((ErrorWithMessage) error).getMessage() : this.a.getResourceProvider().getAbstractError());
            DeliveryCourierOrderUpdateFragment.access$getProgressOverlay$p(this.a).setOnRefreshListener(new c(this));
        }
    }
}
