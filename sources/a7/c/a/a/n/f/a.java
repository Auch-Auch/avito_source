package a7.c.a.a.n.f;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import ru.sravni.android.bankproduct.network.profile.response.v2.AccountV2Response;
public final class a<T, R> implements Function<T, R> {
    public static final a a = new a();

    @Override // io.reactivex.functions.Function
    public Object apply(Object obj) {
        AccountV2Response accountV2Response = (AccountV2Response) obj;
        Intrinsics.checkParameterIsNotNull(accountV2Response, "it");
        return accountV2Response.getItem().toProfileRepo();
    }
}
