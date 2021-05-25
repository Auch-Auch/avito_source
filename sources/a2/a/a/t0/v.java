package a2.a.a.t0;

import com.avito.android.remote.model.SuccessResult;
import io.reactivex.functions.Function;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
public final class v<T, R> implements Function<SuccessResult, Unit> {
    public static final v a = new v();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public Unit apply(SuccessResult successResult) {
        Intrinsics.checkNotNullParameter(successResult, "it");
        return Unit.INSTANCE;
    }
}
