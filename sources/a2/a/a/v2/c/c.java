package a2.a.a.v2.c;

import androidx.lifecycle.Observer;
import com.avito.android.short_term_rent.start_booking.StrStartBookingViewImpl;
import com.avito.android.util.AvitoSnackbar;
public final class c<T> implements Observer<String> {
    public final /* synthetic */ StrStartBookingViewImpl a;

    public c(StrStartBookingViewImpl strStartBookingViewImpl) {
        this.a = strStartBookingViewImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(String str) {
        String str2 = str;
        if (str2 != null) {
            AvitoSnackbar.make$default(AvitoSnackbar.INSTANCE, this.a.g, str2, -1, null, 0, null, null, 0, 0, 0, 1016, null).show();
        }
    }
}
