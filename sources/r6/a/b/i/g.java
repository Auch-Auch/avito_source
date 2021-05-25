package r6.a.b.i;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableTransformer;
import io.reactivex.rxjava3.processors.AsyncProcessor;
import java.util.concurrent.atomic.AtomicBoolean;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
public final class g<T> extends Flowable<T> implements FlowableTransformer<T, T> {
    public final Publisher<T> b;
    public final AsyncProcessor<T> c = AsyncProcessor.create();
    public final AtomicBoolean d = new AtomicBoolean();

    public g(Publisher<T> publisher) {
        this.b = publisher;
    }

    @Override // io.reactivex.rxjava3.core.FlowableTransformer
    public Publisher<T> apply(Flowable<T> flowable) {
        return new g(flowable);
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.c.subscribe(subscriber);
        AtomicBoolean atomicBoolean = this.d;
        if (!atomicBoolean.get() && atomicBoolean.compareAndSet(false, true)) {
            this.b.subscribe(this.c);
        }
    }
}
