package a2.a.a.k0.e;

import com.avito.android.delivery.summary.DeliveryRdsSummaryViewModelImpl;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;
public final /* synthetic */ class y extends FunctionReferenceImpl implements Function0<Unit> {
    public y(DeliveryRdsSummaryViewModelImpl deliveryRdsSummaryViewModelImpl) {
        super(0, deliveryRdsSummaryViewModelImpl, DeliveryRdsSummaryViewModelImpl.class, "loadSummary", "loadSummary()V", 0);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        ((DeliveryRdsSummaryViewModelImpl) this.receiver).f();
        return Unit.INSTANCE;
    }
}
