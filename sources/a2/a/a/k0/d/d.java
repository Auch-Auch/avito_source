package a2.a.a.k0.d;

import android.view.View;
import com.avito.android.delivery.suggest.DeliveryLocationSuggestViewImpl;
public final class d implements View.OnClickListener {
    public final /* synthetic */ DeliveryLocationSuggestViewImpl a;

    public d(DeliveryLocationSuggestViewImpl deliveryLocationSuggestViewImpl) {
        this.a = deliveryLocationSuggestViewImpl;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.a.b.removeCallbacks(this.a.f);
        this.a.b.setText("");
    }
}
