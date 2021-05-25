package a2.a.a.b3.c.a;

import androidx.fragment.app.FragmentActivity;
import com.avito.android.str_calendar.seller.calendar.SellerCalendarFragment;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
public final class d<T> implements Consumer<Unit> {
    public final /* synthetic */ SellerCalendarFragment a;

    public d(SellerCalendarFragment sellerCalendarFragment) {
        this.a = sellerCalendarFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Unit unit) {
        FragmentActivity activity = this.a.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }
}
