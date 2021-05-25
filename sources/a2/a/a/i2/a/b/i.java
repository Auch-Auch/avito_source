package a2.a.a.i2.a.b;

import com.avito.android.remote.model.delivery_courier.DeliveryCourierSummary;
import com.avito.android.safedeal.delivery_courier.summary.DeliveryCourierSummaryViewModelImpl;
import com.avito.android.util.LoadingState;
import io.reactivex.functions.Consumer;
public final class i<T> implements Consumer<LoadingState<? super DeliveryCourierSummary>> {
    public final /* synthetic */ DeliveryCourierSummaryViewModelImpl a;

    public i(DeliveryCourierSummaryViewModelImpl deliveryCourierSummaryViewModelImpl) {
        this.a = deliveryCourierSummaryViewModelImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(LoadingState<? super DeliveryCourierSummary> loadingState) {
        LoadingState<? super DeliveryCourierSummary> loadingState2 = loadingState;
        if (loadingState2 instanceof LoadingState.Loading) {
            DeliveryCourierSummaryViewModelImpl.access$showFullScreenProgress(this.a);
        } else if (loadingState2 instanceof LoadingState.Error) {
            this.a.e(new h(this), ((LoadingState.Error) loadingState2).getError());
        } else if (loadingState2 instanceof LoadingState.Loaded) {
            DeliveryCourierSummaryViewModelImpl.access$onSummaryLoaded(this.a, (DeliveryCourierSummary) ((LoadingState.Loaded) loadingState2).getData());
        }
    }
}
