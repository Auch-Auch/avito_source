package a2.a.a.b3.c.a;

import androidx.lifecycle.Observer;
import com.avito.android.str_calendar.seller.calendar.SellerCalendarViewImpl;
public final class n<T> implements Observer<String> {
    public final /* synthetic */ SellerCalendarViewImpl a;

    public n(SellerCalendarViewImpl sellerCalendarViewImpl) {
        this.a = sellerCalendarViewImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(String str) {
        String str2 = str;
        if (str2 != null) {
            SellerCalendarViewImpl sellerCalendarViewImpl = this.a;
            if (str2.length() == 0) {
                str2 = this.a.l.getToolbarTitle();
            }
            SellerCalendarViewImpl.access$setTitle(sellerCalendarViewImpl, str2);
        }
    }
}
