package r6.a.a.d.s;

import hu.akarnokd.rxjava2.debug.validator.ProtocolNonConformanceException;
import hu.akarnokd.rxjava2.functions.PlainConsumer;
import io.reactivex.parallel.ParallelFlowable;
import org.reactivestreams.Subscriber;
import r6.a.a.d.s.d;
public final class g<T> extends ParallelFlowable<T> {
    public final ParallelFlowable<T> a;
    public final PlainConsumer<ProtocolNonConformanceException> b;

    public g(ParallelFlowable<T> parallelFlowable, PlainConsumer<ProtocolNonConformanceException> plainConsumer) {
        this.a = parallelFlowable;
        this.b = plainConsumer;
    }

    @Override // io.reactivex.parallel.ParallelFlowable
    public int parallelism() {
        return this.a.parallelism();
    }

    @Override // io.reactivex.parallel.ParallelFlowable
    public void subscribe(Subscriber<? super T>[] subscriberArr) {
        validate(subscriberArr);
        int parallelism = this.a.parallelism();
        Subscriber<? super T>[] subscriberArr2 = new Subscriber[parallelism];
        for (int i = 0; i < parallelism; i++) {
            subscriberArr2[i] = new d.a(subscriberArr[i], this.b);
        }
        this.a.subscribe(subscriberArr2);
    }
}
