package com.avito.android.util;

import com.avito.android.remote.model.TypedResult;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\b\u001aB\u0012\u001a\b\u0001\u0012\u0016\u0012\u0004\u0012\u00028\u0000 \u0005*\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00040\u0004 \u0005* \u0012\u001a\b\u0001\u0012\u0016\u0012\u0004\u0012\u00028\u0000 \u0005*\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u0003\"\u0006\b\u0000\u0010\u0000\u0018\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"T", "", "e", "Lio/reactivex/SingleSource;", "Lcom/avito/android/remote/model/TypedResult;", "kotlin.jvm.PlatformType", "apply", "(Ljava/lang/Throwable;)Lio/reactivex/SingleSource;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class RetriesKt$retryOnNetworkError$4<T, R> implements Function<Throwable, SingleSource<? extends TypedResult<T>>> {
    public static final RetriesKt$retryOnNetworkError$4 INSTANCE = new RetriesKt$retryOnNetworkError$4();

    public final SingleSource<? extends TypedResult<T>> apply(@NotNull Throwable th) {
        Intrinsics.checkNotNullParameter(th, "e");
        if (!(th instanceof ShouldRetryException)) {
            return Single.error(th);
        }
        TypedResult<?> error = ((ShouldRetryException) th).getError();
        Objects.requireNonNull(error, "null cannot be cast to non-null type com.avito.android.remote.model.TypedResult<T>");
        return Single.just(error);
    }
}
