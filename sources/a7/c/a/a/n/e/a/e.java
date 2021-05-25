package a7.c.a.a.n.e.a;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import ru.sravni.android.bankproduct.network.offer.osago.response.OsagoCompanyOrderResponse;
public final class e<T, R> implements Function<T, R> {
    public static final e a = new e();

    @Override // io.reactivex.functions.Function
    public Object apply(Object obj) {
        OsagoCompanyOrderResponse osagoCompanyOrderResponse = (OsagoCompanyOrderResponse) obj;
        Intrinsics.checkParameterIsNotNull(osagoCompanyOrderResponse, "it");
        return osagoCompanyOrderResponse.getItem().toOsagoCompanyOrderRepo();
    }
}
