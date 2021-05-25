package a7.c.a.a.n.e.a;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import ru.sravni.android.bankproduct.network.offer.osago.response.OsagoCompanyOrderResponse;
public final class a<T, R> implements Function<T, R> {
    public static final a a = new a();

    @Override // io.reactivex.functions.Function
    public Object apply(Object obj) {
        OsagoCompanyOrderResponse osagoCompanyOrderResponse = (OsagoCompanyOrderResponse) obj;
        Intrinsics.checkParameterIsNotNull(osagoCompanyOrderResponse, "it");
        return osagoCompanyOrderResponse.getItem().toOsagoCompanyOrderRepo();
    }
}
