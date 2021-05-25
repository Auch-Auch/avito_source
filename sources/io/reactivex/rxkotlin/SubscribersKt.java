package io.reactivex.rxkotlin;

import com.avito.android.remote.auth.AuthSource;
import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.annotations.BackpressureKind;
import io.reactivex.annotations.BackpressureSupport;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.SchedulerSupport;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import s6.a.f.d;
import s6.a.f.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u001a/\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00030\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006\u001a%\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00030\u0002H\u0002¢\u0006\u0004\b\b\u0010\u0006\u001a\u0019\u0010\u000b\u001a\u00020\n*\b\u0012\u0004\u0012\u00020\u00030\tH\u0002¢\u0006\u0004\b\u000b\u0010\f\u001a_\u0010\u0012\u001a\u00020\u0011\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\r2\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00030\u00022\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\u0014\b\u0002\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\u0012\u0010\u0013\u001a_\u0010\u0012\u001a\u00020\u0011\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00142\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00030\u00022\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\u0014\b\u0002\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\u0012\u0010\u0015\u001aO\u0010\u0012\u001a\u00020\u0011\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00162\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00030\u00022\u0014\b\u0002\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\u0012\u0010\u0018\u001a_\u0010\u0012\u001a\u00020\u0011\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00192\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00030\u00022\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\u0014\b\u0002\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\u0012\u0010\u001a\u001a9\u0010\u0012\u001a\u00020\u0011*\u00020\u001b2\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00030\u00022\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\tH\u0007¢\u0006\u0004\b\u0012\u0010\u001c\u001a_\u0010\u001d\u001a\u00020\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\r2\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00030\u00022\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\u0014\b\u0002\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\u001d\u0010\u001e\u001a_\u0010\u001d\u001a\u00020\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00142\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00030\u00022\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\u0014\b\u0002\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\u001d\u0010\u001f\"\"\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00030\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010 \"\u001c\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00030\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\"\"\"\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00030\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010 ¨\u0006%"}, d2 = {"", "T", "Lkotlin/Function1;", "", "Lio/reactivex/functions/Consumer;", AuthSource.SEND_ABUSE, "(Lkotlin/jvm/functions/Function1;)Lio/reactivex/functions/Consumer;", "", "c", "Lkotlin/Function0;", "Lio/reactivex/functions/Action;", AuthSource.BOOKING_ORDER, "(Lkotlin/jvm/functions/Function0;)Lio/reactivex/functions/Action;", "Lio/reactivex/Observable;", "onError", "onComplete", "onNext", "Lio/reactivex/disposables/Disposable;", "subscribeBy", "(Lio/reactivex/Observable;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)Lio/reactivex/disposables/Disposable;", "Lio/reactivex/Flowable;", "(Lio/reactivex/Flowable;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)Lio/reactivex/disposables/Disposable;", "Lio/reactivex/Single;", "onSuccess", "(Lio/reactivex/Single;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Lio/reactivex/disposables/Disposable;", "Lio/reactivex/Maybe;", "(Lio/reactivex/Maybe;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)Lio/reactivex/disposables/Disposable;", "Lio/reactivex/Completable;", "(Lio/reactivex/Completable;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)Lio/reactivex/disposables/Disposable;", "blockingSubscribeBy", "(Lio/reactivex/Observable;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "(Lio/reactivex/Flowable;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "Lkotlin/jvm/functions/Function1;", "onErrorStub", "Lkotlin/jvm/functions/Function0;", "onCompleteStub", "onNextStub", "rxkotlin"}, k = 2, mv = {1, 4, 0})
public final class SubscribersKt {
    public static final Function1<Object, Unit> a = c.a;
    public static final Function1<Throwable, Unit> b = b.a;
    public static final Function0<Unit> c = a.a;

    public static final class a extends Lambda implements Function0<Unit> {
        public static final a a = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function1<Throwable, Unit> {
        public static final b a = new b();

        public b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Throwable th) {
            Intrinsics.checkParameterIsNotNull(th, "it");
            return Unit.INSTANCE;
        }
    }

    public static final class c extends Lambda implements Function1<Object, Unit> {
        public static final c a = new c();

