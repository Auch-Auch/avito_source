package a7.c.a.a.n.e.b;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import ru.sravni.android.bankproduct.network.offer.product.response.OfferProductDetailResponse;
public final class i<T, R> implements Function<T, R> {
    public static final i a = new i();

    @Override // io.reactivex.functions.Function
    public Object apply(Object obj) {
        OfferProductDetailResponse offerProductDetailResponse = (OfferProductDetailResponse) obj;
        Intrinsics.checkParameterIsNotNull(offerProductDetailResponse, "it");
        return offerProductDetailResponse.getItemOfferDetail().toOfferProductListOfferRepo();
    }
}
