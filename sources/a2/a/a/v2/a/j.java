package a2.a.a.v2.a;

import android.view.View;
import com.avito.android.short_term_rent.confirm_booking.StrConfirmBookingViewImpl;
public final class j implements View.OnClickListener {
    public final /* synthetic */ StrConfirmBookingViewImpl a;

    public j(StrConfirmBookingViewImpl strConfirmBookingViewImpl) {
        this.a = strConfirmBookingViewImpl;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.a.l.onCloseClicked();
    }
}
