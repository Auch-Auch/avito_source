package a2.a.a.v2.c;

import android.view.View;
import com.avito.android.short_term_rent.start_booking.StrStartBookingViewImpl;
public final class d implements View.OnClickListener {
    public final /* synthetic */ StrStartBookingViewImpl a;

    public d(StrStartBookingViewImpl strStartBookingViewImpl) {
        this.a = strStartBookingViewImpl;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.a.j.onCloseClicked();
    }
}
