package a2.a.a.i2.a.c;

import com.avito.android.safedeal.delivery_courier.time_interval_select.DeliveryCourierTimeIntervalSelectViewModelImpl;
import com.avito.android.util.Logs;
import io.reactivex.functions.Consumer;
public final class f<T> implements Consumer<Throwable> {
    public final /* synthetic */ DeliveryCourierTimeIntervalSelectViewModelImpl a;

    public f(DeliveryCourierTimeIntervalSelectViewModelImpl deliveryCourierTimeIntervalSelectViewModelImpl) {
        this.a = deliveryCourierTimeIntervalSelectViewModelImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Throwable th) {
        Logs.error(th);
        this.a.p.trackLoadTimeIntervalsFailed();
    }
}
