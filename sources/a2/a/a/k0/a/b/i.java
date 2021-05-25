package a2.a.a.k0.a.b;

import com.avito.android.delivery.map.start_ordering.DeliveryRdsStartOrderingFragment;
import com.avito.android.util.Logs;
import io.reactivex.rxjava3.functions.Consumer;
public final class i<T> implements Consumer<Throwable> {
    public final /* synthetic */ DeliveryRdsStartOrderingFragment a;

    public i(DeliveryRdsStartOrderingFragment deliveryRdsStartOrderingFragment) {
        this.a = deliveryRdsStartOrderingFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Throwable th) {
        Throwable th2 = th;
        this.a.getLocationAnalyticsInteractor().trackResolveCoordinates(null, th2.getMessage());
        Logs.error(th2);
    }
}
