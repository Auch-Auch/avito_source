package a7.c.a.a.n.e.b;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import ru.sravni.android.bankproduct.network.offer.product.response.OfferProductCountResponse;
public final class c<T, R> implements Function<T, R> {
    public static final c a = new c();

    @Override // io.reactivex.functions.Function
    public Object apply(Object obj) {
        OfferProductCountResponse offerProductCountResponse = (OfferProductCountResponse) obj;
        Intrinsics.checkParameterIsNotNull(offerProductCountResponse, "it");
        return Integer.valueOf(offerProductCountResponse.getCount());
    }
}
