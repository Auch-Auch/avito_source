package a2.a.a.k0.e;

import com.avito.android.SummaryState;
import com.avito.android.delivery.summary.DeliveryRdsSummaryInteractor;
import com.avito.android.delivery.summary.DeliveryRdsSummaryViewModelImpl;
import com.avito.android.remote.model.delivery.OrderIdResult;
import com.avito.android.util.LoadingState;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.functions.Function;
public final class u<T, R> implements Function<Object, ObservableSource<? extends LoadingState<? super OrderIdResult>>> {
    public final /* synthetic */ DeliveryRdsSummaryViewModelImpl a;

    public u(DeliveryRdsSummaryViewModelImpl deliveryRdsSummaryViewModelImpl) {
        this.a = deliveryRdsSummaryViewModelImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // io.reactivex.rxjava3.functions.Function
    public ObservableSource<? extends LoadingState<? super OrderIdResult>> apply(Object obj) {
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
        return deliveryRdsSummaryInteractor.createDeliveryOrderLegacy(advertId, fiasGuid, serviceId, valueOf, this.a.X.getParametersMap());
    }
}
