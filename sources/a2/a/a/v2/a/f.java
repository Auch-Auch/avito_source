package a2.a.a.v2.a;

import androidx.lifecycle.Observer;
import com.avito.android.short_term_rent.confirm_booking.StrConfirmBookingViewImpl;
import com.avito.android.util.AvitoSnackbar;
public final class f<T> implements Observer<String> {
    public final /* synthetic */ StrConfirmBookingViewImpl a;

    public f(StrConfirmBookingViewImpl strConfirmBookingViewImpl) {
        this.a = strConfirmBookingViewImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(String str) {
        String str2 = str;
        if (str2 != null) {
            AvitoSnackbar.make$default(AvitoSnackbar.INSTANCE, this.a.i, str2, -1, null, 0, null, null, 0, 0, 0, 1016, null).show();
        }
    }
}
