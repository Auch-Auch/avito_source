package com.avito.android.util.rx3;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.schedulers.Schedulers;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001c\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u001a\u001f\u0010\u0005\u001a\u00020\u0004*\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0011\u0010\u0007\u001a\u00020\u0004*\u00020\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a\u0011\u0010\t\u001a\u00020\u0004*\u00020\u0000¢\u0006\u0004\b\t\u0010\b\u001a9\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b\"\u0004\b\u0000\u0010\n*\u00020\u00002\u0014\b\u0004\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000b0\u0001H\bø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a\u001a\u0010\u0010\u001a\u00020\u0000*\b\u0012\u0004\u0012\u00020\u00000\u000fH\b¢\u0006\u0004\b\u0010\u0010\u0011\u001a)\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00122\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00000\u0001H\bø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0017"}, d2 = {"Lio/reactivex/rxjava3/core/Completable;", "Lkotlin/Function0;", "", "onNext", "Lio/reactivex/rxjava3/disposables/Disposable;", "subscribeOnNext", "(Lio/reactivex/rxjava3/core/Completable;Lkotlin/jvm/functions/Function0;)Lio/reactivex/rxjava3/disposables/Disposable;", "subscribeIgnoreResult", "(Lio/reactivex/rxjava3/core/Completable;)Lio/reactivex/rxjava3/disposables/Disposable;", "executeImmediately", "T", "Lio/reactivex/rxjava3/core/Single;", "singleFactory", "flatMapSingle", "(Lio/reactivex/rxjava3/core/Completable;Lkotlin/jvm/functions/Function0;)Lio/reactivex/rxjava3/core/Single;", "", "completableMerge", "(Ljava/lang/Iterable;)Lio/reactivex/rxjava3/core/Completable;", "", "condition", "completable", "completableIf", "(ZLkotlin/jvm/functions/Function0;)Lio/reactivex/rxjava3/core/Completable;", "rx"}, k = 2, mv = {1, 4, 2})
@JvmName(name = "Completables")
public final class Completables {

    public static final class a implements Action {
        public static final a a = new a();

        @Override // io.reactivex.rxjava3.functions.Action
        public final void run() {
        }
    }

    @NotNull
    public static final Completable completableIf(boolean z, @NotNull Function0<? extends Completable> function0) {
        Intrinsics.checkNotNullParameter(function0, "completable");
        if (z) {
            return (Completable) function0.invoke();
        }
        Completable complete = Completable.complete();
        Intrinsics.checkNotNullExpressionValue(complete, "Completable.complete()");
        return complete;
    }

    @NotNull
    public static final Completable completableMerge(@NotNull Iterable<? extends Completable> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "$this$completableMerge");
        Completable merge = Completable.merge(iterable);
        Intrinsics.checkNotNullExpressionValue(merge, "Completable.merge(this)");
        return merge;
    }

    @NotNull
    public static final Disposable executeImmediately(@NotNull Completable completable) {
        Intrinsics.checkNotNullParameter(completable, "$this$executeImmediately");
        Disposable subscribe = completable.subscribeOn(Schedulers.trampoline()).observeOn(Schedulers.trampoline()).subscribe();
        Intrinsics.checkNotNullExpressionValue(subscribe, "subscribeOn(Schedulers.t…e())\n        .subscribe()");
        return subscribe;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: io.reactivex.rxjava3.core.Completable */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <T> Single<T> flatMapSingle(@NotNull Completable completable, @NotNull Function0<? extends Single<T>> function0) {
        Intrinsics.checkNotNullParameter(completable, "$this$flatMapSingle");
        Intrinsics.checkNotNullParameter(function0, "singleFactory");
        Single<T> flatMap = completable.toSingleDefault(Unit.INSTANCE).flatMap(new Function<Unit, SingleSource<? extends T>>(function0) { // from class: com.avito.android.util.rx3.Completables$flatMapSingle$1
            public final /* synthetic */ Function0 a;

            {
                this.a = r1;
            }

            public final SingleSource<? extends T> apply(Unit unit) {
                return (SingleSource) this.a.invoke();
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "toSingleDefault(Unit).flatMap { singleFactory() }");
        return flatMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [a2.a.a.n3.z.b] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final io.reactivex.rxjava3.disposables.Disposable subscribeIgnoreResult(@org.jetbrains.annotations.NotNull io.reactivex.rxjava3.core.Completable r3) {
        /*
            java.lang.String r0 = "$this$subscribeIgnoreResult"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            com.avito.android.util.rx3.Completables$a r0 = com.avito.android.util.rx3.Completables.a.a
            com.avito.android.util.rx3.Completables$b r1 = com.avito.android.util.rx3.Completables.b.a
            if (r1 == 0) goto L_0x0011
            a2.a.a.n3.z.b r2 = new a2.a.a.n3.z.b
            r2.<init>(r1)
            r1 = r2
        L_0x0011:
            io.reactivex.rxjava3.functions.Consumer r1 = (io.reactivex.rxjava3.functions.Consumer) r1
            io.reactivex.rxjava3.disposables.Disposable r3 = r3.subscribe(r0, r1)
            java.lang.String r0 = "subscribe({}, ::noOpErrorHandler)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r0)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.util.rx3.Completables.subscribeIgnoreResult(io.reactivex.rxjava3.core.Completable):io.reactivex.rxjava3.disposables.Disposable");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [a2.a.a.n3.z.b] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final io.reactivex.rxjava3.disposables.Disposable subscribeOnNext(@org.jetbrains.annotations.NotNull io.reactivex.rxjava3.core.Completable r2, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function0<kotlin.Unit> r3) {
        /*
            java.lang.String r0 = "$this$subscribeOnNext"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "onNext"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            a2.a.a.n3.z.a r0 = new a2.a.a.n3.z.a
            r0.<init>(r3)
            com.avito.android.util.rx3.Completables$c r3 = com.avito.android.util.rx3.Completables.c.a
            if (r3 == 0) goto L_0x0019
            a2.a.a.n3.z.b r1 = new a2.a.a.n3.z.b
            r1.<init>(r3)
            r3 = r1
        L_0x0019:
            io.reactivex.rxjava3.functions.Consumer r3 = (io.reactivex.rxjava3.functions.Consumer) r3
            io.reactivex.rxjava3.disposables.Disposable r2 = r2.subscribe(r0, r3)
            java.lang.String r3 = "subscribe(onNext, ::noOpErrorHandler)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.util.rx3.Completables.subscribeOnNext(io.reactivex.rxjava3.core.Completable, kotlin.jvm.functions.Function0):io.reactivex.rxjava3.disposables.Disposable");
    }
}
