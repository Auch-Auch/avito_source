package com.avito.android.util.rx;

import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0004\u001ag\u0010\u0010\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\r2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\u0006¢\u0006\u0004\b\u0010\u0010\u0011\u001a}\u0010\u0016\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\r2\u0006\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\u00062\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00002\b\b\u0002\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"", "delayMs", "", "maxRetries", "Lio/reactivex/Scheduler;", "scheduler", "Lkotlin/Function1;", "", "", "retryExceptions", "Lcom/avito/android/util/rx/ErrorAndDuration;", "", "actionOnRetry", "Lio/reactivex/functions/Function;", "Lio/reactivex/Flowable;", "", "delayedRetry", "(JILio/reactivex/Scheduler;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Lio/reactivex/functions/Function;", "firstDelayMs", "maxDelayMs", "", "factor", "exponentialRetry", "(JILio/reactivex/Scheduler;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Ljava/lang/Long;D)Lio/reactivex/functions/Function;", "rx"}, k = 2, mv = {1, 4, 2})
public final class RetryWhenKt {

    public static final class a<T1, T2, R> implements BiFunction<Throwable, Long, ErrorAndDuration> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // io.reactivex.functions.BiFunction
        public ErrorAndDuration apply(Throwable th, Long l) {
            Throwable th2 = th;
            Long l2 = l;
            Intrinsics.checkNotNullParameter(th2, "error");
            Intrinsics.checkNotNullParameter(l2, "durationMs");
            return new ErrorAndDuration(th2, l2.longValue());
        }
    }

    public static final class b extends Lambda implements Function1<ErrorAndDuration, Unit> {
        public static final b a = new b();

        public b() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(ErrorAndDuration errorAndDuration) {
            Intrinsics.checkNotNullParameter(errorAndDuration, "it");
            return Unit.INSTANCE;
        }
    }

    public static final class c<T, R> implements Function<ErrorAndDuration, Flowable<ErrorAndDuration>> {
        public final /* synthetic */ Function1 a;

        public c(Function1 function1) {
            this.a = function1;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Flowable<ErrorAndDuration> apply(ErrorAndDuration errorAndDuration) {
            ErrorAndDuration errorAndDuration2 = errorAndDuration;
            Intrinsics.checkNotNullParameter(errorAndDuration2, "e");
            if (((Boolean) this.a.invoke(errorAndDuration2.getThrowable())).booleanValue()) {
                return Flowable.just(errorAndDuration2);
            }
            return Flowable.error(errorAndDuration2.getThrowable());
        }
    }

    public static final class d<T, R> implements Function<Integer, Long> {
        public final /* synthetic */ long a;

        public d(long j) {
            this.a = j;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Long apply(Integer num) {
            Intrinsics.checkNotNullParameter(num, "it");
            return Long.valueOf(this.a);
        }
    }

    public static final class e extends Lambda implements Function1<ErrorAndDuration, Unit> {
        public static final e a = new e();

        public e() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(ErrorAndDuration errorAndDuration) {
            Intrinsics.checkNotNullParameter(errorAndDuration, "it");
            return Unit.INSTANCE;
        }
    }

    public static final class f<T, R> implements Function<ErrorAndDuration, Flowable<ErrorAndDuration>> {
        public final /* synthetic */ Function1 a;

        public f(Function1 function1) {
            this.a = function1;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Flowable<ErrorAndDuration> apply(ErrorAndDuration errorAndDuration) {
            ErrorAndDuration errorAndDuration2 = errorAndDuration;
            Intrinsics.checkNotNullParameter(errorAndDuration2, "e");
            if (((Boolean) this.a.invoke(errorAndDuration2.getThrowable())).booleanValue()) {
                return Flowable.just(errorAndDuration2);
            }
            return Flowable.error(errorAndDuration2.getThrowable());
        }
    }

    public static final class g<T, R> implements Function<Integer, Long> {
        public final /* synthetic */ double a;
        public final /* synthetic */ long b;
        public final /* synthetic */ Long c;

        public g(double d, long j, Long l) {
            this.a = d;
            this.b = j;
            this.c = l;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Long apply(Integer num) {
            Integer num2 = num;
            Intrinsics.checkNotNullParameter(num2, "n");
            long round = Math.round(Math.pow(this.a, (double) (num2.intValue() - 1)) * ((double) this.b));
            Long l = this.c;
            if (l != null) {
                round = Math.min(l.longValue(), round);
            }
            return Long.valueOf(round);
        }
    }

    public static final Function1 access$callActionExceptForLast(Function1 function1) {
        return new a2.a.a.n3.y.a(function1);
    }

    public static final Function access$delay(Scheduler scheduler) {
        return new a2.a.a.n3.y.c(scheduler);
    }

    @NotNull
    public static final Function<Flowable<Throwable>, Flowable<Object>> delayedRetry(long j, int i, @NotNull Scheduler scheduler, @NotNull Function1<? super Throwable, Boolean> function1, @NotNull Function1<? super ErrorAndDuration, Unit> function12) {
        Intrinsics.checkNotNullParameter(scheduler, "scheduler");
        Intrinsics.checkNotNullParameter(function1, "retryExceptions");
        Intrinsics.checkNotNullParameter(function12, "actionOnRetry");
        Flowable<R> take = Flowable.range(1, Integer.MAX_VALUE).map(new d(j)).take((long) i);
        c cVar = new c(function1);
        Intrinsics.checkNotNullExpressionValue(take, "delays");
        return new a2.a.a.n3.y.d(take, cVar, function12, scheduler);
    }

    public static /* synthetic */ Function delayedRetry$default(long j, int i, Scheduler scheduler, Function1 function1, Function1 function12, int i2, Object obj) {
        if ((i2 & 16) != 0) {
            function12 = b.a;
        }
        return delayedRetry(j, i, scheduler, function1, function12);
    }

    @NotNull
    public static final Function<Flowable<Throwable>, Flowable<Object>> exponentialRetry(long j, int i, @NotNull Scheduler scheduler, @NotNull Function1<? super Throwable, Boolean> function1, @NotNull Function1<? super ErrorAndDuration, Unit> function12, @Nullable Long l, double d2) {
        Intrinsics.checkNotNullParameter(scheduler, "scheduler");
        Intrinsics.checkNotNullParameter(function1, "retryExceptions");
        Intrinsics.checkNotNullParameter(function12, "actionOnRetry");
        Flowable<R> take = Flowable.range(1, Integer.MAX_VALUE).map(new g(d2, j, l)).take((long) i);
        f fVar = new f(function1);
        Intrinsics.checkNotNullExpressionValue(take, "delays");
        return new a2.a.a.n3.y.d(take, fVar, function12, scheduler);
    }

    public static /* synthetic */ Function exponentialRetry$default(long j, int i, Scheduler scheduler, Function1 function1, Function1 function12, Long l, double d2, int i2, Object obj) {
        return exponentialRetry(j, i, scheduler, function1, (i2 & 16) != 0 ? e.a : function12, (i2 & 32) != 0 ? null : l, (i2 & 64) != 0 ? 2.0d : d2);
    }
}
