package com.avito.android.cart_fab;

import a2.b.a.a.a;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.util.TypedResultException;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.functions.Function;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\t\u001a*\u0012\u000e\b\u0001\u0012\n \u0003*\u0004\u0018\u00018\u00008\u0000 \u0003*\u0014\u0012\u000e\b\u0001\u0012\n \u0003*\u0004\u0018\u00018\u00008\u0000\u0018\u00010\u00050\u0005\"\b\b\u0000\u0010\u0001*\u00020\u00002\u001a\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00028\u0000 \u0003*\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00020\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"", "T", "Lcom/avito/android/remote/model/TypedResult;", "kotlin.jvm.PlatformType", "it", "Lio/reactivex/rxjava3/core/SingleSource;", "apply", "(Lcom/avito/android/remote/model/TypedResult;)Lio/reactivex/rxjava3/core/SingleSource;", "com/avito/android/util/rx3/TypedSingleKt$toTyped$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class CartFabViewModelImpl$loadCartSize$2$$special$$inlined$toTyped$1<T, R> implements Function<TypedResult<T>, SingleSource<? extends T>> {
    public static final CartFabViewModelImpl$loadCartSize$2$$special$$inlined$toTyped$1 INSTANCE = new CartFabViewModelImpl$loadCartSize$2$$special$$inlined$toTyped$1();

    public final SingleSource<? extends T> apply(TypedResult<T> typedResult) {
        Intrinsics.checkNotNullExpressionValue(typedResult, "it");
        if (typedResult instanceof TypedResult.OfResult) {
            return a.d2((TypedResult.OfResult) typedResult, "Single.just(result)");
        }
        if (typedResult instanceof TypedResult.OfError) {
            Single error = Single.error(new TypedResultException(((TypedResult.OfError) typedResult).getError()));
            Intrinsics.checkNotNullExpressionValue(error, "Single.error(TypedResultException(error))");
            return error;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // io.reactivex.rxjava3.functions.Function
    public /* bridge */ /* synthetic */ Object apply(Object obj) {
        return apply((TypedResult) ((TypedResult) obj));
    }
}
