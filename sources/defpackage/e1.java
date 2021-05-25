package defpackage;

import com.avito.android.delivery.map.start_ordering.DeliveryRdsStartOrderingFragment;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.Unit;
/* compiled from: java-style lambda group */
/* renamed from: e1  reason: default package */
public final class e1<T> implements Consumer<Unit> {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public e1(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public final void accept(Unit unit) {
        int i = this.a;
        if (i == 0) {
            ((DeliveryRdsStartOrderingFragment) this.b).getMapViewModel().clearSelection();
            ((DeliveryRdsStartOrderingFragment) this.b).getPointInfoViewModel().hide();
        } else if (i == 1) {
            DeliveryRdsStartOrderingFragment deliveryRdsStartOrderingFragment = (DeliveryRdsStartOrderingFragment) this.b;
            DeliveryRdsStartOrderingFragment.access$openDeliveryRdsSummary(deliveryRdsStartOrderingFragment, deliveryRdsStartOrderingFragment.f, ((DeliveryRdsStartOrderingFragment) this.b).getPointInfoViewModel().selectedService(), ((DeliveryRdsStartOrderingFragment) this.b).getPointInfoViewModel().fiasGuid(), ((DeliveryRdsStartOrderingFragment) this.b).getPointInfoViewModel().markerId());
        } else if (i == 2) {
            ((DeliveryRdsStartOrderingFragment) this.b).getPointInfoViewModel().retry();
        } else {
            throw null;
        }
    }
}
