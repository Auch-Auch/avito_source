package a7.c.a.a.o.f.b.b.b;

import io.reactivex.functions.Consumer;
import ru.sravni.android.bankproduct.domain.analytic.entity.MessagePriority;
import ru.sravni.android.bankproduct.presentation.offer.product.list.viewmodel.OfferProductFilterViewModel;
public final class c<T> implements Consumer<Throwable> {
    public final /* synthetic */ OfferProductFilterViewModel a;

    public c(OfferProductFilterViewModel offerProductFilterViewModel) {
        this.a = offerProductFilterViewModel;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Throwable th) {
        this.a.j.setWaitCountForPanel(false);
        this.a.j.setCountForPanel(0);
        this.a.l.logError(MessagePriority.ERROR, this.a.m.wrap(th));
    }
}
