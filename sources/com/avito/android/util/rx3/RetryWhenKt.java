package com.avito.android.util.rx3;

import a2.a.a.n3.z.h;
import a2.a.a.n3.z.j;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u001a}\u0010\u0013\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u00102\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\u00062\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"", "firstDelayMs", "", "maxRetries", "Lio/reactivex/rxjava3/core/Scheduler;", "scheduler", "Lkotlin/Function1;", "", "", "retryExceptions", "Lcom/avito/android/util/rx3/ErrorAndDuration;", "", "actionOnRetry", "maxDelayMs", "", "factor", "Lio/reactivex/rxjava3/functions/Function;", "Lio/reactivex/rxjava3/core/Flowable;", "", "exponentialRetry", "(JILio/reactivex/rxjava3/core/Scheduler;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Ljava/lang/Long;D)Lio/reactivex/rxjava3/functions/Function;", "rx"}, k = 2, mv = {1, 4, 2})
public final class RetryWhenKt {

    public static final class a<T1, T2, R> implements BiFunction<Throwable, Long, ErrorAndDuration> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.BiFunction
        public ErrorAndDuration apply(Throwable th, Long l) {
            Throwable th2 = th;
            Long l2 = l;
            Intrinsics.checkNotNullExpressionValue(th2, "error");
            Intrinsics.checkNotNullExpressionValue(l2, "durationMs");
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

    public static final class c<T, R> implements Function<Flowable<Throwable>, Flowable<Object>> {
        public final /* synthetic */ Flowable a;
        public final /* synthetic */ Function b;
        public final /* synthetic */ Function1 c;
        public final /* synthetic */ Scheduler d;

        public c(Flowable flowable, Function function, Function1 function1, Scheduler scheduler) {
            this.a = flowable;
            this.b = function;
            this.c = function1;
            this.d = scheduler;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v4, types: [a2.a.a.n3.z.k] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // io.reactivex.rxjava3.functions.Function
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public io.reactivex.rxjava3.core.Flowable<java.lang.Object> apply(io.reactivex.rxjava3.core.Flowable<java.lang.Throwable> r4) {
            /*
                r3 = this;
                io.reactivex.rxjava3.core.Flowable r4 = (io.reactivex.rxjava3.core.Flowable) r4
                io.reactivex.rxjava3.core.Flowable r0 = r3.a
                long r1 = com.avito.android.util.rx3.RetryWhenKt.access$getNO_MORE_DELAYS$p()
                java.lang.Long r1 = java.lang.Long.valueOf(r1)
                io.reactivex.rxjava3.core.Flowable r1 = io.reactivex.rxjava3.core.Flowable.just(r1)
                io.reactivex.rxjava3.core.Flowable r0 = r0.concatWith(r1)
                io.reactivex.rxjava3.functions.BiFunction r1 = com.avito.android.util.rx3.RetryWhenKt.access$getTO_ERROR_AND_DURATION$p()
                io.reactivex.rxjava3.core.Flowable r4 = r4.zipWith(r0, r1)
                io.reactivex.rxjava3.functions.Function r0 = r3.b
                io.reactivex.rxjava3.core.Flowable r4 = r4.flatMap(r0)
                kotlin.jvm.functions.Function1 r0 = r3.c
                kotlin.jvm.functions.Function1 r0 = com.avito.android.util.rx3.RetryWhenKt.access$callActionExceptForLast(r0)
                if (r0 == 0) goto L_0x0030
                a2.a.a.n3.z.k r1 = new a2.a.a.n3.z.k
                r1.<init>(r0)
                r0 = r1
            L_0x0030:
                io.reactivex.rxjava3.functions.Consumer r0 = (io.reactivex.rxjava3.functions.Consumer) r0
                io.reactivex.rxjava3.core.Flowable r4 = r4.doOnNext(r0)
                io.reactivex.rxjava3.core.Scheduler r0 = r3.d
                io.reactivex.rxjava3.functions.Function r0 = com.avito.android.util.rx3.RetryWhenKt.access$delay(r0)
                io.reactivex.rxjava3.core.Flowable r4 = r4.flatMap(r0)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.avito.android.util.rx3.RetryWhenKt.c.apply(java.lang.Object):java.lang.Object");
        }
    }

    public static final class d<T, R> implements Function<ErrorAndDuration, Flowable<ErrorAndDuration>> {
        public final /* synthetic */ Function1 a;

        public d(Function1 function1) {
            this.a = function1;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public Flowable<ErrorAndDuration> apply(ErrorAndDuration errorAndDuration) {
            ErrorAndDuration errorAndDuration2 = errorAndDuration;
            if (((Boolean) this.a.invoke(errorAndDuration2.getThrowable())).booleanValue()) {
                return Flowable.just(errorAndDuration2);
            }
            return Flowable.error(errorAndDuration2.getThrowable());
        }
    }

    public static final class e<T, R> implements Function<Integer, Long> {
        public final /* synthetic */ double a;
        public final /* synthetic */ long b;
        public final /* synthetic */ Long c;

        public e(double d, long j, Long l) {
            this.a = d;
            this.b = j;
            this.c = l;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public Long apply(Integer num) {
            long round = Math.round(Math.pow(this.a, (double) (num.intValue() - 1)) * ((double) this.b));
            Long l = this.c;
            if (l != null) {
                round = Math.min(l.longValue(), round);
            }
            return Long.valueOf(round);
        }
    }

    public static final Function1 access$callActionExceptForLast(Function1 function1) {
        return new h(function1);
    }

    public static final Function access$delay(Scheduler scheduler) {
        return new j(scheduler);
    }

    public static final /* synthetic */ long access$getNO_MORE_DELAYS$p() {
        return -1;
    }

    @NotNull
    public static final Function<Flowable<Throwable>, Flowable<Object>> exponentialRetry(long j, int i, @NotNull Scheduler scheduler, @NotNull Function1<? super Throwable, Boolean> function1, @NotNull Function1<? super ErrorAndDuration, Unit> function12, @Nullable Long l, double d2) {
        Intrinsics.checkNotNullParameter(scheduler, "scheduler");
        Intrinsics.checkNotNullParameter(function1, "retryExceptions");
        Intrinsics.checkNotNullParameter(function12, "actionOnRetry");
        return new c(Flowable.range(1, Integer.MAX_VALUE).map(new e(d2, j, l)).take((long) i), new d(function1), function12, scheduler);
    }

    public static /* synthetic */ Function exponentialRetry$default(long j, int i, Scheduler scheduler, Function1 function1, Function1 function12, Long l, double d2, int i2, Object obj) {
        return exponentialRetry(j, i, scheduler, function1, (i2 & 16) != 0 ? b.a : function12, (i2 & 32) != 0 ? null : l, (i2 & 64) != 0 ? 2.0d : d2);
    }
}
