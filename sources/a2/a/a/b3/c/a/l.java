package a2.a.a.b3.c.a;

import androidx.lifecycle.Observer;
import com.avito.android.str_calendar.seller.calendar.SellerCalendarViewImpl;
import com.avito.android.util.Views;
public final class l<T> implements Observer<Boolean> {
    public final /* synthetic */ SellerCalendarViewImpl a;

    public l(SellerCalendarViewImpl sellerCalendarViewImpl) {
        this.a = sellerCalendarViewImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(Boolean bool) {
        Boolean bool2 = bool;
        if (bool2 != null) {
            if (bool2.booleanValue()) {
                Views.show(this.a.b);
            } else {
                Views.hide(this.a.b);
            }
        }
    }
}