        public c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Object obj) {
            Intrinsics.checkParameterIsNotNull(obj, "it");
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [s6.a.f.e] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> io.reactivex.functions.Consumer<T> a(@org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super T, kotlin.Unit> r1) {
        /*
            kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> r0 = io.reactivex.rxkotlin.SubscribersKt.a
            if (r1 != r0) goto L_0x000e
            io.reactivex.functions.Consumer r1 = io.reactivex.internal.functions.Functions.emptyConsumer()
            java.lang.String r0 = "Functions.emptyConsumer()"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r0)
            goto L_0x0018
        L_0x000e:
            if (r1 == 0) goto L_0x0016
            s6.a.f.e r0 = new s6.a.f.e
            r0.<init>(r1)
            r1 = r0
        L_0x0016:
            io.reactivex.functions.Consumer r1 = (io.reactivex.functions.Consumer) r1
        L_0x0018:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxkotlin.SubscribersKt.a(kotlin.jvm.functions.Function1):io.reactivex.functions.Consumer");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [s6.a.f.d] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final io.reactivex.functions.Action b(@org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function0<kotlin.Unit> r1) {
        /*
            kotlin.jvm.functions.Function0<kotlin.Unit> r0 = io.reactivex.rxkotlin.SubscribersKt.c
            if (r1 != r0) goto L_0x000c
            io.reactivex.functions.Action r1 = io.reactivex.internal.functions.Functions.EMPTY_ACTION
            java.lang.String r0 = "Functions.EMPTY_ACTION"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r0)
            goto L_0x0016
        L_0x000c:
            if (r1 == 0) goto L_0x0014
            s6.a.f.d r0 = new s6.a.f.d
            r0.<init>(r1)
            r1 = r0
        L_0x0014:
            io.reactivex.functions.Action r1 = (io.reactivex.functions.Action) r1
        L_0x0016:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxkotlin.SubscribersKt.b(kotlin.jvm.functions.Function0):io.reactivex.functions.Action");
    }

    @SchedulerSupport("none")
    public static final <T> void blockingSubscribeBy(@NotNull Observable<T> observable, @NotNull Function1<? super Throwable, Unit> function1, @NotNull Function0<Unit> function0, @NotNull Function1<? super T, Unit> function12) {
        Intrinsics.checkParameterIsNotNull(observable, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "onError");
        Intrinsics.checkParameterIsNotNull(function0, "onComplete");
        Intrinsics.checkParameterIsNotNull(function12, "onNext");
        observable.blockingSubscribe(a(function12), c(function1), b(function0));
    }

    @SchedulerSupport("none")
    public static /* bridge */ /* synthetic */ void blockingSubscribeBy$default(Observable observable, Function1 function1, Function0 function0, Function1 function12, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = b;
        }
        if ((i & 2) != 0) {
            function0 = c;
        }
        if ((i & 4) != 0) {
            function12 = a;
        }
        blockingSubscribeBy(observable, function1, function0, function12);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [s6.a.f.e] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final io.reactivex.functions.Consumer<java.lang.Throwable> c(@org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Throwable, kotlin.Unit> r1) {
        /*
            kotlin.jvm.functions.Function1<java.lang.Throwable, kotlin.Unit> r0 = io.reactivex.rxkotlin.SubscribersKt.b
            if (r1 != r0) goto L_0x000c
            io.reactivex.functions.Consumer<java.lang.Throwable> r1 = io.reactivex.internal.functions.Functions.ON_ERROR_MISSING
            java.lang.String r0 = "Functions.ON_ERROR_MISSING"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r0)
            goto L_0x0016
        L_0x000c:
            if (r1 == 0) goto L_0x0014
            s6.a.f.e r0 = new s6.a.f.e
            r0.<init>(r1)
            r1 = r0
        L_0x0014:
            io.reactivex.functions.Consumer r1 = (io.reactivex.functions.Consumer) r1
        L_0x0016:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxkotlin.SubscribersKt.c(kotlin.jvm.functions.Function1):io.reactivex.functions.Consumer");
    }

    @NotNull
    @SchedulerSupport("none")
    @CheckReturnValue
    public static final <T> Disposable subscribeBy(@NotNull Observable<T> observable, @NotNull Function1<? super Throwable, Unit> function1, @NotNull Function0<Unit> function0, @NotNull Function1<? super T, Unit> function12) {
        Intrinsics.checkParameterIsNotNull(observable, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "onError");
        Intrinsics.checkParameterIsNotNull(function0, "onComplete");
        Intrinsics.checkParameterIsNotNull(function12, "onNext");
        Disposable subscribe = observable.subscribe(a(function12), c(function1), b(function0));
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "subscribe(onNext.asConsu…ete.asOnCompleteAction())");
        return subscribe;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    @NotNull
    public static /* bridge */ /* synthetic */ Disposable subscribeBy$default(Observable observable, Function1 function1, Function0 function0, Function1 function12, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = b;
        }
        if ((i & 2) != 0) {
            function0 = c;
        }
        if ((i & 4) != 0) {
            function12 = a;
        }
        return subscribeBy(observable, function1, function0, function12);
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    public static final <T> void blockingSubscribeBy(@NotNull Flowable<T> flowable, @NotNull Function1<? super Throwable, Unit> function1, @NotNull Function0<Unit> function0, @NotNull Function1<? super T, Unit> function12) {
        Intrinsics.checkParameterIsNotNull(flowable, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "onError");
        Intrinsics.checkParameterIsNotNull(function0, "onComplete");
        Intrinsics.checkParameterIsNotNull(function12, "onNext");
        flowable.blockingSubscribe(a(function12), c(function1), b(function0));
    }

    @NotNull
    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public static final <T> Disposable subscribeBy(@NotNull Flowable<T> flowable, @NotNull Function1<? super Throwable, Unit> function1, @NotNull Function0<Unit> function0, @NotNull Function1<? super T, Unit> function12) {
        Intrinsics.checkParameterIsNotNull(flowable, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "onError");
        Intrinsics.checkParameterIsNotNull(function0, "onComplete");
        Intrinsics.checkParameterIsNotNull(function12, "onNext");
        Disposable subscribe = flowable.subscribe(a(function12), c(function1), b(function0));
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "subscribe(onNext.asConsu…ete.asOnCompleteAction())");
        return subscribe;
    }

    @NotNull
    @SchedulerSupport("none")
    @CheckReturnValue
    public static final <T> Disposable subscribeBy(@NotNull Single<T> single, @NotNull Function1<? super Throwable, Unit> function1, @NotNull Function1<? super T, Unit> function12) {
        Intrinsics.checkParameterIsNotNull(single, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "onError");
        Intrinsics.checkParameterIsNotNull(function12, "onSuccess");
        Disposable subscribe = single.subscribe(a(function12), c(function1));
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "subscribe(onSuccess.asCo…rror.asOnErrorConsumer())");
        return subscribe;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    public static /* bridge */ /* synthetic */ void blockingSubscribeBy$default(Flowable flowable, Function1 function1, Function0 function0, Function1 function12, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = b;
        }
        if ((i & 2) != 0) {
            function0 = c;
        }
        if ((i & 4) != 0) {
            function12 = a;
        }
        blockingSubscribeBy(flowable, function1, function0, function12);
    }

    @NotNull
    @SchedulerSupport("none")
    @CheckReturnValue
    public static final <T> Disposable subscribeBy(@NotNull Maybe<T> maybe, @NotNull Function1<? super Throwable, Unit> function1, @NotNull Function0<Unit> function0, @NotNull Function1<? super T, Unit> function12) {
        Intrinsics.checkParameterIsNotNull(maybe, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "onError");
        Intrinsics.checkParameterIsNotNull(function0, "onComplete");
        Intrinsics.checkParameterIsNotNull(function12, "onSuccess");
        Disposable subscribe = maybe.subscribe(a(function12), c(function1), b(function0));
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "subscribe(onSuccess.asCo…ete.asOnCompleteAction())");
        return subscribe;
    }

