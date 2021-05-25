package com.avito.android.util.rx3;

import com.avito.android.remote.model.TypedResult;
import com.avito.android.util.ShouldRetryException;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.functions.Function;
import java.util.Objects;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\b\u001aB\u0012\u001a\b\u0001\u0012\u0016\u0012\u0004\u0012\u00028\u0000 \u0002*\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00050\u0005 \u0002* \u0012\u001a\b\u0001\u0012\u0016\u0012\u0004\u0012\u00028\u0000 \u0002*\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00050\u0005\u0018\u00010\u00040\u0004\"\u0006\b\u0000\u0010\u0000\u0018\u00012\u000e\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"T", "", "kotlin.jvm.PlatformType", "e", "Lio/reactivex/rxjava3/core/SingleSource;", "Lcom/avito/android/remote/model/TypedResult;", "apply", "(Ljava/lang/Throwable;)Lio/reactivex/rxjava3/core/SingleSource;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class RetriesKt$retryOnNetworkError$4<T, R> implements Function<Throwable, SingleSource<? extends TypedResult<T>>> {
    public static final RetriesKt$retryOnNetworkError$4 INSTANCE = new RetriesKt$retryOnNetworkError$4();

    public final SingleSource<? extends TypedResult<T>> apply(Throwable th) {
        if (!(th instanceof ShouldRetryException)) {
            return Single.error(th);
        }
        TypedResult<?> error = ((ShouldRetryException) th).getError();
        Objects.requireNonNull(error, "null cannot be cast to non-null type com.avito.android.remote.model.TypedResult<T>");
        return Single.just(error);
    }
}
