package a2.a.a.k0.e;

import com.avito.android.delivery.summary.DeliveryRdsSummaryViewModelImpl;
import com.avito.android.remote.model.delivery.DeliverySummaryRds;
import com.avito.android.remote.model.delivery.OrderIdResult;
import com.avito.android.util.LoadingState;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
public final class w<T> implements Consumer<LoadingState<? super DeliverySummaryRds>> {
    public final /* synthetic */ DeliveryRdsSummaryViewModelImpl a;
    public final /* synthetic */ OrderIdResult b;

    public w(DeliveryRdsSummaryViewModelImpl deliveryRdsSummaryViewModelImpl, OrderIdResult orderIdResult) {
        this.a = deliveryRdsSummaryViewModelImpl;
        this.b = orderIdResult;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(LoadingState<? super DeliverySummaryRds> loadingState) {
        LoadingState<? super DeliverySummaryRds> loadingState2 = loadingState;
        if (loadingState2 instanceof LoadingState.Loading) {
            this.a.j();
        } else if (loadingState2 instanceof LoadingState.Error) {
            this.a.i(((LoadingState.Error) loadingState2).getError(), new g0(new Function0<Unit>(this.a) { // from class: a2.a.a.k0.e.v
                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.jvm.functions.Function0
                public Unit invoke() {
                    ((DeliveryRdsSummaryViewModelImpl) this.receiver).f();
                    return Unit.INSTANCE;
                }
            }));
        } else if (loadingState2 instanceof LoadingState.Loaded) {
            DeliveryRdsSummaryViewModelImpl.access$onSummaryLoaded(this.a, (DeliverySummaryRds) ((LoadingState.Loaded) loadingState2).getData());
            this.a.g(this.b.getOrderId());
        }
    }
}
