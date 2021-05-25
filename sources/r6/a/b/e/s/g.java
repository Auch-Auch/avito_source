package r6.a.b.e.s;

import hu.akarnokd.rxjava3.debug.validator.ProtocolNonConformanceException;
import hu.akarnokd.rxjava3.functions.PlainConsumer;
import io.reactivex.rxjava3.parallel.ParallelFlowable;
import org.reactivestreams.Subscriber;
import r6.a.b.e.s.d;
public final class g<T> extends ParallelFlowable<T> {
    public final ParallelFlowable<T> a;
    public final PlainConsumer<ProtocolNonConformanceException> b;

    public g(ParallelFlowable<T> parallelFlowable, PlainConsumer<ProtocolNonConformanceException> plainConsumer) {
        this.a = parallelFlowable;
        this.b = plainConsumer;
    }

    @Override // io.reactivex.rxjava3.parallel.ParallelFlowable
    public int parallelism() {
        return this.a.parallelism();
    }

    @Override // io.reactivex.rxjava3.parallel.ParallelFlowable
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
