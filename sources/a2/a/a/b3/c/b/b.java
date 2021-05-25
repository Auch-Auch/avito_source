package a2.a.a.b3.c.b;

import androidx.lifecycle.Observer;
import com.avito.android.str_calendar.seller.edit.SellerCalendarParametersFragment;
public final class b<T> implements Observer<Boolean> {
    public final /* synthetic */ SellerCalendarParametersFragment a;

    public b(SellerCalendarParametersFragment sellerCalendarParametersFragment) {
        this.a = sellerCalendarParametersFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(Boolean bool) {
        Boolean bool2 = bool;
        if (bool2 != null) {
            this.a.getRouter().leaveEditParametersScreen(bool2.booleanValue());
        }
    }
}
