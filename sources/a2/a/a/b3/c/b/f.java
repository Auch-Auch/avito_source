package a2.a.a.b3.c.b;

import androidx.lifecycle.Observer;
import com.avito.android.str_calendar.seller.edit.SellerCalendarParametersViewImpl;
public final class f<T> implements Observer<Boolean> {
    public final /* synthetic */ SellerCalendarParametersViewImpl a;

    public f(SellerCalendarParametersViewImpl sellerCalendarParametersViewImpl) {
        this.a = sellerCalendarParametersViewImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(Boolean bool) {
        Boolean bool2 = bool;
        if (bool2 != null) {
            this.a.d.setEnabled(bool2.booleanValue());
        }
    }
}
