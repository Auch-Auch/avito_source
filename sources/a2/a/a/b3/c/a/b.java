package a2.a.a.b3.c.a;

import com.avito.android.str_calendar.seller.calendar.SellerCalendarFragment;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
public final class b<T> implements Consumer<Boolean> {
    public final /* synthetic */ SellerCalendarFragment a;

    public b(SellerCalendarFragment sellerCalendarFragment) {
        this.a = sellerCalendarFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Boolean bool) {
        this.a.getViewModel().getRefreshCalendarConsumer().accept(Unit.INSTANCE);
    }
}
