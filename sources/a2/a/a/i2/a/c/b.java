package a2.a.a.i2.a.c;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import com.avito.android.safedeal.delivery_courier.time_interval_select.DeliveryCourierTimeIntervalSelectFragment;
import kotlin.Unit;
public final class b<T> implements Observer<Unit> {
    public final /* synthetic */ DeliveryCourierTimeIntervalSelectFragment a;

    public b(DeliveryCourierTimeIntervalSelectFragment deliveryCourierTimeIntervalSelectFragment) {
        this.a = deliveryCourierTimeIntervalSelectFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(Unit unit) {
        FragmentActivity activity;
        if (unit != null && (activity = this.a.getActivity()) != null) {
            activity.setResult(10);
            activity.finish();
        }
    }
}
