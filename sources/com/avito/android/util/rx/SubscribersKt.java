package com.avito.android.util.rx;

import io.reactivex.Flowable;
import io.reactivex.subscribers.DisposableSubscriber;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.reactivestreams.Subscriber;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a/\u0010\u0005\u001a\u00020\u0002*\u0012\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000j\u0002`\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\bø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a§\u0001\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011\"\b\b\u0000\u0010\b*\u00020\u00072)\b\u0004\u0010\n\u001a#\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000j\u0002`\u0003\u0012\u0004\u0012\u00020\u00020\u0000¢\u0006\u0002\b\t2/\b\u0004\u0010\f\u001a)\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000j\u0002`\u0003\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00020\u000b¢\u0006\u0002\b\t2\u000e\b\u0006\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\r2\u0016\b\u0006\u0010\u0010\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0004\u0012\u00020\u00020\u0000H\bø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a|\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011\"\b\b\u0000\u0010\b*\u00020\u00072/\b\u0004\u0010\f\u001a)\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000j\u0002`\u0003\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00020\u000b¢\u0006\u0002\b\t2\u000e\b\u0006\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\r2\u0016\b\u0006\u0010\u0010\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0004\u0012\u00020\u00020\u0000H\bø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0014\u001a±\u0001\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011\"\b\b\u0000\u0010\b*\u00020\u0007*\b\u0012\u0004\u0012\u00028\u00000\u00152)\b\u0004\u0010\n\u001a#\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000j\u0002`\u0003\u0012\u0004\u0012\u00020\u00020\u0000¢\u0006\u0002\b\t2/\b\u0004\u0010\f\u001a)\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000j\u0002`\u0003\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00020\u000b¢\u0006\u0002\b\t2\u000e\b\u0006\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\r2\u0016\b\u0006\u0010\u0010\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0004\u0012\u00020\u00020\u0000H\bø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u0001\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011\"\b\b\u0000\u0010\b*\u00020\u0007*\b\u0012\u0004\u0012\u00028\u00000\u00152/\b\u0004\u0010\f\u001a)\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000j\u0002`\u0003\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00020\u000b¢\u0006\u0002\b\t2\u000e\b\u0006\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\r2\u0016\b\u0006\u0010\u0010\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0004\u0012\u00020\u00020\u0000H\bø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0018*\"\u0010\u0019\"\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u00002\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000\u0002\u0007\n\u0005\b20\u0001¨\u0006\u001a"}, d2 = {"Lkotlin/Function1;", "", "", "Lcom/avito/android/util/rx/RequestFun;", "n", "request", "(Lkotlin/jvm/functions/Function1;J)V", "", "T", "Lkotlin/ExtensionFunctionType;", "onStart", "Lkotlin/Function2;", "onNext", "Lkotlin/Function0;", "onComplete", "", "onError", "Lio/reactivex/subscribers/DisposableSubscriber;", "createDisposableSubscriber", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)Lio/reactivex/subscribers/DisposableSubscriber;", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)Lio/reactivex/subscribers/DisposableSubscriber;", "Lio/reactivex/Flowable;", "subscribeWithDisposableSubscriber", "(Lio/reactivex/Flowable;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)Lio/reactivex/subscribers/DisposableSubscriber;", "(Lio/reactivex/Flowable;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)Lio/reactivex/subscribers/DisposableSubscriber;", "RequestFun", "rx"}, k = 2, mv = {1, 4, 2})
public final class SubscribersKt {
    @NotNull
    public static final <T> DisposableSubscriber<T> createDisposableSubscriber(@NotNull Function1<? super Function1<? super Long, Unit>, Unit> function1, @NotNull Function2<? super Function1<? super Long, Unit>, ? super T, Unit> function2, @NotNull Function0<Unit> function0, @NotNull Function1<? super Throwable, Unit> function12) {
        Intrinsics.checkNotNullParameter(function1, "onStart");
        Intrinsics.checkNotNullParameter(function2, "onNext");
        Intrinsics.checkNotNullParameter(function0, "onComplete");
        Intrinsics.checkNotNullParameter(function12, "onError");
        return new SubscribersKt$createDisposableSubscriber$3(function2, function0, function12, function1);
    }

    public static /* synthetic */ DisposableSubscriber createDisposableSubscriber$default(Function1 function1, Function2 function2, Function0 function0, Function1 function12, int i, Object obj) {
        if ((i & 4) != 0) {
            function0 = SubscribersKt$createDisposableSubscriber$1.INSTANCE;
        }
        if ((i & 8) != 0) {
            function12 = SubscribersKt$createDisposableSubscriber$2.INSTANCE;
        }
        Intrinsics.checkNotNullParameter(function1, "onStart");
        Intrinsics.checkNotNullParameter(function2, "onNext");
        Intrinsics.checkNotNullParameter(function0, "onComplete");
        Intrinsics.checkNotNullParameter(function12, "onError");
        return new SubscribersKt$createDisposableSubscriber$3(function2, function0, function12, function1);
    }

    public static final void request(@NotNull Function1<? super Long, Unit> function1, long j) {
        Intrinsics.checkNotNullParameter(function1, "$this$request");
        function1.invoke(Long.valueOf(j));
    }

