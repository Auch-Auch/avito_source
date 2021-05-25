package a2.a.a.b3.c.b;

import com.avito.android.str_calendar.seller.edit.SellerCalendarParametersFragment;
import com.avito.android.util.Keyboards;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
public final class a<T> implements Consumer<Unit> {
    public final /* synthetic */ SellerCalendarParametersFragment a;

    public a(SellerCalendarParametersFragment sellerCalendarParametersFragment) {
        this.a = sellerCalendarParametersFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Unit unit) {
        Keyboards.hideKeyboard(this.a);
        this.a.getRouter().leaveEditParametersScreen(false);
    }
}
