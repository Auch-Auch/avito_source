package r6.a.a.b;

import hu.akarnokd.rxjava2.basetypes.Solo;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.EmptySubscription;
import java.util.Arrays;
import java.util.Iterator;
import org.reactivestreams.Subscriber;
import r6.a.a.b.c4;
import r6.a.a.b.v4;
public final class w4<T, R> extends Solo<R> implements Function<T, R> {
    public final Iterable<? extends Solo<? extends T>> b;
    public final Function<? super Object[], ? extends R> c;

    public w4(Iterable<? extends Solo<? extends T>> iterable, Function<? super Object[], ? extends R> function) {
        this.b = iterable;
        this.c = function;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object[], java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // io.reactivex.functions.Function
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public R apply(T r4) throws java.lang.Exception {
        /*
            r3 = this;
            io.reactivex.functions.Function<? super java.lang.Object[], ? extends R> r0 = r3.c
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r2 = 0
            r1[r2] = r4
            java.lang.Object r4 = r0.apply(r1)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: r6.a.a.b.w4.apply(java.lang.Object):java.lang.Object");
    }

    @Override // hu.akarnokd.rxjava2.basetypes.Solo
    public void subscribeActual(Subscriber<? super R> subscriber) {
        Solo<? extends T>[] soloArr = new Solo[8];
        try {
            Iterator<? extends Solo<? extends T>> it = this.b.iterator();
            int i = 0;
            while (it.hasNext()) {
                Solo solo = (Solo) it.next();
                if (i == soloArr.length) {
                    soloArr = (Solo[]) Arrays.copyOf(soloArr, (i >> 1) + i);
                }
                int i2 = i + 1;
                soloArr[i] = (Solo) ObjectHelper.requireNonNull(solo, "One of the source Solo is null");
                i = i2;
            }
            if (i == 0) {
                EmptySubscription.complete(subscriber);
            } else if (i == 1) {
                soloArr[0].subscribe(new c4.a(subscriber, this));
            } else {
                v4.a aVar = new v4.a(subscriber, this.c, i);
                subscriber.onSubscribe(aVar);
                aVar.h(soloArr, i);
            }
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptySubscription.error(th, subscriber);
        }
    }
}
