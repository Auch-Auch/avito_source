package a2.a.a.k0.e;

import com.avito.android.SummaryState;
import com.avito.android.delivery.summary.DeliveryRdsSummaryInteractor;
import com.avito.android.delivery.summary.DeliveryRdsSummaryViewModelImpl;
import com.avito.android.delivery.summary.DeliveryRdsSummaryViewModelImpl$flatMapCreateOrder$1$$special$$inlined$toTyped$1;
import com.avito.android.remote.model.delivery.CreateOrderResult;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class t<T, R> implements Function<Object, SingleSource<? extends CreateOrderResult>> {
    public final /* synthetic */ DeliveryRdsSummaryViewModelImpl a;

    public t(DeliveryRdsSummaryViewModelImpl deliveryRdsSummaryViewModelImpl) {
        this.a = deliveryRdsSummaryViewModelImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // io.reactivex.rxjava3.functions.Function
    public SingleSource<? extends CreateOrderResult> apply(Object obj) {
        DeliveryRdsSummaryInteractor deliveryRdsSummaryInteractor = this.a.T;
        SummaryState summaryState = this.a.Q;
        String advertId = summaryState != null ? summaryState.getAdvertId() : null;
        SummaryState summaryState2 = this.a.Q;
        String fiasGuid = summaryState2 != null ? summaryState2.getFiasGuid() : null;
        SummaryState summaryState3 = this.a.Q;
        String serviceId = summaryState3 != null ? summaryState3.getServiceId() : null;
        Integer valueOf = Integer.valueOf(this.a.l);
        valueOf.intValue();
        if (!this.a.getHeaderStepperVisible()) {
            valueOf = null;
        }
        Single<R> flatMap = deliveryRdsSummaryInteractor.createDeliveryOrder(advertId, fiasGuid, serviceId, valueOf, this.a.X.getFieldsMap()).flatMap(DeliveryRdsSummaryViewModelImpl$flatMapCreateOrder$1$$special$$inlined$toTyped$1.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(flatMap, "flatMap { it.toTypedSingle() }");
        return flatMap;
    }
}
