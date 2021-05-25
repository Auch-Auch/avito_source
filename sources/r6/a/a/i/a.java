package r6.a.a.i;

import hu.akarnokd.rxjava2.operators.BasicMergeSubscription;
import io.reactivex.Flowable;
import io.reactivex.parallel.ParallelFlowable;
import java.util.Comparator;
import org.reactivestreams.Subscriber;
public final class a<T> extends Flowable<T> {
    public final ParallelFlowable<T> b;
    public final Comparator<? super T> c;
    public final boolean d;
    public final int e;

    public a(ParallelFlowable<T> parallelFlowable, Comparator<? super T> comparator, boolean z, int i) {
        this.b = parallelFlowable;
        this.c = comparator;
        this.d = z;
        this.e = i;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        BasicMergeSubscription basicMergeSubscription = new BasicMergeSubscription(subscriber, this.c, this.b.parallelism(), this.e, this.d);
        subscriber.onSubscribe(basicMergeSubscription);
        basicMergeSubscription.subscribe(this.b);
    }
}
