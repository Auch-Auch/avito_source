package r6.a.a.h;

import hu.akarnokd.rxjava2.operators.BasicMergeSubscription;
import io.reactivex.Flowable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.EmptySubscription;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
public final class q<T> extends Flowable<T> {
    public final Publisher<T>[] b;
    public final Iterable<? extends Publisher<T>> c;
    public final Comparator<? super T> d;
    public final boolean e;
    public final int f;

    public q(Publisher<T>[] publisherArr, Iterable<? extends Publisher<T>> iterable, Comparator<? super T> comparator, boolean z, int i) {
        this.b = publisherArr;
        this.c = iterable;
        this.d = comparator;
        this.e = z;
        this.f = i;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        int i;
        Publisher<T>[] publisherArr = this.b;
        if (publisherArr == null) {
            publisherArr = new Publisher[8];
            try {
                Iterator<? extends Publisher<T>> it = this.c.iterator();
                i = 0;
                while (it.hasNext()) {
                    Publisher publisher = (Publisher) it.next();
                    if (i == publisherArr.length) {
                        publisherArr = (Publisher[]) Arrays.copyOf(publisherArr, i << 1);
                    }
                    int i2 = i + 1;
                    publisherArr[i] = (Publisher) ObjectHelper.requireNonNull(publisher, "a source is null");
                    i = i2;
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                EmptySubscription.error(th, subscriber);
                return;
            }
        } else {
            i = publisherArr.length;
        }
        if (i == 0) {
            EmptySubscription.complete(subscriber);
        } else if (i == 1) {
            publisherArr[0].subscribe(subscriber);
        } else {
            BasicMergeSubscription basicMergeSubscription = new BasicMergeSubscription(subscriber, this.d, i, this.f, this.e);
            subscriber.onSubscribe(basicMergeSubscription);
            basicMergeSubscription.subscribe(publisherArr, i);
        }
    }
}
