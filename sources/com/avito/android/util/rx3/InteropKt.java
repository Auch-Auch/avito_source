package com.avito.android.util.rx3;

import hu.akarnokd.rxjava3.bridge.RxJavaBridge;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a'\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001a'\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0004\b\u0004\u0010\b\u001a\u0011\u0010\u0004\u001a\u00020\n*\u00020\t¢\u0006\u0004\b\u0004\u0010\u000b\u001a'\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\r\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\f¢\u0006\u0004\b\u0004\u0010\u000e\u001a'\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u000f¢\u0006\u0004\b\u0004\u0010\u0011\u001a'\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\u0004\b\u0012\u0010\u0013\u001a'\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0010¢\u0006\u0004\b\u0012\u0010\u0014\u001a'\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\f\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\r¢\u0006\u0004\b\u0012\u0010\u0015\u001a'\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0004\b\u0012\u0010\u0016\u001a\u0011\u0010\u0012\u001a\u00020\t*\u00020\n¢\u0006\u0004\b\u0012\u0010\u0017\u001a'\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0018¢\u0006\u0004\b\u001a\u0010\u001b\u001a'\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u001d\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u001c¢\u0006\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"", "T", "Lio/reactivex/Observable;", "Lio/reactivex/rxjava3/core/Observable;", "toV3", "(Lio/reactivex/Observable;)Lio/reactivex/rxjava3/core/Observable;", "Lio/reactivex/Flowable;", "Lio/reactivex/rxjava3/core/Flowable;", "(Lio/reactivex/Flowable;)Lio/reactivex/rxjava3/core/Flowable;", "Lio/reactivex/Completable;", "Lio/reactivex/rxjava3/core/Completable;", "(Lio/reactivex/Completable;)Lio/reactivex/rxjava3/core/Completable;", "Lio/reactivex/Maybe;", "Lio/reactivex/rxjava3/core/Maybe;", "(Lio/reactivex/Maybe;)Lio/reactivex/rxjava3/core/Maybe;", "Lio/reactivex/Single;", "Lio/reactivex/rxjava3/core/Single;", "(Lio/reactivex/Single;)Lio/reactivex/rxjava3/core/Single;", "toV2", "(Lio/reactivex/rxjava3/core/Observable;)Lio/reactivex/Observable;", "(Lio/reactivex/rxjava3/core/Single;)Lio/reactivex/Single;", "(Lio/reactivex/rxjava3/core/Maybe;)Lio/reactivex/Maybe;", "(Lio/reactivex/rxjava3/core/Flowable;)Lio/reactivex/Flowable;", "(Lio/reactivex/rxjava3/core/Completable;)Lio/reactivex/Completable;", "Lio/reactivex/rxjava3/functions/Consumer;", "Lcom/avito/android/util/rx3/ConsumerV3toV2;", "toConsumerV2", "(Lio/reactivex/rxjava3/functions/Consumer;)Lcom/avito/android/util/rx3/ConsumerV3toV2;", "Lio/reactivex/functions/Consumer;", "Lcom/avito/android/util/rx3/ConsumerV2toV3;", "toConsumerV3", "(Lio/reactivex/functions/Consumer;)Lcom/avito/android/util/rx3/ConsumerV2toV3;", "rx"}, k = 2, mv = {1, 4, 2})
public final class InteropKt {
    @NotNull
    public static final <T> ConsumerV3toV2<T> toConsumerV2(@NotNull Consumer<T> consumer) {
        Intrinsics.checkNotNullParameter(consumer, "$this$toConsumerV2");
        return new ConsumerV3toV2<>(consumer);
    }

    @NotNull
    public static final <T> ConsumerV2toV3<T> toConsumerV3(@NotNull io.reactivex.functions.Consumer<T> consumer) {
        Intrinsics.checkNotNullParameter(consumer, "$this$toConsumerV3");
        return new ConsumerV2toV3<>(consumer);
    }

    @NotNull
    public static final <T> Observable<T> toV2(@NotNull io.reactivex.rxjava3.core.Observable<T> observable) {
        Intrinsics.checkNotNullParameter(observable, "$this$toV2");
        Observable<T> v2Observable = RxJavaBridge.toV2Observable(observable);
        Intrinsics.checkNotNullExpressionValue(v2Observable, "RxJavaBridge.toV2Observable(this)");
        return v2Observable;
    }

