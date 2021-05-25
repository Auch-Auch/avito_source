package a2.a.a.e;

import com.avito.android.account.AccountInteractorImpl;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class c<T, R> implements Function<Boolean, CompletableSource> {
    public final /* synthetic */ AccountInteractorImpl a;

    public c(AccountInteractorImpl accountInteractorImpl) {
        this.a = accountInteractorImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public CompletableSource apply(Boolean bool) {
        Boolean bool2 = bool;
        Intrinsics.checkNotNullExpressionValue(bool2, "isAuthorized");
        if (bool2.booleanValue()) {
            return this.a.logout(false, "pre_login");
        }
        return Completable.complete();
    }
}
