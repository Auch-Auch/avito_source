package a7.c.a.a.n.e.a;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import ru.sravni.android.bankproduct.network.offer.osago.response.OsagoOrderCompanyInfoResponse;
public final class i<T, R> implements Function<T, R> {
    public static final i a = new i();

    @Override // io.reactivex.functions.Function
    public Object apply(Object obj) {
        OsagoOrderCompanyInfoResponse osagoOrderCompanyInfoResponse = (OsagoOrderCompanyInfoResponse) obj;
        Intrinsics.checkParameterIsNotNull(osagoOrderCompanyInfoResponse, "it");
        return osagoOrderCompanyInfoResponse.getItem().toOsagoOrderCompanyInfoRepo();
    }
}
