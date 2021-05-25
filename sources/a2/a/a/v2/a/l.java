package a2.a.a.v2.a;

import com.avito.android.short_term_rent.confirm_booking.StrConfirmBookingViewModelImpl;
public final class l implements Runnable {
    public final /* synthetic */ StrConfirmBookingViewModelImpl.c a;

    public l(StrConfirmBookingViewModelImpl.c cVar) {
        this.a = cVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.a.getBookingCalculationReview();
    }
}
