package a2.a.a.t1.a;

import com.avito.android.remote.model.TypedResult;
import com.avito.android.util.LoadingState;
import io.reactivex.functions.Function;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
public final class d<T, R> implements Function<TypedResult<T>, LoadingState<? super T>> {
    public static final d a = new d();

    @Override // io.reactivex.functions.Function
    public Object apply(Object obj) {
        TypedResult typedResult = (TypedResult) obj;
        Intrinsics.checkNotNullParameter(typedResult, "it");
        if (typedResult instanceof TypedResult.OfResult) {
            return new LoadingState.Loaded(((TypedResult.OfResult) typedResult).getResult());
        }
        if (typedResult instanceof TypedResult.OfError) {
            return new LoadingState.Error(((TypedResult.OfError) typedResult).getError());
        }
        throw new NoWhenBranchMatchedException();
    }
}