    @NotNull
    public static final <T> io.reactivex.rxjava3.core.Observable<T> toV3(@NotNull Observable<T> observable) {
        Intrinsics.checkNotNullParameter(observable, "$this$toV3");
        io.reactivex.rxjava3.core.Observable<T> v3Observable = RxJavaBridge.toV3Observable(observable);
        Intrinsics.checkNotNullExpressionValue(v3Observable, "RxJavaBridge.toV3Observable(this)");
        return v3Observable;
    }

    @NotNull
    public static final <T> Single<T> toV2(@NotNull io.reactivex.rxjava3.core.Single<T> single) {
        Intrinsics.checkNotNullParameter(single, "$this$toV2");
        Single<T> v2Single = RxJavaBridge.toV2Single(single);
        Intrinsics.checkNotNullExpressionValue(v2Single, "RxJavaBridge.toV2Single(this)");
        return v2Single;
    }

    @NotNull
    public static final <T> Flowable<T> toV3(@NotNull io.reactivex.Flowable<T> flowable) {
        Intrinsics.checkNotNullParameter(flowable, "$this$toV3");
        Flowable<T> v3Flowable = RxJavaBridge.toV3Flowable(flowable);
        Intrinsics.checkNotNullExpressionValue(v3Flowable, "RxJavaBridge.toV3Flowable(this)");
        return v3Flowable;
    }

    @NotNull
    public static final <T> Maybe<T> toV2(@NotNull io.reactivex.rxjava3.core.Maybe<T> maybe) {
        Intrinsics.checkNotNullParameter(maybe, "$this$toV2");
        Maybe<T> v2Maybe = RxJavaBridge.toV2Maybe(maybe);
        Intrinsics.checkNotNullExpressionValue(v2Maybe, "RxJavaBridge.toV2Maybe(this)");
        return v2Maybe;
    }

    @NotNull
    public static final Completable toV3(@NotNull io.reactivex.Completable completable) {
        Intrinsics.checkNotNullParameter(completable, "$this$toV3");
        Completable v3Completable = RxJavaBridge.toV3Completable(completable);
        Intrinsics.checkNotNullExpressionValue(v3Completable, "RxJavaBridge.toV3Completable(this)");
        return v3Completable;
    }

    @NotNull
    public static final <T> io.reactivex.Flowable<T> toV2(@NotNull Flowable<T> flowable) {
        Intrinsics.checkNotNullParameter(flowable, "$this$toV2");
        io.reactivex.Flowable<T> v2Flowable = RxJavaBridge.toV2Flowable(flowable);
        Intrinsics.checkNotNullExpressionValue(v2Flowable, "RxJavaBridge.toV2Flowable(this)");
        return v2Flowable;
    }

    @NotNull
    public static final <T> io.reactivex.rxjava3.core.Maybe<T> toV3(@NotNull Maybe<T> maybe) {
        Intrinsics.checkNotNullParameter(maybe, "$this$toV3");
        io.reactivex.rxjava3.core.Maybe<T> v3Maybe = RxJavaBridge.toV3Maybe(maybe);
        Intrinsics.checkNotNullExpressionValue(v3Maybe, "RxJavaBridge.toV3Maybe(this)");
        return v3Maybe;
    }

    @NotNull
    public static final io.reactivex.Completable toV2(@NotNull Completable completable) {
        Intrinsics.checkNotNullParameter(completable, "$this$toV2");
        io.reactivex.Completable v2Completable = RxJavaBridge.toV2Completable(completable);
        Intrinsics.checkNotNullExpressionValue(v2Completable, "RxJavaBridge.toV2Completable(this)");
        return v2Completable;
    }

    @NotNull
    public static final <T> io.reactivex.rxjava3.core.Single<T> toV3(@NotNull Single<T> single) {
        Intrinsics.checkNotNullParameter(single, "$this$toV3");
        io.reactivex.rxjava3.core.Single<T> v3Single = RxJavaBridge.toV3Single(single);
        Intrinsics.checkNotNullExpressionValue(v3Single, "RxJavaBridge.toV3Single(this)");
        return v3Single;
    }
}
