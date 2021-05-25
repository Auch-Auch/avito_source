package a7.c.a.a.n.e.a;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import ru.sravni.android.bankproduct.network.offer.osago.OfferOsagoWebClient;
import ru.sravni.android.bankproduct.repository.offer.osago.entity.order.OsagoCompanyOrderInfoRepo;
public final class j<T, R> implements Function<Throwable, ObservableSource<? extends OsagoCompanyOrderInfoRepo>> {
    public final /* synthetic */ OfferOsagoWebClient.e a;

    public j(OfferOsagoWebClient.e eVar) {
        this.a = eVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public ObservableSource<? extends OsagoCompanyOrderInfoRepo> apply(Throwable th) {
        Throwable th2 = th;
        Intrinsics.checkParameterIsNotNull(th2, "it");
        return Observable.error(this.a.a.b.wrap(th2));
    }
}
