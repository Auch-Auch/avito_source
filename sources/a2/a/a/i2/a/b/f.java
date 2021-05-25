package a2.a.a.i2.a.b;

import com.avito.android.remote.model.delivery_courier.DeliveryCourierOrderPayment;
import com.avito.android.safedeal.delivery_courier.analytics.CreateDeliveryCourierOrderEvent;
import com.avito.android.safedeal.delivery_courier.summary.DeliveryCourierSummaryViewModelImpl;
import com.avito.android.util.LoadingState;
import io.reactivex.functions.Consumer;
public final class f<T> implements Consumer<LoadingState<? super DeliveryCourierOrderPayment>> {
    public final /* synthetic */ DeliveryCourierSummaryViewModelImpl a;

    public f(DeliveryCourierSummaryViewModelImpl deliveryCourierSummaryViewModelImpl) {
        this.a = deliveryCourierSummaryViewModelImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(LoadingState<? super DeliveryCourierOrderPayment> loadingState) {
        LoadingState<? super DeliveryCourierOrderPayment> loadingState2 = loadingState;
        if (loadingState2 instanceof LoadingState.Loaded) {
            DeliveryCourierOrderPayment deliveryCourierOrderPayment = (DeliveryCourierOrderPayment) ((LoadingState.Loaded) loadingState2).getData();
            this.a.G.track(new CreateDeliveryCourierOrderEvent(deliveryCourierOrderPayment.getUserId(), deliveryCourierOrderPayment.getAdvertId(), deliveryCourierOrderPayment.getOrderId(), this.a.K));
            this.a.A = deliveryCourierOrderPayment.getPaymentUrl();
            this.a.getPayUrlChanges().setValue(deliveryCourierOrderPayment.getPaymentUrl());
        } else if (loadingState2 instanceof LoadingState.Loading) {
            DeliveryCourierSummaryViewModelImpl.access$showFullScreenProgress(this.a);
        } else if (loadingState2 instanceof LoadingState.Error) {
            DeliveryCourierSummaryViewModelImpl.access$showError(this.a, ((LoadingState.Error) loadingState2).getError());
        }
    }
}
