package a2.a.a.k0.e;

import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.delivery.summary.DeliveryRdsSummaryViewModelImpl;
import com.avito.android.remote.error.ErrorResult;
import com.avito.android.remote.error.TypedError;
import com.avito.android.util.Logs;
import com.avito.android.util.TypedResultException;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class o<T> implements Consumer<Throwable> {
    public final /* synthetic */ DeliveryRdsSummaryViewModelImpl a;

    public o(DeliveryRdsSummaryViewModelImpl deliveryRdsSummaryViewModelImpl) {
        this.a = deliveryRdsSummaryViewModelImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Throwable th) {
        Throwable th2 = th;
        ErrorResult.IncorrectData incorrectData = null;
        TypedResultException typedResultException = (TypedResultException) (!(th2 instanceof TypedResultException) ? null : th2);
        TypedError errorResult = typedResultException != null ? typedResultException.getErrorResult() : null;
        if (errorResult instanceof ErrorResult.IncorrectData) {
            incorrectData = errorResult;
        }
        ErrorResult.IncorrectData incorrectData2 = incorrectData;
        if (incorrectData2 != null) {
            DeliveryRdsSummaryViewModelImpl deliveryRdsSummaryViewModelImpl = this.a;
            DeliveryRdsSummaryViewModelImpl.access$updateView(deliveryRdsSummaryViewModelImpl, deliveryRdsSummaryViewModelImpl.X.applyErrors(incorrectData2.getMessages(), this.a.M));
            return;
        }
        Logs.error(ScreenPublicConstsKt.DELIVERY_RDS_SUMMARY_NAME, th2);
        DeliveryRdsSummaryViewModelImpl deliveryRdsSummaryViewModelImpl2 = this.a;
        Intrinsics.checkNotNullExpressionValue(th2, "it");
        DeliveryRdsSummaryViewModelImpl.access$showError(deliveryRdsSummaryViewModelImpl2, th2);
    }
}
