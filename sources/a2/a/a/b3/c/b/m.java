package a2.a.a.b3.c.b;

import androidx.lifecycle.Observer;
import com.avito.android.str_calendar.seller.edit.SellerCalendarParametersViewImpl;
import kotlin.Unit;
public final class m<T> implements Observer<Unit> {
    public final /* synthetic */ SellerCalendarParametersViewImpl a;

    public m(SellerCalendarParametersViewImpl sellerCalendarParametersViewImpl) {
        this.a = sellerCalendarParametersViewImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(Unit unit) {
        if (unit != null) {
            this.a.a.showContent();
        }
    }
}
