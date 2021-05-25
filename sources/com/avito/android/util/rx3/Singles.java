package com.avito.android.util.rx3;

import arrow.core.None;
import arrow.core.Option;
import arrow.core.Some;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.observers.TestObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001d\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\u00028\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a!\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\b\b\u0000\u0010\u0000*\u00020\u0004*\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006\u001a3\u0010\u000b\u001a\u00020\n\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b0\u0007H\u0007¢\u0006\u0004\b\u000b\u0010\f\u001a\u0017\u0010\r\u001a\u00020\n*\u0006\u0012\u0002\b\u00030\u0001H\u0007¢\u0006\u0004\b\r\u0010\u000e\u001a+\u0010\u0011\u001a\u00020\n\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u001d\u0010\u0013\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u0013\u0010\u0014\u001a1\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u0015¢\u0006\u0004\b\u0017\u0010\u0018\u001ae\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00020\u0001\"\u0004\b\u0000\u0010\u0019\"\u0004\b\u0001\u0010\u001a\"\u0004\b\u0002\u0010\u001b*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00010\u00152\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00010\u00012\u001a\b\u0004\u0010\u001e\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u001dH\bø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 \u001aO\u0010\u001f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010!0\u0001\"\u0004\b\u0000\u0010\u0019\"\u0004\b\u0001\u0010\u001a*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00010\u00152\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001H\bø\u0001\u0000¢\u0006\u0004\b\u001f\u0010\"\u001ag\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u001b*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000#0\u00012\u0014\b\u0004\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00010\u00152\u001a\b\u0004\u0010%\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00010\u0007H\bø\u0001\u0000¢\u0006\u0004\b&\u0010'\u001aO\u0010)\u001a\u00020(\"\u0004\b\u0000\u0010\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000#0\u00012\u000e\b\u0004\u0010$\u001a\b\u0012\u0004\u0012\u00020(0\u00152\u0014\b\u0004\u0010%\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020(0\u0007H\bø\u0001\u0000¢\u0006\u0004\b)\u0010*\u001ag\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00010+\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u001b*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000#0\u00012\u0014\b\u0004\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010+0\u00152\u001a\b\u0004\u0010%\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010+0\u0007H\bø\u0001\u0000¢\u0006\u0004\b,\u0010-\u001a[\u0010.\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u001b*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000#0\u00012\u000e\b\u0004\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00010\u00152\u0014\b\u0004\u0010%\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007H\bø\u0001\u0000¢\u0006\u0004\b.\u0010'\u0002\u0007\n\u0005\b20\u0001¨\u0006/"}, d2 = {"T", "Lio/reactivex/rxjava3/core/Single;", "toSingle", "(Ljava/lang/Object;)Lio/reactivex/rxjava3/core/Single;", "", "", "(Ljava/lang/Throwable;)Lio/reactivex/rxjava3/core/Single;", "Lkotlin/Function1;", "", "onNext", "Lio/reactivex/rxjava3/disposables/Disposable;", "subscribeOnNext", "(Lio/reactivex/rxjava3/core/Single;Lkotlin/jvm/functions/Function1;)Lio/reactivex/rxjava3/disposables/Disposable;", "subscribeIgnoreResult", "(Lio/reactivex/rxjava3/core/Single;)Lio/reactivex/rxjava3/disposables/Disposable;", "Lio/reactivex/rxjava3/observers/TestObserver;", "subscriber", "immediatelyOn", "(Lio/reactivex/rxjava3/core/Single;Lio/reactivex/rxjava3/observers/TestObserver;)Lio/reactivex/rxjava3/disposables/Disposable;", "executeImmediately", "(Lio/reactivex/rxjava3/core/Single;)Ljava/lang/Object;", "Lkotlin/Function0;", "onTerminate", "doOnTerminate", "(Lio/reactivex/rxjava3/core/Single;Lkotlin/jvm/functions/Function0;)Lio/reactivex/rxjava3/core/Single;", "T1", "T2", "R", "other", "Lkotlin/Function2;", "zipFunction", "reverseZipWith", "(Lkotlin/jvm/functions/Function0;Lio/reactivex/rxjava3/core/Single;Lkotlin/jvm/functions/Function2;)Lio/reactivex/rxjava3/core/Single;", "Lkotlin/Pair;", "(Lkotlin/jvm/functions/Function0;Lio/reactivex/rxjava3/core/Single;)Lio/reactivex/rxjava3/core/Single;", "Larrow/core/Option;", "ifEmpty", "some", "flatMapFold", "(Lio/reactivex/rxjava3/core/Single;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)Lio/reactivex/rxjava3/core/Single;", "Lio/reactivex/rxjava3/core/Completable;", "flatMapCompletableFold", "(Lio/reactivex/rxjava3/core/Single;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)Lio/reactivex/rxjava3/core/Completable;", "Lio/reactivex/rxjava3/core/Maybe;", "flatMapMaybeFold", "(Lio/reactivex/rxjava3/core/Single;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)Lio/reactivex/rxjava3/core/Maybe;", "mapFold", "rx"}, k = 2, mv = {1, 4, 2})
@JvmName(name = "Singles")
public final class Singles {

