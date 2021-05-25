package r6.a.b.i;

import hu.akarnokd.rxjava3.operators.BasicMergeSubscription;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
public final class v<T> extends Flowable<T> {
    public final Publisher<T>[] b;
    public final Iterable<? extends Publisher<T>> c;
    public final Comparator<? super T> d;
    public final boolean e;
    public final int f;

    public v(Publisher<T>[] publisherArr, Iterable<? extends Publisher<T>> iterable, Comparator<? super T> comparator, boolean z, int i) {
        this.b = publisherArr;
        this.c = iterable;
        this.d = comparator;
        this.e = z;
        this.f = i;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        int i;
        Publisher<T>[] publisherArr = this.b;
        if (publisherArr == null) {
            publisherArr = new Publisher[8];
            try {
                i = 0;
                for (Publisher<T> publisher : this.c) {
                    if (i == publisherArr.length) {
                        publisherArr = (Publisher[]) Arrays.copyOf(publisherArr, i << 1);
                    }
                    int i2 = i + 1;
                    Objects.requireNonNull(publisher, "a source is null");
                    publisherArr[i] = publisher;
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
