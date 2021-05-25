package com.avito.android.util;

import com.avito.android.remote.model.TypedResult;
import com.avito.android.util.MultiStateLoading;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a,\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0002H\b¢\u0006\u0004\b\u0004\u0010\u0005\u001a,\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0002H\b¢\u0006\u0004\b\u0006\u0010\u0005¨\u0006\u0007"}, d2 = {"", "T", "Lcom/avito/android/remote/model/TypedResult;", "Lcom/avito/android/util/MultiStateLoading;", "toInitMultiStateLoading", "(Lcom/avito/android/remote/model/TypedResult;)Lcom/avito/android/util/MultiStateLoading;", "toMultiStateLoading", "loading-state_release"}, k = 2, mv = {1, 4, 2})
public final class MultiStateLoadingKt {
    public static final /* synthetic */ <T> MultiStateLoading<T> toInitMultiStateLoading(TypedResult<T> typedResult) {
        Intrinsics.checkNotNullParameter(typedResult, "$this$toInitMultiStateLoading");
        if (typedResult instanceof TypedResult.OfResult) {
            return new MultiStateLoading.Loaded(((TypedResult.OfResult) typedResult).getResult());
        }
        if (typedResult instanceof TypedResult.OfError) {
            return new MultiStateLoading.InitError(((TypedResult.OfError) typedResult).getError());
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final /* synthetic */ <T> MultiStateLoading<T> toMultiStateLoading(TypedResult<T> typedResult) {
        Intrinsics.checkNotNullParameter(typedResult, "$this$toMultiStateLoading");
        if (typedResult instanceof TypedResult.OfResult) {
            return new MultiStateLoading.Loaded(((TypedResult.OfResult) typedResult).getResult());
        }
        if (typedResult instanceof TypedResult.OfError) {
            return new MultiStateLoading.Error(((TypedResult.OfError) typedResult).getError());
        }
        throw new NoWhenBranchMatchedException();
    }
}
