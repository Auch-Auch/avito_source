package a2.a.a.o1.d.a0.c.a;

import com.avito.android.remote.model.TypedResult;
import com.avito.android.util.LoadingState;
import io.reactivex.functions.Function;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
public final class a<T, R> implements Function<TypedResult<Unit>, LoadingState<? super Unit>> {
    public static final a a = new a();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public LoadingState<? super Unit> apply(TypedResult<Unit> typedResult) {
        TypedResult<Unit> typedResult2 = typedResult;
        Intrinsics.checkNotNullParameter(typedResult2, "it");
        if (typedResult2 instanceof TypedResult.OfResult) {
            return new LoadingState.Loaded(((TypedResult.OfResult) typedResult2).getResult());
        }
        if (typedResult2 instanceof TypedResult.OfError) {
            return new LoadingState.Error(((TypedResult.OfError) typedResult2).getError());
        }
        throw new NoWhenBranchMatchedException();
    }
}
