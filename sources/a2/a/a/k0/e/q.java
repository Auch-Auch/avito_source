package a2.a.a.k0.e;

import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.delivery.summary.DeliveryRdsSummaryViewModelImpl;
import com.avito.android.util.Logs;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class q<T> implements Consumer<Throwable> {
    public final /* synthetic */ DeliveryRdsSummaryViewModelImpl a;

    public q(DeliveryRdsSummaryViewModelImpl deliveryRdsSummaryViewModelImpl) {
        this.a = deliveryRdsSummaryViewModelImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Throwable th) {
        Throwable th2 = th;
        Logs.error(ScreenPublicConstsKt.DELIVERY_RDS_SUMMARY_NAME, th2);
        DeliveryRdsSummaryViewModelImpl deliveryRdsSummaryViewModelImpl = this.a;
        Intrinsics.checkNotNullExpressionValue(th2, "it");
        DeliveryRdsSummaryViewModelImpl.access$showError(deliveryRdsSummaryViewModelImpl, th2);
    }
}
