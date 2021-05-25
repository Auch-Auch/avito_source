package a2.a.a.s.a.b;

import com.avito.android.beduin.model.BeduinActionsResponse;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.util.LoadingState;
import io.reactivex.rxjava3.functions.Function;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
public final class c<T, R> implements Function<TypedResult<BeduinActionsResponse>, LoadingState<? super BeduinActionsResponse>> {
    public static final c a = new c();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public LoadingState<? super BeduinActionsResponse> apply(TypedResult<BeduinActionsResponse> typedResult) {
        TypedResult<BeduinActionsResponse> typedResult2 = typedResult;
        Intrinsics.checkNotNullExpressionValue(typedResult2, "it");
        if (typedResult2 instanceof TypedResult.OfResult) {
            return new LoadingState.Loaded(((TypedResult.OfResult) typedResult2).getResult());
        }
        if (typedResult2 instanceof TypedResult.OfError) {
            return new LoadingState.Error(((TypedResult.OfError) typedResult2).getError());
        }
        throw new NoWhenBranchMatchedException();
    }
}
