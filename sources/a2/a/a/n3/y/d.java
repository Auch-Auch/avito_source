package a2.a.a.n3.y;

import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.functions.Function;
import kotlin.jvm.functions.Function1;
public final class d<T, R> implements Function<Flowable<Throwable>, Flowable<Object>> {
    public final /* synthetic */ Flowable a;
    public final /* synthetic */ Function b;
    public final /* synthetic */ Function1 c;
    public final /* synthetic */ Scheduler d;

    public d(Flowable flowable, Function function, Function1 function1, Scheduler scheduler) {
        this.a = flowable;
        this.b = function;
        this.c = function1;
        this.d = scheduler;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v4, types: [a2.a.a.n3.y.e] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // io.reactivex.functions.Function
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public io.reactivex.Flowable<java.lang.Object> apply(io.reactivex.Flowable<java.lang.Throwable> r4) {
        /*
            r3 = this;
            io.reactivex.Flowable r4 = (io.reactivex.Flowable) r4
            java.lang.String r0 = "errors"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            io.reactivex.Flowable r0 = r3.a
            r1 = -1
            java.lang.Long r1 = java.lang.Long.valueOf(r1)
            io.reactivex.Flowable r1 = io.reactivex.Flowable.just(r1)
            io.reactivex.Flowable r0 = r0.concatWith(r1)
            io.reactivex.functions.BiFunction r1 = com.avito.android.util.rx.RetryWhenKt.access$getTO_ERROR_AND_DURATION$p()
            io.reactivex.Flowable r4 = r4.zipWith(r0, r1)
            io.reactivex.functions.Function r0 = r3.b
            io.reactivex.Flowable r4 = r4.flatMap(r0)
            kotlin.jvm.functions.Function1 r0 = r3.c
            kotlin.jvm.functions.Function1 r0 = com.avito.android.util.rx.RetryWhenKt.access$callActionExceptForLast(r0)
            if (r0 == 0) goto L_0x0033
            a2.a.a.n3.y.e r1 = new a2.a.a.n3.y.e
            r1.<init>(r0)
            r0 = r1
        L_0x0033:
            io.reactivex.functions.Consumer r0 = (io.reactivex.functions.Consumer) r0
            io.reactivex.Flowable r4 = r4.doOnNext(r0)
            io.reactivex.Scheduler r0 = r3.d
            io.reactivex.functions.Function r0 = com.avito.android.util.rx.RetryWhenKt.access$delay(r0)
            io.reactivex.Flowable r4 = r4.flatMap(r0)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.a.a.n3.y.d.apply(java.lang.Object):java.lang.Object");
    }
}
