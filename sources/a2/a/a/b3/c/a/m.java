package a2.a.a.b3.c.a;

import androidx.lifecycle.Observer;
import com.avito.android.str_calendar.seller.calendar.SellerCalendarViewImpl;
import kotlin.Unit;
public final class m<T> implements Observer<Unit> {
    public final /* synthetic */ SellerCalendarViewImpl a;

    public m(SellerCalendarViewImpl sellerCalendarViewImpl) {
        this.a = sellerCalendarViewImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(Unit unit) {
        if (unit != null) {
            this.a.a.showContent();
        }
    }
}
