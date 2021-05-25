package a2.a.a.b3.c.a;

import androidx.lifecycle.Observer;
import com.avito.android.str_calendar.seller.calendar.SellerCalendarFragment;
import com.avito.android.str_calendar.utils.DateRange;
import kotlin.Unit;
public final class f<T> implements Observer<Unit> {
    public final /* synthetic */ SellerCalendarFragment a;

    public f(SellerCalendarFragment sellerCalendarFragment) {
        this.a = sellerCalendarFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(Unit unit) {
        if (unit != null) {
            DateRange selectedRange = this.a.getViewModel().getSelectedRange();
            if (selectedRange != null) {
                this.a.getRouter().showEditParametersScreen(SellerCalendarFragment.access$getAdvertId$p(this.a), selectedRange.getStart(), selectedRange.getEndInclusive());
            } else {
                this.a.getRouter().showEditParametersScreen(SellerCalendarFragment.access$getAdvertId$p(this.a), this.a.getViewModel().getSelectedDay(), null);
            }
        }
    }
}
