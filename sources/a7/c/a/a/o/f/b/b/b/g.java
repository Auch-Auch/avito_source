package a7.c.a.a.o.f.b.b.b;

import io.reactivex.functions.Consumer;
import ru.sravni.android.bankproduct.presentation.offer.product.list.viewmodel.OfferProductListViewModel;
public final class g<T> implements Consumer<Throwable> {
    public final /* synthetic */ OfferProductListViewModel a;

    public g(OfferProductListViewModel offerProductListViewModel) {
        this.a = offerProductListViewModel;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Throwable th) {
        OfferProductListViewModel.access$uncriticalErrorOnRequestAction(this.a, th, true);
    }
}
