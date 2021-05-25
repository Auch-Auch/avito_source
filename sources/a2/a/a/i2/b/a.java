package a2.a.a.i2.b;

import com.avito.android.safedeal.delivery_type.DeliveryTypePresenterImpl;
import com.avito.android.safedeal.delivery_type.DeliveryTypeRouter;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.Unit;
public final class a<T> implements Consumer<Unit> {
    public final /* synthetic */ DeliveryTypePresenterImpl a;

    public a(DeliveryTypePresenterImpl deliveryTypePresenterImpl) {
        this.a = deliveryTypePresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Unit unit) {
        DeliveryTypeRouter deliveryTypeRouter = this.a.b;
        if (deliveryTypeRouter != null) {
            deliveryTypeRouter.closeScreen();
        }
    }
}
