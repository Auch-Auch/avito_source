package com.avito.android.util;

import com.avito.android.util.rx.RetryWhenKt;
import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.reactivestreams.Publisher;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\b\u001a\u0012\u0012\u0002\b\u0003 \u0003*\b\u0012\u0002\b\u0003\u0018\u00010\u00050\u0005\"\u0006\b\u0000\u0010\u0000\u0018\u00012\u0014\u0010\u0004\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u0001H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"T", "Lio/reactivex/Flowable;", "", "kotlin.jvm.PlatformType", "errors", "Lorg/reactivestreams/Publisher;", "apply", "(Lio/reactivex/Flowable;)Lorg/reactivestreams/Publisher;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class RetriesKt$retryOnNetworkError$3<T, R> implements Function<Flowable<Throwable>, Publisher<?>> {
    public final /* synthetic */ int a;
    public final /* synthetic */ long b;
    public final /* synthetic */ Long c;
    public final /* synthetic */ double d;
    public final /* synthetic */ Scheduler e;

    public RetriesKt$retryOnNetworkError$3(int i, long j, Long l, double d2, Scheduler scheduler) {
        this.a = i;
        this.b = j;
        this.c = l;
        this.d = d2;
        this.e = scheduler;
    }

    public final Publisher<?> apply(@NotNull Flowable<Throwable> flowable) {
        Intrinsics.checkNotNullParameter(flowable, "errors");
        int i = this.a;
        long j = this.b;
        Long l = this.c;
        double d2 = this.d;
        return RetryWhenKt.exponentialRetry(j, i, this.e, AnonymousClass2.INSTANCE, AnonymousClass1.INSTANCE, l, d2).apply(flowable);
    }
}
