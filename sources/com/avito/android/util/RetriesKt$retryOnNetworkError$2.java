package com.avito.android.util;

import com.avito.android.remote.model.TypedResult;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00028\u0000 \u0003*\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00010\u0001\"\u0006\b\u0000\u0010\u0000\u0018\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "Lcom/avito/android/remote/model/TypedResult;", "it", "kotlin.jvm.PlatformType", "apply", "(Lcom/avito/android/remote/model/TypedResult;)Lcom/avito/android/remote/model/TypedResult;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class RetriesKt$retryOnNetworkError$2<T, R> implements Function<TypedResult<T>, TypedResult<T>> {
    public final /* synthetic */ Function1 a;

    public RetriesKt$retryOnNetworkError$2(Function1 function1) {
        this.a = function1;
    }

    public final TypedResult<T> apply(@NotNull TypedResult<T> typedResult) {
        Intrinsics.checkNotNullParameter(typedResult, "it");
        if (!((Boolean) this.a.invoke(typedResult)).booleanValue()) {
            return typedResult;
        }
        throw new ShouldRetryException(typedResult);
    }

    @Override // io.reactivex.functions.Function
    public /* bridge */ /* synthetic */ Object apply(Object obj) {
        return apply((TypedResult) ((TypedResult) obj));
    }
}
