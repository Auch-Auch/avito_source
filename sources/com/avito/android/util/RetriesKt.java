package com.avito.android.util;

import com.avito.android.remote.model.TypedResult;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u001a\u0001\u0010\u0010\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00028\u0000 \u000f*\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00020\u00020\u0001\"\u0006\b\u0000\u0010\u0000\u0018\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2\u001a\b\u0006\u0010\u000e\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0004\u0012\u00020\r0\fH\bø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0012"}, d2 = {"T", "Lio/reactivex/Single;", "Lcom/avito/android/remote/model/TypedResult;", "", "firstDelayMs", "", "maxRetries", "maxDelayMs", "", "factor", "Lio/reactivex/Scheduler;", "scheduler", "Lkotlin/Function1;", "", "precondition", "kotlin.jvm.PlatformType", "retryOnNetworkError", "(Lio/reactivex/Single;JILjava/lang/Long;DLio/reactivex/Scheduler;Lkotlin/jvm/functions/Function1;)Lio/reactivex/Single;", "api_release"}, k = 2, mv = {1, 4, 2})
public final class RetriesKt {
    public static final /* synthetic */ <T> Single<TypedResult<T>> retryOnNetworkError(Single<TypedResult<T>> single, long j, int i, Long l, double d, Scheduler scheduler, Function1<? super TypedResult<T>, Boolean> function1) {
        Intrinsics.checkNotNullParameter(single, "$this$retryOnNetworkError");
        Intrinsics.checkNotNullParameter(scheduler, "scheduler");
        Intrinsics.checkNotNullParameter(function1, "precondition");
        Single<R> onErrorResumeNext = single.map(new RetriesKt$retryOnNetworkError$2(function1)).retryWhen(new RetriesKt$retryOnNetworkError$3(i, j, l, d, scheduler)).onErrorResumeNext(RetriesKt$retryOnNetworkError$4.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(onErrorResumeNext, "this.map {\n        if (p…)\n            }\n        }");
        return onErrorResumeNext;
    }

    public static /* synthetic */ Single retryOnNetworkError$default(Single single, long j, int i, Long l, double d, Scheduler scheduler, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = 1000;
        }
        int i3 = (i2 & 2) != 0 ? 3 : i;
        if ((i2 & 4) != 0) {
            l = null;
        }
        if ((i2 & 8) != 0) {
            d = 2.0d;
        }
        if ((i2 & 16) != 0) {
            scheduler = Schedulers.io();
            Intrinsics.checkNotNullExpressionValue(scheduler, "Schedulers.io()");
        }
        if ((i2 & 32) != 0) {
            function1 = RetriesKt$retryOnNetworkError$1.INSTANCE;
        }
        Intrinsics.checkNotNullParameter(single, "$this$retryOnNetworkError");
        Intrinsics.checkNotNullParameter(scheduler, "scheduler");
        Intrinsics.checkNotNullParameter(function1, "precondition");
        Single onErrorResumeNext = single.map(new RetriesKt$retryOnNetworkError$2(function1)).retryWhen(new RetriesKt$retryOnNetworkError$3(i3, j, l, d, scheduler)).onErrorResumeNext(RetriesKt$retryOnNetworkError$4.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(onErrorResumeNext, "this.map {\n        if (p…)\n            }\n        }");
        return onErrorResumeNext;
    }
}
