package a2.a.a.b.b;

import com.avito.android.authorization.auth.AuthInteractor;
import com.avito.android.util.rx3.Maybies;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class a<T, R> implements Function<Boolean, MaybeSource<? extends AuthInteractor.FastLogin>> {
    public final /* synthetic */ boolean a;

    public a(boolean z) {
        this.a = z;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public MaybeSource<? extends AuthInteractor.FastLogin> apply(Boolean bool) {
        Boolean bool2 = bool;
        Intrinsics.checkNotNullExpressionValue(bool2, "hasSmartLock");
        if (bool2.booleanValue()) {
            return Maybies.toMaybe(AuthInteractor.FastLogin.SMART_LOCK);
        }
        if (this.a) {
            return Maybies.toMaybe(AuthInteractor.FastLogin.SUGGESTS);
        }
        return Maybe.empty();
    }
}
