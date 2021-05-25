package a7.c.a.a.n.e.b;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import ru.sravni.android.bankproduct.network.offer.product.response.legacy.OfferProductListResponse;
public final class g<T, R> implements Function<T, R> {
    public static final g a = new g();

    @Override // io.reactivex.functions.Function
    public Object apply(Object obj) {
        OfferProductListResponse offerProductListResponse = (OfferProductListResponse) obj;
        Intrinsics.checkParameterIsNotNull(offerProductListResponse, "it");
        return offerProductListResponse.getItem().toOfferProductListRepo();
    }
}
