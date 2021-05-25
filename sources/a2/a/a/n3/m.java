package a2.a.a.n3;

import com.avito.android.remote.error.TypedError;
import com.avito.android.util.LoadingState;
import io.reactivex.functions.Function;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
public final class m<T, R> implements Function<Throwable, LoadingState<? super T>> {
    public final /* synthetic */ Function1 a;

    public m(Function1 function1) {
        this.a = function1;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public Object apply(Throwable th) {
        Throwable th2 = th;
        Intrinsics.checkNotNullParameter(th2, "it");
        return new LoadingState.Error((TypedError) this.a.invoke(th2));
    }
}