    @NotNull
    public static final <T> DisposableSubscriber<T> subscribeWithDisposableSubscriber(@NotNull Flowable<T> flowable, @NotNull Function1<? super Function1<? super Long, Unit>, Unit> function1, @NotNull Function2<? super Function1<? super Long, Unit>, ? super T, Unit> function2, @NotNull Function0<Unit> function0, @NotNull Function1<? super Throwable, Unit> function12) {
        Intrinsics.checkNotNullParameter(flowable, "$this$subscribeWithDisposableSubscriber");
        Intrinsics.checkNotNullParameter(function1, "onStart");
        Intrinsics.checkNotNullParameter(function2, "onNext");
        Intrinsics.checkNotNullParameter(function0, "onComplete");
        Intrinsics.checkNotNullParameter(function12, "onError");
        Subscriber subscribeWith = flowable.subscribeWith(new SubscribersKt$createDisposableSubscriber$3(function2, function0, function12, function1));
        Intrinsics.checkNotNullExpressionValue(subscribeWith, "subscribeWith(\n        c…nComplete, onError)\n    )");
        return (DisposableSubscriber) subscribeWith;
    }

    public static /* synthetic */ DisposableSubscriber subscribeWithDisposableSubscriber$default(Flowable flowable, Function1 function1, Function2 function2, Function0 function0, Function1 function12, int i, Object obj) {
        if ((i & 4) != 0) {
            function0 = SubscribersKt$subscribeWithDisposableSubscriber$1.INSTANCE;
        }
        if ((i & 8) != 0) {
            function12 = SubscribersKt$subscribeWithDisposableSubscriber$2.INSTANCE;
        }
        Intrinsics.checkNotNullParameter(flowable, "$this$subscribeWithDisposableSubscriber");
        Intrinsics.checkNotNullParameter(function1, "onStart");
        Intrinsics.checkNotNullParameter(function2, "onNext");
        Intrinsics.checkNotNullParameter(function0, "onComplete");
        Intrinsics.checkNotNullParameter(function12, "onError");
        Subscriber subscribeWith = flowable.subscribeWith(new SubscribersKt$createDisposableSubscriber$3(function2, function0, function12, function1));
        Intrinsics.checkNotNullExpressionValue(subscribeWith, "subscribeWith(\n        c…nComplete, onError)\n    )");
        return (DisposableSubscriber) subscribeWith;
    }

    @NotNull
    public static final <T> DisposableSubscriber<T> createDisposableSubscriber(@NotNull Function2<? super Function1<? super Long, Unit>, ? super T, Unit> function2, @NotNull Function0<Unit> function0, @NotNull Function1<? super Throwable, Unit> function1) {
        Intrinsics.checkNotNullParameter(function2, "onNext");
        Intrinsics.checkNotNullParameter(function0, "onComplete");
        Intrinsics.checkNotNullParameter(function1, "onError");
        return new SubscribersKt$createDisposableSubscriber$6(function2, function0, function1);
    }

    @NotNull
    public static final <T> DisposableSubscriber<T> subscribeWithDisposableSubscriber(@NotNull Flowable<T> flowable, @NotNull Function2<? super Function1<? super Long, Unit>, ? super T, Unit> function2, @NotNull Function0<Unit> function0, @NotNull Function1<? super Throwable, Unit> function1) {
        Intrinsics.checkNotNullParameter(flowable, "$this$subscribeWithDisposableSubscriber");
        Intrinsics.checkNotNullParameter(function2, "onNext");
        Intrinsics.checkNotNullParameter(function0, "onComplete");
        Intrinsics.checkNotNullParameter(function1, "onError");
        Subscriber subscribeWith = flowable.subscribeWith(new SubscribersKt$createDisposableSubscriber$6(function2, function0, function1));
        Intrinsics.checkNotNullExpressionValue(subscribeWith, "subscribeWith(\n        c…nComplete, onError)\n    )");
        return (DisposableSubscriber) subscribeWith;
    }

    public static /* synthetic */ DisposableSubscriber createDisposableSubscriber$default(Function2 function2, Function0 function0, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function0 = SubscribersKt$createDisposableSubscriber$4.INSTANCE;
        }
        if ((i & 4) != 0) {
            function1 = SubscribersKt$createDisposableSubscriber$5.INSTANCE;
        }
        Intrinsics.checkNotNullParameter(function2, "onNext");
        Intrinsics.checkNotNullParameter(function0, "onComplete");
        Intrinsics.checkNotNullParameter(function1, "onError");
        return new SubscribersKt$createDisposableSubscriber$6(function2, function0, function1);
    }

    public static /* synthetic */ DisposableSubscriber subscribeWithDisposableSubscriber$default(Flowable flowable, Function2 function2, Function0 function0, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function0 = SubscribersKt$subscribeWithDisposableSubscriber$3.INSTANCE;
        }
        if ((i & 4) != 0) {
            function1 = SubscribersKt$subscribeWithDisposableSubscriber$4.INSTANCE;
        }
        Intrinsics.checkNotNullParameter(flowable, "$this$subscribeWithDisposableSubscriber");
        Intrinsics.checkNotNullParameter(function2, "onNext");
        Intrinsics.checkNotNullParameter(function0, "onComplete");
        Intrinsics.checkNotNullParameter(function1, "onError");
        Subscriber subscribeWith = flowable.subscribeWith(new SubscribersKt$createDisposableSubscriber$6(function2, function0, function1));
        Intrinsics.checkNotNullExpressionValue(subscribeWith, "subscribeWith(\n        c…nComplete, onError)\n    )");
        return (DisposableSubscriber) subscribeWith;
    }
}
