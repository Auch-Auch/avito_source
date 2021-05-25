package a2.a.a.k0.d;

import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import com.avito.android.delivery.map.start_ordering.DeliveryRdsStartOrderingFragmentKt;
import com.avito.android.delivery.suggest.DeliveryLocationSuggestFragment;
import com.avito.android.remote.model.Coordinates;
public final class c<T> implements Observer<Coordinates> {
    public final /* synthetic */ DeliveryLocationSuggestFragment a;

    public c(DeliveryLocationSuggestFragment deliveryLocationSuggestFragment) {
        this.a = deliveryLocationSuggestFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(Coordinates coordinates) {
        FragmentActivity activity;
        Coordinates coordinates2 = coordinates;
        if (coordinates2 != null && (activity = this.a.getActivity()) != null) {
            Intent intent = new Intent();
            intent.putExtra(DeliveryRdsStartOrderingFragmentKt.EXTRA_COORDINATES, coordinates2);
            activity.setResult(-1, intent);
            activity.finish();
        }
    }
}
