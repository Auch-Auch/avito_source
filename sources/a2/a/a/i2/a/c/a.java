package a2.a.a.i2.a.c;

import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import com.avito.android.remote.model.delivery_courier.TimeInterval;
import com.avito.android.safedeal.delivery_courier.DeliveryCourierActivityInteractionConstants;
import com.avito.android.safedeal.delivery_courier.time_interval_select.DeliveryCourierTimeIntervalSelectFragment;
public final class a<T> implements Observer<TimeInterval> {
    public final /* synthetic */ DeliveryCourierTimeIntervalSelectFragment a;

    public a(DeliveryCourierTimeIntervalSelectFragment deliveryCourierTimeIntervalSelectFragment) {
        this.a = deliveryCourierTimeIntervalSelectFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(TimeInterval timeInterval) {
        FragmentActivity activity;
        TimeInterval timeInterval2 = timeInterval;
        if (timeInterval2 != null && (activity = this.a.getActivity()) != null) {
            Intent intent = new Intent();
            intent.putExtra(DeliveryCourierActivityInteractionConstants.EXTRA_TIME_INTERVAL_RESULT, timeInterval2);
            activity.setResult(-1, intent);
            activity.finish();
        }
    }
}
