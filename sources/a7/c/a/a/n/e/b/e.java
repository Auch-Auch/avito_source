package a7.c.a.a.n.e.b;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import ru.sravni.android.bankproduct.network.offer.product.response.OfferProductListResponse;
public final class e<T, R> implements Function<T, R> {
    public static final e a = new e();

    @Override // io.reactivex.functions.Function
    public Object apply(Object obj) {
        OfferProductListResponse offerProductListResponse = (OfferProductListResponse) obj;
        Intrinsics.checkParameterIsNotNull(offerProductListResponse, "it");
        return offerProductListResponse.getItem().toOfferProductListRepo();
    }
}
