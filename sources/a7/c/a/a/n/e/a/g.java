package a7.c.a.a.n.e.a;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import ru.sravni.android.bankproduct.network.offer.osago.response.OfferOsagoListCompanyResponse;
public final class g<T, R> implements Function<T, R> {
    public static final g a = new g();

    @Override // io.reactivex.functions.Function
    public Object apply(Object obj) {
        OfferOsagoListCompanyResponse offerOsagoListCompanyResponse = (OfferOsagoListCompanyResponse) obj;
        Intrinsics.checkParameterIsNotNull(offerOsagoListCompanyResponse, "it");
        return offerOsagoListCompanyResponse.toOfferOsagoListCompanyRepo();
    }
}
