package a2.a.a.i2.a.b;

import com.avito.android.safedeal.delivery_courier.summary.DeliveryCourierSummaryViewModelImpl;
import com.avito.android.util.Logs;
import io.reactivex.functions.Consumer;
public final class m<T> implements Consumer<Throwable> {
    public final /* synthetic */ DeliveryCourierSummaryViewModelImpl a;

    public m(DeliveryCourierSummaryViewModelImpl deliveryCourierSummaryViewModelImpl) {
        this.a = deliveryCourierSummaryViewModelImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Throwable th) {
        Logs.error(th);
        this.a.getSnackBarChanges().postValue(this.a.M.getErrorOccurred());
    }
}
