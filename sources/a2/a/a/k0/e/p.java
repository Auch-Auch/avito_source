package a2.a.a.k0.e;

import com.avito.android.delivery.summary.DeliveryRdsSummaryViewModelImpl;
import com.avito.android.remote.model.delivery.OrderIdResult;
import com.avito.android.util.LoadingState;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class p<T> implements Consumer<LoadingState<? super OrderIdResult>> {
    public final /* synthetic */ DeliveryRdsSummaryViewModelImpl a;

    public p(DeliveryRdsSummaryViewModelImpl deliveryRdsSummaryViewModelImpl) {
        this.a = deliveryRdsSummaryViewModelImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(LoadingState<? super OrderIdResult> loadingState) {
        LoadingState<? super OrderIdResult> loadingState2 = loadingState;
        if (Intrinsics.areEqual(loadingState2, LoadingState.Loading.INSTANCE)) {
            DeliveryRdsSummaryViewModelImpl.access$showProgress(this.a);
        } else if (loadingState2 instanceof LoadingState.Loaded) {
            DeliveryRdsSummaryViewModelImpl.access$onOrderCreated(this.a, (OrderIdResult) ((LoadingState.Loaded) loadingState2).getData());
        } else if (loadingState2 instanceof LoadingState.Error) {
            this.a.h(((LoadingState.Error) loadingState2).getError());
        }
    }
}
