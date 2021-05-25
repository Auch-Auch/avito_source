package a7.c.a.a.o.f.a.b.c;

import io.reactivex.functions.Consumer;
import ru.sravni.android.bankproduct.analytic.v2.BaseAnalyticKt;
import ru.sravni.android.bankproduct.domain.analytic.entity.MessagePriority;
import ru.sravni.android.bankproduct.presentation.offer.osago.order.viewmodel.OfferOsagoOrderViewModel;
import ru.sravni.android.bankproduct.presentation.offer.osago.order.viewmodel.OsagoOrderButtonState;
import ru.sravni.android.bankproduct.presentation.offer.osago.order.viewmodel.OsagoOrderState;
public final class c<T> implements Consumer<Throwable> {
    public final /* synthetic */ OfferOsagoOrderViewModel a;

    public c(OfferOsagoOrderViewModel offerOsagoOrderViewModel) {
        this.a = offerOsagoOrderViewModel;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Throwable th) {
        this.a.c(BaseAnalyticKt.ANALYTIC_FAIL_SERVER);
        this.a.getErrorOccurred().setValue(Boolean.TRUE);
        this.a.getOsagoOrderState().setValue(OsagoOrderState.WAIT);
        this.a.getOsagoOrderButtonState().setValue(OsagoOrderButtonState.WAIT);
        this.a.t.logError(MessagePriority.ERROR, this.a.u.wrap(th));
    }
}
