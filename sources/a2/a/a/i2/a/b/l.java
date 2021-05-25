package a2.a.a.i2.a.b;

import com.avito.android.safedeal.delivery_courier.summary.DeliveryCourierSummaryViewModelImpl;
import com.avito.android.util.LoadingState;
import io.reactivex.functions.Consumer;
import java.util.Map;
public final class l<T> implements Consumer<LoadingState<? super Map<String, ? extends String>>> {
    public final /* synthetic */ DeliveryCourierSummaryViewModelImpl a;

    public l(DeliveryCourierSummaryViewModelImpl deliveryCourierSummaryViewModelImpl) {
        this.a = deliveryCourierSummaryViewModelImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(LoadingState<? super Map<String, ? extends String>> loadingState) {
        LoadingState<? super Map<String, ? extends String>> loadingState2 = loadingState;
        if (loadingState2 instanceof LoadingState.Loading) {
            DeliveryCourierSummaryViewModelImpl.access$showFullScreenProgress(this.a);
        } else if (loadingState2 instanceof LoadingState.Loaded) {
            this.a.d((Map) ((LoadingState.Loaded) loadingState2).getData());
        } else if (loadingState2 instanceof LoadingState.Error) {
            DeliveryCourierSummaryViewModelImpl.access$showError(this.a, ((LoadingState.Error) loadingState2).getError());
        }
    }
}
