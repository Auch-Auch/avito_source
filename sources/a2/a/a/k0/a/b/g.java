package a2.a.a.k0.a.b;

import androidx.lifecycle.Observer;
import com.avito.android.delivery.map.start_ordering.DeliveryRdsStartOrderingFragment;
import com.avito.android.delivery.map.start_ordering.PreselectPinEvent;
public final class g<T> implements Observer<PreselectPinEvent> {
    public final /* synthetic */ DeliveryRdsStartOrderingFragment a;

    public g(DeliveryRdsStartOrderingFragment deliveryRdsStartOrderingFragment) {
        this.a = deliveryRdsStartOrderingFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(PreselectPinEvent preselectPinEvent) {
        PreselectPinEvent preselectPinEvent2 = preselectPinEvent;
        if (preselectPinEvent2 instanceof PreselectPinEvent.ClickPin) {
            PreselectPinEvent.ClickPin clickPin = (PreselectPinEvent.ClickPin) preselectPinEvent2;
            this.a.getMapViewModel().onMarkerClick(clickPin.getPin().getId(), null, clickPin.getPin().getZoomLevel());
        } else if (preselectPinEvent2 instanceof PreselectPinEvent.MoveCamera) {
            this.a.getMapViewModel().moveCamera(((PreselectPinEvent.MoveCamera) preselectPinEvent2).getLatLng());
        }
    }
}
