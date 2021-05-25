package a2.a.a.r1.a.b;

import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.orders.model.OrdersPageModel;
import com.avito.android.util.LoadingState;
import io.reactivex.rxjava3.functions.Function;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
public final class b<T, R> implements Function<TypedResult<OrdersPageModel>, LoadingState<? super OrdersPageModel>> {
    public static final b a = new b();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public LoadingState<? super OrdersPageModel> apply(TypedResult<OrdersPageModel> typedResult) {
        TypedResult<OrdersPageModel> typedResult2 = typedResult;
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
