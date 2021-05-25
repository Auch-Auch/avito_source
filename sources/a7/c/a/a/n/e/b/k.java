package a7.c.a.a.n.e.b;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import ru.sravni.android.bankproduct.network.offer.product.response.OfferProductStatusResponse;
public final class k<T, R> implements Function<T, R> {
    public static final k a = new k();

    @Override // io.reactivex.functions.Function
    public Object apply(Object obj) {
        OfferProductStatusResponse offerProductStatusResponse = (OfferProductStatusResponse) obj;
        Intrinsics.checkParameterIsNotNull(offerProductStatusResponse, "it");
        return offerProductStatusResponse.getItemOfferStatus().toOfferStatusElementRepo();
    }
}
