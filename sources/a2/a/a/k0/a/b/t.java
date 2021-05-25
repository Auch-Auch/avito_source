package a2.a.a.k0.a.b;

import com.avito.android.delivery.map.start_ordering.DeliveryRdsStartOrderingViewModelImpl;
import com.avito.android.util.Logs;
import io.reactivex.rxjava3.functions.Consumer;
public final class t<T> implements Consumer<Throwable> {
    public final /* synthetic */ DeliveryRdsStartOrderingViewModelImpl a;

    public t(DeliveryRdsStartOrderingViewModelImpl deliveryRdsStartOrderingViewModelImpl) {
        this.a = deliveryRdsStartOrderingViewModelImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Throwable th) {
        Logs.error(th);
        this.a.getSnackBarEvents().postValue(this.a.x.getUnknownError());
    }
}
