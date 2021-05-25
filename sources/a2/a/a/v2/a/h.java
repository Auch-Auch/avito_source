package a2.a.a.v2.a;

import androidx.lifecycle.Observer;
import com.avito.android.short_term_rent.confirm_booking.StrConfirmBookingViewImpl;
import kotlin.Unit;
public final class h<T> implements Observer<Unit> {
    public final /* synthetic */ StrConfirmBookingViewImpl a;

    public h(StrConfirmBookingViewImpl strConfirmBookingViewImpl) {
        this.a = strConfirmBookingViewImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(Unit unit) {
        if (unit != null) {
            this.a.e.showLoading();
        }
    }
}