    public static final class a<T> implements Consumer<T> {
        public final /* synthetic */ Function0 a;

        public a(Function0 function0) {
            this.a = function0;
        }

        @Override // io.reactivex.rxjava3.functions.Consumer
        public final void accept(T t) {
            this.a.invoke();
        }
    }

    public static final class b<T> implements Consumer<Throwable> {
        public final /* synthetic */ Function0 a;

        public b(Function0 function0) {
            this.a = function0;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            this.a.invoke();
        }
    }

    public static final class c<T> implements Consumer<Object> {
        public static final c a = new c();

        @Override // io.reactivex.rxjava3.functions.Consumer
        public final void accept(Object obj) {
        }
    }

    @NotNull
    public static final <T> Single<T> doOnTerminate(@NotNull Single<T> single, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(single, "$this$doOnTerminate");
        Intrinsics.checkNotNullParameter(function0, "onTerminate");
        Single<T> doOnError = single.doOnSuccess(new a(function0)).doOnError(new b(function0));
        Intrinsics.checkNotNullExpressionValue(doOnError, "this\n    .doOnSuccess { …OnError { onTerminate() }");
        return doOnError;
    }

    public static final <T> T executeImmediately(@NotNull Single<T> single) {
        Intrinsics.checkNotNullParameter(single, "$this$executeImmediately");
        return single.subscribeOn(Schedulers.trampoline()).observeOn(Schedulers.trampoline()).blockingGet();
    }

