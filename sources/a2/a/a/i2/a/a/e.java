package a2.a.a.i2.a.a;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import com.avito.android.safedeal.delivery_courier.order_update.DeliveryCourierOrderUpdateFragment;
import kotlin.jvm.internal.Intrinsics;
public final class e<T> implements Observer<Integer> {
    public final /* synthetic */ DeliveryCourierOrderUpdateFragment a;

    public e(DeliveryCourierOrderUpdateFragment deliveryCourierOrderUpdateFragment) {
        this.a = deliveryCourierOrderUpdateFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(Integer num) {
        Integer num2 = num;
        FragmentActivity activity = this.a.getActivity();
        if (activity != null) {
            DeliveryCourierOrderUpdateFragment deliveryCourierOrderUpdateFragment = this.a;
            Intrinsics.checkNotNullExpressionValue(num2, "resultCode");
            DeliveryCourierOrderUpdateFragment.access$finishWithResult(deliveryCourierOrderUpdateFragment, activity, num2.intValue());
        }
    }
}
