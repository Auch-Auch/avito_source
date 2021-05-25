package com.avito.android.cart_fab;

import com.avito.android.remote.model.TypedResult;
import com.avito.android.util.ShouldRetryException;
import io.reactivex.rxjava3.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00028\u0000 \u0002*\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00010\u0001\"\u0006\b\u0000\u0010\u0000\u0018\u00012\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00028\u0000 \u0002*\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00010\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"T", "Lcom/avito/android/remote/model/TypedResult;", "kotlin.jvm.PlatformType", "it", "apply", "(Lcom/avito/android/remote/model/TypedResult;)Lcom/avito/android/remote/model/TypedResult;", "com/avito/android/util/rx3/RetriesKt$retryOnNetworkError$2", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class CartFabViewModelImpl$loadCartSize$2$$special$$inlined$retryOnNetworkError$1<T, R> implements Function<TypedResult<T>, TypedResult<T>> {
    public final TypedResult<T> apply(TypedResult<T> typedResult) {
        Intrinsics.checkNotNullExpressionValue(typedResult, "it");
        if (!(typedResult instanceof TypedResult.OfError)) {
            return typedResult;
        }
        throw new ShouldRetryException(typedResult);
    }

    @Override // io.reactivex.rxjava3.functions.Function
    public /* bridge */ /* synthetic */ Object apply(Object obj) {
        return apply((TypedResult) ((TypedResult) obj));
    }
}