    @NotNull
    public static final <T> Completable flatMapCompletableFold(@NotNull Single<Option<T>> single, @NotNull Function0<? extends Completable> function0, @NotNull Function1<? super T, ? extends Completable> function1) {
        Intrinsics.checkNotNullParameter(single, "$this$flatMapCompletableFold");
        Intrinsics.checkNotNullParameter(function0, "ifEmpty");
        Intrinsics.checkNotNullParameter(function1, "some");
        Completable flatMapCompletable = single.flatMapCompletable(new Function<Option<? extends T>, CompletableSource>(function0, function1) { // from class: com.avito.android.util.rx3.Singles$flatMapCompletableFold$1
            public final /* synthetic */ Function0 a;
            public final /* synthetic */ Function1 b;

            {
                this.a = r1;
                this.b = r2;
            }

            public final CompletableSource apply(Option<? extends T> option) {
                Object obj;
                if (option instanceof None) {
                    obj = this.a.invoke();
                } else if (option instanceof Some) {
                    obj = this.b.invoke(((Some) option).getT());
                } else {
                    throw new NoWhenBranchMatchedException();
                }
                return (CompletableSource) obj;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // io.reactivex.rxjava3.functions.Function
            public /* bridge */ /* synthetic */ CompletableSource apply(Object obj) {
                return apply((Option) ((Option) obj));
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMapCompletable, "flatMapCompletable { it.fold(ifEmpty, some) }");
        return flatMapCompletable;
    }

    @NotNull
    public static final <T, R> Single<R> flatMapFold(@NotNull Single<Option<T>> single, @NotNull Function0<? extends Single<R>> function0, @NotNull Function1<? super T, ? extends Single<R>> function1) {
        Intrinsics.checkNotNullParameter(single, "$this$flatMapFold");
        Intrinsics.checkNotNullParameter(function0, "ifEmpty");
        Intrinsics.checkNotNullParameter(function1, "some");
        Single<R> flatMap = single.flatMap(new Function<Option<? extends T>, SingleSource<? extends R>>(function0, function1) { // from class: com.avito.android.util.rx3.Singles$flatMapFold$1
            public final /* synthetic */ Function0 a;
            public final /* synthetic */ Function1 b;

            {
                this.a = r1;
                this.b = r2;
            }

            public final SingleSource<? extends R> apply(Option<? extends T> option) {
                Object obj;
                if (option instanceof None) {
                    obj = this.a.invoke();
                } else if (option instanceof Some) {
                    obj = this.b.invoke(((Some) option).getT());
                } else {
                    throw new NoWhenBranchMatchedException();
                }
                return (SingleSource) obj;
            }

            @Override // io.reactivex.rxjava3.functions.Function
            public /* bridge */ /* synthetic */ Object apply(Object obj) {
                return apply((Option) ((Option) obj));
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "flatMap { it.fold(ifEmpty, some) }");
        return flatMap;
    }

    @NotNull
    public static final <T, R> Maybe<R> flatMapMaybeFold(@NotNull Single<Option<T>> single, @NotNull Function0<? extends Maybe<R>> function0, @NotNull Function1<? super T, ? extends Maybe<R>> function1) {
        Intrinsics.checkNotNullParameter(single, "$this$flatMapMaybeFold");
        Intrinsics.checkNotNullParameter(function0, "ifEmpty");
        Intrinsics.checkNotNullParameter(function1, "some");
        Maybe<R> flatMapMaybe = single.flatMapMaybe(new Function<Option<? extends T>, MaybeSource<? extends R>>(function0, function1) { // from class: com.avito.android.util.rx3.Singles$flatMapMaybeFold$1
            public final /* synthetic */ Function0 a;
            public final /* synthetic */ Function1 b;

            {
                this.a = r1;
                this.b = r2;
            }

            public final MaybeSource<? extends R> apply(Option<? extends T> option) {
                Object obj;
                if (option instanceof None) {
                    obj = this.a.invoke();
                } else if (option instanceof Some) {
                    obj = this.b.invoke(((Some) option).getT());
                } else {
                    throw new NoWhenBranchMatchedException();
                }
                return (MaybeSource) obj;
            }

            @Override // io.reactivex.rxjava3.functions.Function
            public /* bridge */ /* synthetic */ Object apply(Object obj) {
                return apply((Option) ((Option) obj));
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMapMaybe, "flatMapMaybe { it.fold(ifEmpty, some) }");
        return flatMapMaybe;
    }

    @NotNull
    public static final <T> Disposable immediatelyOn(@NotNull Single<T> single, @NotNull TestObserver<T> testObserver) {
        Intrinsics.checkNotNullParameter(single, "$this$immediatelyOn");
        Intrinsics.checkNotNullParameter(testObserver, "subscriber");
        SingleObserver subscribeWith = single.subscribeOn(Schedulers.trampoline()).observeOn(Schedulers.trampoline()).subscribeWith(testObserver);
        Intrinsics.checkNotNullExpressionValue(subscribeWith, "subscribeOn(Schedulers.t…subscribeWith(subscriber)");
        return (Disposable) subscribeWith;
    }

    @NotNull
    public static final <T, R> Single<R> mapFold(@NotNull Single<Option<T>> single, @NotNull Function0<? extends R> function0, @NotNull Function1<? super T, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(single, "$this$mapFold");
        Intrinsics.checkNotNullParameter(function0, "ifEmpty");
        Intrinsics.checkNotNullParameter(function1, "some");
        Single<R> map = single.map(new Function<Option<? extends T>, R>(function0, function1) { // from class: com.avito.android.util.rx3.Singles$mapFold$1
            public final /* synthetic */ Function0 a;
            public final /* synthetic */ Function1 b;

            {
                this.a = r1;
                this.b = r2;
            }

            public final R apply(Option<? extends T> option) {
                if (option instanceof None) {
                    return (R) this.a.invoke();
                }
                if (option instanceof Some) {
                    return (R) this.b.invoke(((Some) option).getT());
                }
                throw new NoWhenBranchMatchedException();
            }

            @Override // io.reactivex.rxjava3.functions.Function
            public /* bridge */ /* synthetic */ Object apply(Object obj) {
                return apply((Option) ((Option) obj));
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "map { it.fold(ifEmpty, some) }");
        return map;
    }

    @NotNull
    public static final <T1, T2, R> Single<R> reverseZipWith(@NotNull Function0<? extends Single<T1>> function0, @NotNull Single<T2> single, @NotNull Function2<? super T1, ? super T2, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(function0, "$this$reverseZipWith");
        Intrinsics.checkNotNullParameter(single, "other");
        Intrinsics.checkNotNullParameter(function2, "zipFunction");
        Single<R> zip = Single.zip(single, (SingleSource) function0.invoke(), new BiFunction<T2, T1, R>(function2) { // from class: com.avito.android.util.rx3.Singles$reverseZipWith$1
            public final /* synthetic */ Function2 a;

            {
                this.a = r1;
            }

            @Override // io.reactivex.rxjava3.functions.BiFunction
            public final R apply(T2 t2, T1 t1) {
                return (R) this.a.invoke(t1, t2);
            }
        });
        Intrinsics.checkNotNullExpressionValue(zip, "Single.zip(\n        othe…pFunction(t1, t2) }\n    )");
        return zip;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [a2.a.a.n3.z.l] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @kotlin.Deprecated(message = "Use your own custom onError handler")
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final io.reactivex.rxjava3.disposables.Disposable subscribeIgnoreResult(@org.jetbrains.annotations.NotNull io.reactivex.rxjava3.core.Single<?> r3) {
        /*
            java.lang.String r0 = "$this$subscribeIgnoreResult"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            com.avito.android.util.rx3.Singles$c r0 = com.avito.android.util.rx3.Singles.c.a
            com.avito.android.util.rx3.Singles$d r1 = com.avito.android.util.rx3.Singles.d.a
            if (r1 == 0) goto L_0x0011
            a2.a.a.n3.z.l r2 = new a2.a.a.n3.z.l
            r2.<init>(r1)
            r1 = r2
        L_0x0011:
            io.reactivex.rxjava3.functions.Consumer r1 = (io.reactivex.rxjava3.functions.Consumer) r1
            io.reactivex.rxjava3.disposables.Disposable r3 = r3.subscribe(r0, r1)
            java.lang.String r0 = "subscribe({}, ::noOpErrorHandler)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r0)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.util.rx3.Singles.subscribeIgnoreResult(io.reactivex.rxjava3.core.Single):io.reactivex.rxjava3.disposables.Disposable");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [a2.a.a.n3.z.l] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @kotlin.Deprecated(message = "Use your own custom onError handler")
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> io.reactivex.rxjava3.disposables.Disposable subscribeOnNext(@org.jetbrains.annotations.NotNull io.reactivex.rxjava3.core.Single<T> r2, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super T, kotlin.Unit> r3) {
        /*
            java.lang.String r0 = "$this$subscribeOnNext"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "onNext"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            a2.a.a.n3.z.l r0 = new a2.a.a.n3.z.l
            r0.<init>(r3)
            com.avito.android.util.rx3.Singles$e r3 = com.avito.android.util.rx3.Singles.e.a
            if (r3 == 0) goto L_0x0019
            a2.a.a.n3.z.l r1 = new a2.a.a.n3.z.l
            r1.<init>(r3)
            r3 = r1
        L_0x0019:
            io.reactivex.rxjava3.functions.Consumer r3 = (io.reactivex.rxjava3.functions.Consumer) r3
            io.reactivex.rxjava3.disposables.Disposable r2 = r2.subscribe(r0, r3)
            java.lang.String r3 = "subscribe(onNext, ::noOpErrorHandler)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.util.rx3.Singles.subscribeOnNext(io.reactivex.rxjava3.core.Single, kotlin.jvm.functions.Function1):io.reactivex.rxjava3.disposables.Disposable");
    }

    @NotNull
    public static final <T> Single<T> toSingle(T t) {
        Single<T> just = Single.just(t);
        Intrinsics.checkNotNullExpressionValue(just, "Single.just(this)");
        return just;
    }

    @NotNull
    public static final <T> Single<T> toSingle(@NotNull Throwable th) {
        Intrinsics.checkNotNullParameter(th, "$this$toSingle");
        Single<T> error = Single.error(th);
        Intrinsics.checkNotNullExpressionValue(error, "Single.error(this)");
        return error;
    }

    @NotNull
    public static final <T1, T2> Single<Pair<T1, T2>> reverseZipWith(@NotNull Function0<? extends Single<T1>> function0, @NotNull Single<T2> single) {
        Intrinsics.checkNotNullParameter(function0, "$this$reverseZipWith");
        Intrinsics.checkNotNullParameter(single, "other");
        Single<Pair<T1, T2>> zip = Single.zip(single, (SingleSource) function0.invoke(), Singles$reverseZipWith$2.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(zip, "Single.zip(\n        othe…2, t1 -> t1 to t2 }\n    )");
        return zip;
    }
}
