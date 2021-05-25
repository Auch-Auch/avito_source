package a2.a.a.b3.c.b;

import com.avito.android.str_calendar.seller.edit.SellerCalendarParametersViewModelImpl;
import com.avito.android.util.Logs;
import io.reactivex.functions.Consumer;
public final class u<T> implements Consumer<Throwable> {
    public final /* synthetic */ SellerCalendarParametersViewModelImpl a;

    public u(SellerCalendarParametersViewModelImpl sellerCalendarParametersViewModelImpl) {
        this.a = sellerCalendarParametersViewModelImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Throwable th) {
        Logs.error(th);
        this.a.getErrorMessageChanges().setValue(this.a.F.getErrorOccurred());
    }
}
