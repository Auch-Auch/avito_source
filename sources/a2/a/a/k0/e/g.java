package a2.a.a.k0.e;

import com.avito.android.delivery.summary.DeliveryRdsSummaryViewImpl;
import com.avito.android.lib.expected.stepper.Stepper;
import com.avito.android.remote.model.delivery.DeliverySummaryRds;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
public final class g extends Lambda implements Function0<Unit> {
    public final /* synthetic */ Stepper a;
    public final /* synthetic */ DeliveryRdsSummaryViewImpl.d b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g(Stepper stepper, int i, DeliveryRdsSummaryViewImpl.d dVar, DeliverySummaryRds.Header header) {
        super(0);
        this.a = stepper;
        this.b = dVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        DeliveryRdsSummaryViewImpl.access$showValuePicker(this.b.a, this.a.getValue(), this.a.getMinValue(), this.a.getMaxValue(), new f(this));
        return Unit.INSTANCE;
    }
}
