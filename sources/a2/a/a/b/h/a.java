package a2.a.a.b.h;

import com.avito.android.authorization.reset_password.ResetPasswordInteractorImpl;
import com.avito.android.remote.model.SuccessResult;
import com.avito.android.util.Observables;
import com.avito.android.util.TypedResultException;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class a<T, R> implements Function<Throwable, ObservableSource<? extends SuccessResult>> {
    public final /* synthetic */ ResetPasswordInteractorImpl a;

    public a(ResetPasswordInteractorImpl resetPasswordInteractorImpl) {
        this.a = resetPasswordInteractorImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public ObservableSource<? extends SuccessResult> apply(Throwable th) {
        Throwable th2 = th;
        Intrinsics.checkNotNullParameter(th2, "ex");
        return Observables.toObservable(new TypedResultException(this.a.e.convert(th2)));
    }
}
