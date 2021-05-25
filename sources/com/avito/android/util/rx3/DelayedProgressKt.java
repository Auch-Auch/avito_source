package com.avito.android.util.rx3;

import com.avito.android.util.rx3.DelayedProgress;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aG\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b0\u0007\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\n\u001aG\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b0\u0007\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00072\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\u000b¨\u0006\f"}, d2 = {"T", "Lio/reactivex/rxjava3/core/Single;", "Lio/reactivex/rxjava3/core/Scheduler;", "scheduler", "", "initialDelayMs", "minLoadingDelayMs", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/util/rx3/DelayedProgress;", "toDelayedProgress", "(Lio/reactivex/rxjava3/core/Single;Lio/reactivex/rxjava3/core/Scheduler;JJ)Lio/reactivex/rxjava3/core/Observable;", "(Lio/reactivex/rxjava3/core/Observable;Lio/reactivex/rxjava3/core/Scheduler;JJ)Lio/reactivex/rxjava3/core/Observable;", "rx"}, k = 2, mv = {1, 4, 2})
public final class DelayedProgressKt {

    public static final class a<T, R> implements Function<T, DelayedProgress<? extends T>> {
        public static final a a = new a();

        @Override // io.reactivex.rxjava3.functions.Function
        public Object apply(Object obj) {
            return new DelayedProgress.Loaded(obj);
        }
    }

    public static final class b<T, R> implements Function<Throwable, DelayedProgress<? extends T>> {
        public static final b a = new b();

        @Override // io.reactivex.rxjava3.functions.Function
        public Object apply(Throwable th) {
            Throwable th2 = th;
            Intrinsics.checkNotNullExpressionValue(th2, "error");
            return new DelayedProgress.Error(th2);
        }
    }

    public static final class c<T, R> implements Function<Long, DelayedProgress<? extends T>> {
        public static final c a = new c();

        @Override // io.reactivex.rxjava3.functions.Function
        public Object apply(Long l) {
            return DelayedProgress.Loading.INSTANCE;
        }
    }

    public static final class d<T> implements Predicate<DelayedProgress<? extends T>> {
        public static final d a = new d();

        @Override // io.reactivex.rxjava3.functions.Predicate
        public boolean test(Object obj) {
            return !(((DelayedProgress) obj) instanceof DelayedProgress.Loading);
        }
    }

    public static final class e<T, R> implements Function<DelayedProgress<? extends T>, ObservableSource<? extends DelayedProgress<? extends T>>> {
        public final /* synthetic */ long a;
        public final /* synthetic */ Scheduler b;

        public e(long j, Scheduler scheduler) {
            this.a = j;
            this.b = scheduler;
        }

        @Override // io.reactivex.rxjava3.functions.Function
        public Object apply(Object obj) {
            DelayedProgress delayedProgress = (DelayedProgress) obj;
            if (!(delayedProgress instanceof DelayedProgress.Loading)) {
                return Observable.just(delayedProgress);
            }
            Observable just = Observable.just(delayedProgress);
            Intrinsics.checkNotNullExpressionValue(just, "Observable.just(state)");
            Observable<T> concatWith = just.concatWith(Completable.timer(this.a, TimeUnit.MILLISECONDS, this.b));
            Intrinsics.checkNotNullExpressionValue(concatWith, "concatWith(Completable.t…(delay, unit, scheduler))");
            return concatWith;
        }
    }

    @NotNull
    public static final <T> Observable<DelayedProgress<T>> toDelayedProgress(@NotNull Single<T> single, @NotNull Scheduler scheduler, long j, long j2) {
        Intrinsics.checkNotNullParameter(single, "$this$toDelayedProgress");
        Intrinsics.checkNotNullParameter(scheduler, "scheduler");
        Observable<T> observable = single.toObservable();
        Intrinsics.checkNotNullExpressionValue(observable, "this.toObservable()");
        return toDelayedProgress(observable, scheduler, j, j2);
    }

    public static /* synthetic */ Observable toDelayedProgress$default(Single single, Scheduler scheduler, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            scheduler = Schedulers.computation();
            Intrinsics.checkNotNullExpressionValue(scheduler, "Schedulers.computation()");
        }
        if ((i & 2) != 0) {
            j = 300;
        }
        if ((i & 4) != 0) {
            j2 = 1000;
        }
        return toDelayedProgress(single, scheduler, j, j2);
    }

    @NotNull
    public static final <T> Observable<DelayedProgress<T>> toDelayedProgress(@NotNull Observable<T> observable, @NotNull Scheduler scheduler, long j, long j2) {
        Intrinsics.checkNotNullParameter(observable, "$this$toDelayedProgress");
        Intrinsics.checkNotNullParameter(scheduler, "scheduler");
        Observable<R> concatMap = observable.observeOn(scheduler).map(a.a).onErrorReturn(b.a).mergeWith(Observable.timer(j, TimeUnit.MILLISECONDS, scheduler).map(c.a)).takeUntil(d.a).concatMap(new e(j2, scheduler));
        Intrinsics.checkNotNullExpressionValue(concatMap, "observeOn(scheduler)\n   …)\n            }\n        }");
        return concatMap;
    }

    public static /* synthetic */ Observable toDelayedProgress$default(Observable observable, Scheduler scheduler, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            scheduler = Schedulers.computation();
            Intrinsics.checkNotNullExpressionValue(scheduler, "Schedulers.computation()");
        }
        if ((i & 2) != 0) {
            j = 300;
        }
        if ((i & 4) != 0) {
            j2 = 1000;
        }
        return toDelayedProgress(observable, scheduler, j, j2);
    }
}
