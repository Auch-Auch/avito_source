package r6.a.a.b;

import hu.akarnokd.rxjava2.basetypes.Perhaps;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.subscriptions.EmptySubscription;
import java.util.Arrays;
import org.reactivestreams.Subscriber;
import r6.a.a.b.d3;
public final class e3<T, R> extends Perhaps<R> {
    public final Iterable<? extends Perhaps<? extends T>> b;
    public final Function<? super Object[], ? extends R> c;

    public e3(Iterable<? extends Perhaps<? extends T>> iterable, Function<? super Object[], ? extends R> function) {
        this.b = iterable;
        this.c = function;
    }

    @Override // hu.akarnokd.rxjava2.basetypes.Perhaps
    public void subscribeActual(Subscriber<? super R> subscriber) {
        Perhaps<? extends T>[] perhapsArr = new Perhaps[8];
        try {
            int i = 0;
            for (Perhaps<? extends T> perhaps : this.b) {
                if (perhapsArr.length == i) {
                    perhapsArr = (Perhaps[]) Arrays.copyOf(perhapsArr, (i >> 1) + i);
                }
                int i2 = i + 1;
                perhapsArr[i] = perhaps;
                i = i2;
            }
            d3.a aVar = new d3.a(subscriber, this.c, i);
            subscriber.onSubscribe(aVar);
            aVar.l(perhapsArr, i);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptySubscription.error(th, subscriber);
        }
    }
}
