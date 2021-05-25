package a2.a.a.b3.c.a;

import com.avito.android.str_calendar.seller.calendar.SellerCalendarViewModelImpl;
import com.avito.android.util.Logs;
import io.reactivex.functions.Consumer;
public final class t<T> implements Consumer<Throwable> {
    public final /* synthetic */ SellerCalendarViewModelImpl a;

    public t(SellerCalendarViewModelImpl sellerCalendarViewModelImpl) {
        this.a = sellerCalendarViewModelImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Throwable th) {
        Logs.error(th);
        this.a.getErrorChanges().setValue(new s(this));
    }
}
