package a7.c.a.a.n.e.b;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import ru.sravni.android.bankproduct.network.offer.product.OfferProductListWebClient;
import ru.sravni.android.bankproduct.repository.offer.product.entity.OfferProductListRepo;
public final class h<T, R> implements Function<Throwable, ObservableSource<? extends OfferProductListRepo>> {
    public final /* synthetic */ OfferProductListWebClient.d a;

    public h(OfferProductListWebClient.d dVar) {
        this.a = dVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public ObservableSource<? extends OfferProductListRepo> apply(Throwable th) {
        Throwable th2 = th;
        Intrinsics.checkParameterIsNotNull(th2, "it");
        return Observable.error(this.a.a.b.wrap(th2));
    }
}
