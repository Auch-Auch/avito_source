package com.avito.android.util;

import com.avito.android.remote.model.TypedResult;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a'\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001a-\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"", "T", "Lcom/avito/android/remote/model/TypedResult;", "Lio/reactivex/Single;", "toTypedSingle", "(Lcom/avito/android/remote/model/TypedResult;)Lio/reactivex/Single;", "toTyped", "(Lio/reactivex/Single;)Lio/reactivex/Single;", "api_release"}, k = 2, mv = {1, 4, 2})
public final class TypedSingleKt {

    public static final class a<T, R> implements Function<TypedResult<T>, SingleSource<? extends T>> {
        public static final a a = new a();

        @Override // io.reactivex.functions.Function
        public Object apply(Object obj) {
            TypedResult typedResult = (TypedResult) obj;
            Intrinsics.checkNotNullParameter(typedResult, "it");
            return TypedSingleKt.toTypedSingle(typedResult);
        }
    }

    /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: io.reactivex.Single<R>, java.lang.Object, io.reactivex.Single<T> */
    @NotNull
    public static final <T> Single<T> toTyped(@NotNull Single<TypedResult<T>> single) {
        Intrinsics.checkNotNullParameter(single, "$this$toTyped");
        Single single2 = (Single<R>) single.flatMap(a.a);
        Intrinsics.checkNotNullExpressionValue(single2, "flatMap { it.toTypedSingle() }");
        return single2;
    }

    @NotNull
    public static final <T> Single<T> toTypedSingle(@NotNull TypedResult<T> typedResult) {
        Intrinsics.checkNotNullParameter(typedResult, "$this$toTypedSingle");
        if (typedResult instanceof TypedResult.OfResult) {
            Single<T> just = Single.just(((TypedResult.OfResult) typedResult).getResult());
            Intrinsics.checkNotNullExpressionValue(just, "Single.just(result)");
            return just;
        } else if (typedResult instanceof TypedResult.OfError) {
            Single<T> error = Single.error(new TypedResultException(((TypedResult.OfError) typedResult).getError()));
            Intrinsics.checkNotNullExpressionValue(error, "Single.error(TypedResultException(error))");
            return error;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }
}
