package a7.c.a.a.n.e.a;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import ru.sravni.android.bankproduct.network.offer.osago.response.OfferOsagoListResponse;
public final class c<T, R> implements Function<T, R> {
    public static final c a = new c();

    @Override // io.reactivex.functions.Function
    public Object apply(Object obj) {
        OfferOsagoListResponse offerOsagoListResponse = (OfferOsagoListResponse) obj;
        Intrinsics.checkParameterIsNotNull(offerOsagoListResponse, "it");
        return offerOsagoListResponse.getItem().toOfferOsagoListRepo();
    }
}
