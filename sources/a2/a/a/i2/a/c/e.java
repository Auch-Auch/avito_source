package a2.a.a.i2.a.c;

import com.avito.android.remote.model.delivery_courier.DeliveryCourierTimeIntervals;
import com.avito.android.safedeal.delivery_courier.time_interval_select.DeliveryCourierTimeIntervalSelectViewModelImpl;
import com.avito.android.util.LoadingState;
import io.reactivex.functions.Consumer;
public final class e<T> implements Consumer<LoadingState<? super DeliveryCourierTimeIntervals>> {
    public final /* synthetic */ DeliveryCourierTimeIntervalSelectViewModelImpl a;

    public e(DeliveryCourierTimeIntervalSelectViewModelImpl deliveryCourierTimeIntervalSelectViewModelImpl) {
        this.a = deliveryCourierTimeIntervalSelectViewModelImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(LoadingState<? super DeliveryCourierTimeIntervals> loadingState) {
        LoadingState<? super DeliveryCourierTimeIntervals> loadingState2 = loadingState;
        if (loadingState2 instanceof LoadingState.Loading) {
            DeliveryCourierTimeIntervalSelectViewModelImpl.access$onTimeIntervalsLoading(this.a);
        } else if (loadingState2 instanceof LoadingState.Error) {
            DeliveryCourierTimeIntervalSelectViewModelImpl.access$onTimeIntervalsError(this.a, ((LoadingState.Error) loadingState2).getError());
        } else if (loadingState2 instanceof LoadingState.Loaded) {
            DeliveryCourierTimeIntervalSelectViewModelImpl.access$onTimeIntervalsLoaded(this.a, (DeliveryCourierTimeIntervals) ((LoadingState.Loaded) loadingState2).getData());
        }
    }
}
