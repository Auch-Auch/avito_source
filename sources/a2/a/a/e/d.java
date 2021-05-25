package a2.a.a.e;

import com.avito.android.account.AccountInteractorImpl;
import com.avito.android.util.Throwables;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class d<T, R> implements Function<Boolean, SingleSource<? extends Boolean>> {
    public final /* synthetic */ AccountInteractorImpl.k a;
    public final /* synthetic */ Throwable b;

    public d(AccountInteractorImpl.k kVar, Throwable th) {
        this.a = kVar;
        this.b = th;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public SingleSource<? extends Boolean> apply(Boolean bool) {
        Boolean bool2 = bool;
        if (Throwables.isForbiddenError(this.b)) {
            Intrinsics.checkNotNullExpressionValue(bool2, "isAuthorized");
            if (bool2.booleanValue()) {
                return this.a.a.f.logout(true, "login_error").toSingleDefault(bool2);
            }
        }
        return Single.just(bool2);
    }
}
