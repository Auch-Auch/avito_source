package com.avito.android.util;

import a2.a.a.n3.l;
import a2.a.a.n3.m;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.TypedError;
import com.avito.android.util.LoadingState;
import io.reactivex.Flowable;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u0011\u0010\u0012JM\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n0\u0004\"\u0004\b\u0000\u0010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00018\u00002\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/avito/android/util/LoadingStateStreamBuilder;", "", "T", "cache", "Lio/reactivex/Flowable;", "fallback", "Lkotlin/Function1;", "", "Lcom/avito/android/remote/error/TypedError;", "errorHandler", "Lcom/avito/android/util/LoadingState;", "build", "(Ljava/lang/Object;Lio/reactivex/Flowable;Lkotlin/jvm/functions/Function1;)Lio/reactivex/Flowable;", "Lcom/avito/android/util/SchedulersFactory;", AuthSource.SEND_ABUSE, "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "<init>", "(Lcom/avito/android/util/SchedulersFactory;)V", "loading-state_release"}, k = 1, mv = {1, 4, 2})
public class LoadingStateStreamBuilder {
    public final SchedulersFactory a;

    public LoadingStateStreamBuilder(@NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        this.a = schedulersFactory;
    }

    @NotNull
    public <T> Flowable<LoadingState<T>> build(@Nullable T t, @NotNull Flowable<T> flowable, @NotNull Function1<? super Throwable, ? extends TypedError> function1) {
        Flowable flowable2;
        Intrinsics.checkNotNullParameter(flowable, "fallback");
        Intrinsics.checkNotNullParameter(function1, "errorHandler");
        if (t != null) {
            flowable2 = Flowables.toSingletonFlowable(new LoadingState.Loaded(t));
            Objects.requireNonNull(flowable2, "null cannot be cast to non-null type io.reactivex.Flowable<com.avito.android.util.LoadingState<T>>");
        } else {
            flowable2 = Flowables.emptyFlowable();
        }
        Flowable<T> subscribeOn = flowable2.subscribeOn(this.a.trampoline());
        Flowable<R> startWith = flowable.subscribeOn(this.a.io()).map(l.a).onErrorReturn(new m(function1)).startWith((Flowable<R>) ((R) LoadingState.Loading.INSTANCE));
        Intrinsics.checkNotNullExpressionValue(startWith, "fallback\n            .su…      .startWith(Loading)");
        Flowable<T> switchIfEmpty = subscribeOn.switchIfEmpty(startWith);
        Intrinsics.checkNotNullExpressionValue(switchIfEmpty, "cache\n            .toStr…(fallback, errorHandler))");
        return switchIfEmpty;
    }
}
