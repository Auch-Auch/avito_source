package a2.a.a.k0.e;

import com.avito.android.delivery.summary.DeliveryRdsSummaryViewModelImpl;
import com.avito.android.remote.model.delivery.CreateOrderResult;
import io.reactivex.rxjava3.functions.Consumer;
public final class n<T> implements Consumer<CreateOrderResult> {
    public final /* synthetic */ DeliveryRdsSummaryViewModelImpl a;

    public n(DeliveryRdsSummaryViewModelImpl deliveryRdsSummaryViewModelImpl) {
        this.a = deliveryRdsSummaryViewModelImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(CreateOrderResult createOrderResult) {
        DeliveryRdsSummaryViewModelImpl.access$onPaymentUrlLoaded(this.a, createOrderResult.getPaymentUrl());
    }
}
