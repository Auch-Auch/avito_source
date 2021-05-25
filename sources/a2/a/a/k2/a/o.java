package a2.a.a.k2.a;

import com.avito.android.remote.model.SearchParameters;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.util.LoadingState;
import io.reactivex.rxjava3.functions.Function;
import kotlin.NoWhenBranchMatchedException;
public final class o<T, R> implements Function<TypedResult<SearchParameters>, LoadingState<? super SearchParameters>> {
    public static final o a = new o();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public LoadingState<? super SearchParameters> apply(TypedResult<SearchParameters> typedResult) {
        TypedResult<SearchParameters> typedResult2 = typedResult;
        if (typedResult2 instanceof TypedResult.OfResult) {
            return new LoadingState.Loaded(((TypedResult.OfResult) typedResult2).getResult());
        }
        if (typedResult2 instanceof TypedResult.OfError) {
            return new LoadingState.Error(((TypedResult.OfError) typedResult2).getError());
        }
        throw new NoWhenBranchMatchedException();
    }
}
