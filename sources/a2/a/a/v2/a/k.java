package a2.a.a.v2.a;

import com.avito.android.short_term_rent.confirm_booking.StrConfirmBookingViewModelImpl;
public final class k implements Runnable {
    public final /* synthetic */ StrConfirmBookingViewModelImpl.b a;

    public k(StrConfirmBookingViewModelImpl.b bVar) {
        this.a = bVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.a.getBookingCalculationReview();
    }
}
