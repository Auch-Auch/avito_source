package a2.a.a.k0.e;

import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.delivery.summary.DeliveryRdsSummaryViewModelImpl;
import com.avito.android.util.Logs;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class d0 extends Lambda implements Function1<Throwable, Unit> {
    public final /* synthetic */ DeliveryRdsSummaryViewModelImpl a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d0(DeliveryRdsSummaryViewModelImpl deliveryRdsSummaryViewModelImpl) {
        super(1);
        this.a = deliveryRdsSummaryViewModelImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Throwable th) {
        Throwable th2 = th;
        Intrinsics.checkNotNullParameter(th2, "it");
        Logs.error(ScreenPublicConstsKt.DELIVERY_RDS_SUMMARY_NAME, th2);
        this.a.l();
        this.a.r();
        return Unit.INSTANCE;
    }
}
