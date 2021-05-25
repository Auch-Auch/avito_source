package a2.a.a.v2.a;

import com.avito.android.short_term_rent.confirm_booking.StrConfirmBookingViewModelImpl;
import io.reactivex.functions.Consumer;
public final class o<T> implements Consumer<Throwable> {
    public final /* synthetic */ StrConfirmBookingViewModelImpl a;

    public o(StrConfirmBookingViewModelImpl strConfirmBookingViewModelImpl) {
        this.a = strConfirmBookingViewModelImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Throwable th) {
        StrConfirmBookingViewModelImpl.access$showContent(this.a);
        this.a.getErrorMessageChanges().setValue(this.a.D.getErrorOccurred());
    }
}