    @NotNull
    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public static /* bridge */ /* synthetic */ Disposable subscribeBy$default(Flowable flowable, Function1 function1, Function0 function0, Function1 function12, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = b;
        }
        if ((i & 2) != 0) {
            function0 = c;
        }
        if ((i & 4) != 0) {
            function12 = a;
        }
        return subscribeBy(flowable, function1, function0, function12);
    }

    @NotNull
    @SchedulerSupport("none")
    @CheckReturnValue
    public static final Disposable subscribeBy(@NotNull Completable completable, @NotNull Function1<? super Throwable, Unit> function1, @NotNull Function0<Unit> function0) {
        Intrinsics.checkParameterIsNotNull(completable, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "onError");
        Intrinsics.checkParameterIsNotNull(function0, "onComplete");
        Function1<Throwable, Unit> function12 = b;
        if (function1 == function12 && function0 == c) {
            Disposable subscribe = completable.subscribe();
            Intrinsics.checkExpressionValueIsNotNull(subscribe, "subscribe()");
            return subscribe;
        } else if (function1 == function12) {
            Disposable subscribe2 = completable.subscribe(new d(function0));
            Intrinsics.checkExpressionValueIsNotNull(subscribe2, "subscribe(onComplete)");
            return subscribe2;
        } else {
            Disposable subscribe3 = completable.subscribe(b(function0), new e(function1));
            Intrinsics.checkExpressionValueIsNotNull(subscribe3, "subscribe(onComplete.asO…ion(), Consumer(onError))");
            return subscribe3;
        }
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    @NotNull
    public static /* bridge */ /* synthetic */ Disposable subscribeBy$default(Single single, Function1 function1, Function1 function12, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = b;
        }
        if ((i & 2) != 0) {
            function12 = a;
        }
        return subscribeBy(single, function1, function12);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    @NotNull
    public static /* bridge */ /* synthetic */ Disposable subscribeBy$default(Maybe maybe, Function1 function1, Function0 function0, Function1 function12, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = b;
        }
        if ((i & 2) != 0) {
            function0 = c;
        }
        if ((i & 4) != 0) {
            function12 = a;
        }
        return subscribeBy(maybe, function1, function0, function12);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    @NotNull
    public static /* bridge */ /* synthetic */ Disposable subscribeBy$default(Completable completable, Function1 function1, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = b;
        }
        if ((i & 2) != 0) {
            function0 = c;
        }
        return subscribeBy(completable, function1, function0);
    }
}
