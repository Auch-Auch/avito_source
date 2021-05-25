package a7.c.a.a.o.f.b.a.b;

import io.reactivex.functions.Consumer;
import ru.sravni.android.bankproduct.presentation.offer.product.info.viewmodel.OfferProductInfoFromListViewModel;
public final class b<T> implements Consumer<Throwable> {
    public final /* synthetic */ OfferProductInfoFromListViewModel a;

    public b(OfferProductInfoFromListViewModel offerProductInfoFromListViewModel) {
        this.a = offerProductInfoFromListViewModel;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Throwable th) {
        this.a.i.errorServer(th);
    }
}
