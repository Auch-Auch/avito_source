package a2.a.a.i2.a.a;

import com.avito.android.remote.error.TypedError;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.model.delivery_courier.DeliveryCourierOrderParamsUpdate;
import com.avito.android.util.LoadingState;
import io.reactivex.functions.Function;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import t6.n.r;
public final class f<T, R> implements Function<TypedResult<DeliveryCourierOrderParamsUpdate>, LoadingState<? super Map<String, ? extends String>>> {
    public static final f a = new f();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public LoadingState<? super Map<String, ? extends String>> apply(TypedResult<DeliveryCourierOrderParamsUpdate> typedResult) {
        TypedResult<DeliveryCourierOrderParamsUpdate> typedResult2 = typedResult;
        Intrinsics.checkNotNullParameter(typedResult2, "it");
        if (typedResult2 instanceof TypedResult.OfResult) {
            if (((DeliveryCourierOrderParamsUpdate) ((TypedResult.OfResult) typedResult2).getResult()).getSuccess()) {
                return new LoadingState.Loaded(r.emptyMap());
            }
            return new LoadingState.Error(new TypedError() { // from class: com.avito.android.safedeal.delivery_courier.order_update.DeliveryCourierOrderUpdateInteractorImpl$submitUpdateApi$1$1
            });
        } else if (typedResult2 instanceof TypedResult.OfError) {
            return new LoadingState.Error(((TypedResult.OfError) typedResult2).getError());
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }
}
