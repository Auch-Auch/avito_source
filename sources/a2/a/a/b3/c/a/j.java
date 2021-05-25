package a2.a.a.b3.c.a;

import androidx.lifecycle.Observer;
import com.avito.android.str_calendar.seller.calendar.SellerCalendarViewImpl;
import com.avito.android.util.AvitoSnackbar;
public final class j<T> implements Observer<String> {
    public final /* synthetic */ SellerCalendarViewImpl a;

    public j(SellerCalendarViewImpl sellerCalendarViewImpl) {
        this.a = sellerCalendarViewImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(String str) {
        String str2 = str;
        if (str2 != null) {
            AvitoSnackbar.make$default(AvitoSnackbar.INSTANCE, this.a.j, str2, -1, null, 0, null, null, 0, 0, 0, 1016, null).show();
        }
    }
}
